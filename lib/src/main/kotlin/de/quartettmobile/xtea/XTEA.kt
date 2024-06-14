package de.quartettmobile.xtea

@Suppress("detekt:MagicNumber")
object XTEA {

    private const val DEFAULT_DELTA: UInt = 0x9E3779B9u
    private const val DEFAULT_NUMBER_OF_ROUNDS: Int = 32

    fun encipher(
        data: Data,
        key: Key,
        delta: UInt = DEFAULT_DELTA,
        numberOfRounds: Int = DEFAULT_NUMBER_OF_ROUNDS
    ): Data {
        var v0: UInt = data.v0
        var v1: UInt = data.v1
        var sum = 0u
        for (i in 0 until numberOfRounds) {
            v0 += (((v1 shl 4) xor (v1 shr 5)) + v1) xor (sum + key[sum.and3])
            sum += delta
            v1 += (((v0 shl 4) xor (v0 shr 5)) + v0 xor sum + key[(sum shr 11).and3])
        }
        return Data(v0, v1)
    }

    fun decipher(
        data: Data,
        key: Key,
        delta: UInt = DEFAULT_DELTA,
        numberOfRounds: Int = DEFAULT_NUMBER_OF_ROUNDS
    ): Data {
        var v0: UInt = data.v0
        var v1: UInt = data.v1
        var sum: UInt = delta * numberOfRounds.toUInt()
        for (i in 0 until numberOfRounds) {
            v1 -= (((v0 shl 4) xor (v0 shr 5)) + v0) xor (sum + key[(sum shr 11).and3])
            sum -= delta
            v0 -= (((v1 shl 4) xor (v1 shr 5)) + v1) xor (sum + key[sum.and3])
        }
        return Data(v0, v1)
    }

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

    data class Data(
        val v0: UInt,
        val v1: UInt
    )
}

/**
 * Bitwise and with 3 (0b11) just takes the 2 lowest bits of the number
 */
internal val UInt.and3: Int
    get() = (this and 3u).toInt()
