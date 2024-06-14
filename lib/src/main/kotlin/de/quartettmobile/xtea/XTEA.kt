package de.quartettmobile.xtea

/**
 * Object providing the basic API to encipher and decipher data using the [XTEA algorithm](https://en.wikipedia.org/wiki/XTEA)
 */
@Suppress("detekt:MagicNumber")
object XTEA {

    private const val DELTA: UInt = 0x9E3779B9u
    private const val DEFAULT_NUMBER_OF_ROUNDS: Int = 32

    /**
     * Enciphers the given [data] using [key]
     *
     * @param numberOfRounds The number of rounds of encryption to be performed, defaults to 32 which is recommended by the reference implementation at [wikipedia](https://en.wikipedia.org/wiki/XTEA)
     */
    fun encipher(
        data: Data,
        key: Key,
        numberOfRounds: Int = DEFAULT_NUMBER_OF_ROUNDS
    ): Data {
        var v0: UInt = data.v0
        var v1: UInt = data.v1
        var sum = 0u
        for (i in 0 until numberOfRounds) {
            v0 += (((v1 shl 4) xor (v1 shr 5)) + v1) xor (sum + key[sum.and3])
            sum += DELTA
            v1 += (((v0 shl 4) xor (v0 shr 5)) + v0 xor sum + key[(sum shr 11).and3])
        }
        return Data(v0, v1)
    }

    /**
     * Deciphers the given [data] using [key]
     *
     * @param numberOfRounds The number of rounds of encryption to be performed, defaults to 32 which is recommended by the reference implementation at [wikipedia](https://en.wikipedia.org/wiki/XTEA)
     */
    fun decipher(
        data: Data,
        key: Key,
        numberOfRounds: Int = DEFAULT_NUMBER_OF_ROUNDS
    ): Data {
        var v0: UInt = data.v0
        var v1: UInt = data.v1
        var sum: UInt = DELTA * numberOfRounds.toUInt()
        for (i in 0 until numberOfRounds) {
            v1 -= (((v0 shl 4) xor (v0 shr 5)) + v0) xor (sum + key[(sum shr 11).and3])
            sum -= DELTA
            v0 -= (((v1 shl 4) xor (v1 shr 5)) + v1) xor (sum + key[sum.and3])
        }
        return Data(v0, v1)
    }

    /**
     * Holder to keep the key to be used for [XTEA] enciphering/deciphering.
     * Containing 4 parts 32 bits each.
     */
    data class Key(
        val k0: UInt,
        val k1: UInt,
        val k2: UInt,
        val k3: UInt
    ) {
        internal operator fun get(i: Int): UInt {
            return when (i) {
                0 -> k0
                1 -> k1
                2 -> k2
                3 -> k3
                else -> throw ArrayIndexOutOfBoundsException("Key only contains 4 members, member #$i does not exist")
            }
        }
    }

    /**
     * Holder to keep the data to encipher/enciphered data, to be used for [XTEA] enciphering/deciphering.
     * Containing 2 parts 32 bits each.
     */
    data class Data(
        val v0: UInt,
        val v1: UInt
    )
}

/**
 * Bitwise and operation with 3 (0b11), it just takes the 2 lowest bits of the number
 */
internal val UInt.and3: Int
    get() = (this and 3u).toInt()
