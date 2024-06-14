package de.quartettmobile.xtea

import kotlin.test.Test
import kotlin.test.assertEquals

class TestVectorTest {

    @Test
    fun `verify the sample vector`() {
        testVector.forEach {
            testTheItem(it)
        }
    }

    private fun testTheItem(testItem: TestItem) {
        // given
        val data = testItem.plaintext.toXTEAData
        val key = testItem.key.toXTEAKey
        val expectedEnciphered = testItem.ciphertext.toXTEAData

        // when
        val enciphered = XTEA.encipher(data = data, key = key)
        val deciphered = XTEA.decipher(data = enciphered, key = key)

        // then
        assertEquals(
            expected = expectedEnciphered,
            actual = enciphered,
            message = "Enciphered assertion failed for ${testItem.plaintext}"
        )
        assertEquals(expected = data,
            actual = deciphered,
            message = "Deciphered assertion failed for ${testItem.plaintext}"
        )
    }

    data class TestItem(
        val key: String,
        val plaintext: String,
        val ciphertext: String
    )

    private val testVector: List<TestItem> = listOf(
        TestItem(
            key = "f5ff9b28dc32c866e65d0706f6a2189c",
            plaintext = "646d1ff04ff2dd13",
            ciphertext = "7d8800c594531b78"
        ),
        TestItem(
            key = "8f2823a1cf355e83ea354ce6b25f45ae",
            plaintext = "aab2a57f70c7e9a4",
            ciphertext = "0144bf5ba586b239"
        ),
        TestItem(
            key = "736b17a999f7325511fa76b48eeaf936",
            plaintext = "105a18405b3564ee",
            ciphertext = "ce7f4f5e093dd2bf"
        ),
        TestItem(
            key = "3d1fdfe52b00ee36796f0d7bfb044b78",
            plaintext = "63300241a6db0dd6",
            ciphertext = "e23cedf1812d1543"
        ),
        TestItem(
            key = "c5946b8a56f57596cb4431c1047b3d2b",
            plaintext = "67c3a0de8efd8158",
            ciphertext = "5a1ee8d7599efb85"
        ),
        TestItem(
            key = "72b43ba380b9d2166c898d3fb673eb4b",
            plaintext = "e31cf523518f4573",
            ciphertext = "67e026845c08a51a"
        ),
        TestItem(
            key = "f23f172ebe169dc452fbae7bbbc1e280",
            plaintext = "ebb63b7ca0d1ab68",
            ciphertext = "23211e2bd801cf95"
        ),
        TestItem(
            key = "fa9c361e59b7af8f131aa32acb0b60ff",
            plaintext = "b71c4830a82bebef",
            ciphertext = "b15d7773b0535f9e"
        ),
        TestItem(
            key = "2fc67b84cf33ba7ae6419648d5893f17",
            plaintext = "87cb0c784a582741",
            ciphertext = "6fbf16b67fc241df"
        ),
        TestItem(
            key = "7ce53368cba6e514a5ed793b127b69c1",
            plaintext = "65b1d03c77ab0434",
            ciphertext = "3d9174dd769b8ff6"
        ),
        TestItem(
            key = "4fd7e71fa3714e361ef6e3925ed017f2",
            plaintext = "c13da6adcafe44b4",
            ciphertext = "19b9306521207250"
        ),
        TestItem(
            key = "954f0b1962ce9d242fb47b0992fb7a7c",
            plaintext = "40daf05ecfaafb64",
            ciphertext = "4baef507a648b9a9"
        ),
        TestItem(
            key = "7a00cb876e3e2e7c7cd05e03aca767bb",
            plaintext = "3096fb89a803ad26",
            ciphertext = "244b577d3515f0d0"
        ),
        TestItem(
            key = "271c41413f194c94c90fc49b09a10f76",
            plaintext = "80da53a0e1e352df",
            ciphertext = "db2b0272e7dd3c30"
        ),
        TestItem(
            key = "20511ed0c936f93d3d5f08f404530883",
            plaintext = "2f2ad35eb82942b3",
            ciphertext = "58dd949a224eeb3a"
        ),
        TestItem(
            key = "ed96cd9a8122900a0f27a578ad1ae93c",
            plaintext = "907890f3265e7587",
            ciphertext = "461cecdb4b9ff413"
        ),
        TestItem(
            key = "2e518d6b2f2d7379744cb8217fef74c9",
            plaintext = "d1aaa1fc62451492",
            ciphertext = "265823a06f08e351"
        ),
        TestItem(
            key = "52879500e3881cc6cd1a6c0033104ac2",
            plaintext = "a8f86d67c2b69c41",
            ciphertext = "234e7621219dad7d"
        ),
        TestItem(
            key = "818d803cc6937522580bfea02dda93bd",
            plaintext = "170b8b7e1ff8ecba",
            ciphertext = "d20e4e3220130bea"
        ),
        TestItem(
            key = "82e36925a6bed8a7fb7edcfb10643cc4",
            plaintext = "9efee09b2996f5be",
            ciphertext = "4a0b1e5d39860b6f"
        ),
        TestItem(
            key = "9af20aeb628a8643dc3c7c13792154c5",
            plaintext = "5f006d6246cddac4",
            ciphertext = "614030a5e8799391"
        ),
        TestItem(
            key = "bfeab27fafac8d6bea3a7b71fd9cda72",
            plaintext = "f7af9f7101c1757a",
            ciphertext = "75c4b6488aa261cc"
        ),
        TestItem(
            key = "923f467dc6d6e1607f031c1bcf30be3e",
            plaintext = "1d488fde08f38011",
            ciphertext = "dbc5ca8196c3677d"
        ),
        TestItem(
            key = "f7fe0883f344cb38beebd4bbc0ae5b4b",
            plaintext = "433ce10548d74e03",
            ciphertext = "46359e1a5382f068"
        ),
        TestItem(
            key = "4fcf2c242cf6bf1d64966c0f7b0b3386",
            plaintext = "cf11a371b7e3712e",
            ciphertext = "c6fd0fccb2064ef8"
        ),
        TestItem(
            key = "96665c17116a3e5a1e2884d9276aae48",
            plaintext = "a92c61dfb926da7d",
            ciphertext = "b2b4fe51cc96e525"
        ),
        TestItem(
            key = "f7ef9455059d8f24a43ecaecd341c638",
            plaintext = "2dae2eb64d27f077",
            ciphertext = "166ab2e28983ebeb"
        ),
        TestItem(
            key = "975118433f540c4d29cfb70557d45a3c",
            plaintext = "c08ee9666abc6b65",
            ciphertext = "90ff1fc5e1bd8344"
        ),
        TestItem(
            key = "a310be1a04d36242e10ab78e96f166b8",
            plaintext = "9fdf507f2b87d5f9",
            ciphertext = "47abe0bcf0bb3027"
        ),
        TestItem(
            key = "e0408d296ab6ebfdaab0368645960779",
            plaintext = "9f6cc596b9f7ea94",
            ciphertext = "bff421fa4a6a44d2"
        ),
        TestItem(
            key = "560712a957f819d31d76e11f960437f1",
            plaintext = "f3f3da2120d5289b",
            ciphertext = "b4c92991b7939503"
        ),
        TestItem(
            key = "cd30193697f28d4b8fc2d3c883dd96b5",
            plaintext = "36a650f368e5aa85",
            ciphertext = "4fa3c3dd97b3dbe5"
        ),
        TestItem(
            key = "2fa2093336ea605fcc4abdce93f6ba5c",
            plaintext = "4ef9860baba10c7f",
            ciphertext = "60a46d01145a1b2e"
        ),
        TestItem(
            key = "0cac84988e82a3d2953871ac3fdb692e",
            plaintext = "dd87d6bf059c04d9",
            ciphertext = "66893577941d818b"
        ),
        TestItem(
            key = "dcd5af00a1935f8326e85bc26960e243",
            plaintext = "61443e9c84126aa4",
            ciphertext = "ee0595950467582d"
        ),
        TestItem(
            key = "ab2002f2b8f468e9479caf1b8725ae0a",
            plaintext = "2c52096a8edc8c1a",
            ciphertext = "4709f7c179e9834a"
        ),
        TestItem(
            key = "51b967ba63159714c05110506c83fd46",
            plaintext = "df878934572175cf",
            ciphertext = "360a1c6d07ff0a52"
        ),
        TestItem(
            key = "6e92df4d479fb8eb284b80e0d03f8903",
            plaintext = "0df60f495338f4be",
            ciphertext = "0871bb0d77ffcee3"
        ),
        TestItem(
            key = "b99a3a085de069815c1d796b111aeb1d",
            plaintext = "2dc5498bd17710aa",
            ciphertext = "de42d01f278e82b8"
        ),
        TestItem(
            key = "641f065096642fb42d7c2fb5b9846643",
            plaintext = "0d45e98a1dfcd96e",
            ciphertext = "32d16a4c8b021a18"
        ),
        TestItem(
            key = "ab60ac5d00e73177ffa9b55bd0b04d9e",
            plaintext = "5a4fd140df2fb92d",
            ciphertext = "278db8dcc88f8d4b"
        ),
        TestItem(
            key = "bb5932b2d2aa986e701ece9d0bb75f8b",
            plaintext = "f9d8d9668f1a9e87",
            ciphertext = "0b507e62ce6dcbc4"
        ),
        TestItem(
            key = "9f8b3611193ca4ca43b5c4b048b76400",
            plaintext = "50203fb434c2ed3b",
            ciphertext = "97a608747a8518cd"
        ),
        TestItem(
            key = "d2ec6feed8ea548c21cf4d730275f699",
            plaintext = "a8e34796cc5ca8df",
            ciphertext = "92e1051fc6873f02"
        ),
        TestItem(
            key = "a1fca8afd351d891eeb9ba78a2a93560",
            plaintext = "4ac066170b4e9c8f",
            ciphertext = "40b34998fd302751"
        ),
        TestItem(
            key = "8faaa73860f23e15bf1afbc2d1d018ca",
            plaintext = "14434209581b0bca",
            ciphertext = "08fa8241d67e4ec5"
        ),
        TestItem(
            key = "47de2590f819aa92c12dfeae3a65fe83",
            plaintext = "880973c12d85fbd8",
            ciphertext = "c28e1605ad251a4b"
        ),
        TestItem(
            key = "f150eaae5a35f924875b6fd66242affd",
            plaintext = "ae00b3d642b4425f",
            ciphertext = "aec666fd9959689f"
        ),
        TestItem(
            key = "dfd593a7795013df940786f47a1a56dd",
            plaintext = "40f62ec534853d21",
            ciphertext = "dcf68b863b6eff9d"
        ),
        TestItem(
            key = "e73f72d1975f88af2b6406115c5734ba",
            plaintext = "f2817b6f810ac7f6",
            ciphertext = "086d745412c7ef29"
        ),
        TestItem(
            key = "eccfe99d302548c0a1a8198309e870d0",
            plaintext = "d7c8ccc210c86175",
            ciphertext = "ffc626f318160565"
        ),
        TestItem(
            key = "61664235aa642a86c6450c8269271592",
            plaintext = "37b1d3169d4623f4",
            ciphertext = "c84d2cea58a71c1e"
        ),
        TestItem(
            key = "d19ef01fe38d09d21f82ae6123958937",
            plaintext = "4fc58ffbc886f7c2",
            ciphertext = "effff8656dbc2540"
        ),
        TestItem(
            key = "a7a513760e5dce9d0d612eb2b70287c7",
            plaintext = "cb60bf9391186cc9",
            ciphertext = "aa9c5931fd606ffd"
        ),
        TestItem(
            key = "cdac70758a71aa6f12b362d4497ada25",
            plaintext = "02c10ca984b2ccfc",
            ciphertext = "6df02e478f2cb345"
        ),
        TestItem(
            key = "e8dfb56d8b684d8cc91815c0bf7c152d",
            plaintext = "3e0fc925efc72638",
            ciphertext = "616b89cd9217b8c1"
        ),
        TestItem(
            key = "2aff7356d40bc04f5fcc13151cfb04e9",
            plaintext = "8fc21a8fcadb6184",
            ciphertext = "547c7087e411470d"
        ),
        TestItem(
            key = "150649a2d5c292568444c0af4417eb52",
            plaintext = "fc77b2b84338ded8",
            ciphertext = "f356fb92a27e09f5"
        ),
        TestItem(
            key = "b0d733f9e69d106f25146e4885bb7754",
            plaintext = "13f866cd0735a7ca",
            ciphertext = "6f69c2c218c7165f"
        ),
        TestItem(
            key = "ee51990375741b6881cf98fc9ddecfdc",
            plaintext = "2000b357bc4640da",
            ciphertext = "a29b71f58fbd2526"
        ),
        TestItem(
            key = "5e190b6e64cfed30497df8aa18e1403d",
            plaintext = "9a4689f750067030",
            ciphertext = "7e7459440096f8d9"
        ),
        TestItem(
            key = "5cf322d5ebb5b6e4ef9497753515ae32",
            plaintext = "866e55e3078f5a0b",
            ciphertext = "7c18d0c1b3e5e490"
        ),
        TestItem(
            key = "5ad2b82eb4fa39c2528cd00ab892c743",
            plaintext = "d7a0566868b22630",
            ciphertext = "49d214bdc3ab971f"
        ),
        TestItem(
            key = "ff7999e9125f6e1e60dddd485158825d",
            plaintext = "210023037d14cf1b",
            ciphertext = "7f7122df54f6f293"
        ),
        TestItem(
            key = "2710c5ef808516c17673967c7dfcdbd3",
            plaintext = "127d12d203b012c0",
            ciphertext = "5c4121dd31dc8cf8"
        ),
        TestItem(
            key = "0a28d412c699246477b19559135a252e",
            plaintext = "8d45b95e7fd53e1e",
            ciphertext = "8bb6c8b33f06ccd4"
        ),
        TestItem(
            key = "1848c9bb7cb7dc1ff3a3b74bd51bbf6c",
            plaintext = "609da5184ba187f4",
            ciphertext = "2032e49685d31b8c"
        ),
        TestItem(
            key = "4d868fd5c3107d04df3471d8be86fda2",
            plaintext = "e6e6f8061fae5452",
            ciphertext = "0425aa0a4b0c990e"
        ),
        TestItem(
            key = "0397464268275444a111aa2ee888af21",
            plaintext = "1966f15fa3ccd9e3",
            ciphertext = "f69619b7891f26ad"
        ),
        TestItem(
            key = "9259e461cef14c8a825fda113acc4b84",
            plaintext = "daa04f3603c23b21",
            ciphertext = "d5a5ba5ddcd4ec35"
        ),
        TestItem(
            key = "39127c6e56092c73c76d48bd408b205e",
            plaintext = "84102162a93d18ce",
            ciphertext = "b133e2fa5b3a4a3c"
        ),
        TestItem(
            key = "2b608fc119e3a949f94c3c84d9c3df54",
            plaintext = "fcb2fb3f85a09068",
            ciphertext = "56e2381f4786736d"
        ),
        TestItem(
            key = "b4702c372faade6e2d8e0a25a7adf4ed",
            plaintext = "d6e4c80480c5207d",
            ciphertext = "a40daf6a4b187816"
        ),
        TestItem(
            key = "cbf6274ee24c9f1b414ef9365b82e366",
            plaintext = "5a098dbd1d742df9",
            ciphertext = "7ed2a9c4f7d65416"
        ),
        TestItem(
            key = "914019b7734d675b7153291952187a3a",
            plaintext = "5ddb152a4e26b0eb",
            ciphertext = "b98c2070e4c814aa"
        ),
        TestItem(
            key = "93f10e695d13aa6bae2d28492e4d5a4c",
            plaintext = "504f99100273a45d",
            ciphertext = "5ac8a2e1737e947f"
        ),
        TestItem(
            key = "bffa5a803fa42fe79c37d80b3eec17d5",
            plaintext = "f7be5dc9029de425",
            ciphertext = "9ca921d9cbc3b059"
        ),
        TestItem(
            key = "6ff27769d22bee7123a180c9f86d3678",
            plaintext = "9d3e720a0dd74cdd",
            ciphertext = "a0472f8b70c1aa62"
        ),
        TestItem(
            key = "f8214f2b933839abf6dbe79bd9e53137",
            plaintext = "c72cfc3c5910456d",
            ciphertext = "17265188dfc0c6b5"
        ),
        TestItem(
            key = "a16aa2d008215abe8276b3c8596dcf1b",
            plaintext = "b55d4be3e091c6c2",
            ciphertext = "7c16aee660e6f688"
        ),
        TestItem(
            key = "eeb80d33d3efe5ce19bf834de380bec7",
            plaintext = "2aaaccda22203da5",
            ciphertext = "ff53a305162b2ec6"
        ),
        TestItem(
            key = "9c9130c4e3ea23fb60758fabecfac653",
            plaintext = "57753274460df3da",
            ciphertext = "f2176c2e2368ec44"
        ),
        TestItem(
            key = "c94ccd028cf988ea4373a88195e5121e",
            plaintext = "e5075ac7bf6418e9",
            ciphertext = "de10cd4da6c16580"
        ),
        TestItem(
            key = "159148bb4b3be3ecfb675fc58ea3c484",
            plaintext = "61f9c6a3dc2f883d",
            ciphertext = "162483bea1d62066"
        ),
        TestItem(
            key = "cfd6c04b7a5b1033ef7e9b9e02cfc989",
            plaintext = "a2584109ee01897d",
            ciphertext = "c6f920533af0b0a1"
        ),
        TestItem(
            key = "5729eb774fa4c4ba6f6c2c23e1c35d04",
            plaintext = "e3a5111befd8d14f",
            ciphertext = "3ac15bbb00a07493"
        ),
        TestItem(
            key = "63a8b49aca655bd4a433bf8fbdc646cf",
            plaintext = "9dc743dcc8ec9be8",
            ciphertext = "e3fe3adfa89512d3"
        ),
        TestItem(
            key = "d502033489a8cb7026e4eda911ca3ffd",
            plaintext = "70881f3fa733b808",
            ciphertext = "1b05a984e0abff21"
        ),
        TestItem(
            key = "33b716289b4af29b0fc00372bacb7d33",
            plaintext = "99748649090b405f",
            ciphertext = "8883447a3bf5cd2b"
        ),
        TestItem(
            key = "04f1361fc22335c59031da5cd72ecd8e",
            plaintext = "bbcece5f63fee272",
            ciphertext = "42c8c9d914958e47"
        ),
        TestItem(
            key = "ab7266f2c91c02d74eaa7a8e78d8eabb",
            plaintext = "17acfff3907c8d67",
            ciphertext = "616e2743c5364316"
        ),
        TestItem(
            key = "697b5f09d82b9f1b13848e00be401e32",
            plaintext = "6078792a661f5871",
            ciphertext = "03adc81f3fac56ab"
        ),
        TestItem(
            key = "af751e0bec65047f8e07f2845e5c10b0",
            plaintext = "c8b4573328437fb4",
            ciphertext = "e6ae92a4b7bf2efd"
        ),
        TestItem(
            key = "f0c1305bdebf40c6430642e5a41d5464",
            plaintext = "01442b66b2b55fc9",
            ciphertext = "69c9ffb60df75af6"
        ),
        TestItem(
            key = "8846532f9cb23096d7a3bbc864f7af68",
            plaintext = "4163b3678896db57",
            ciphertext = "2be25e708eb598a7"
        ),
        TestItem(
            key = "7e24b54b836e418f54927efc8210eb81",
            plaintext = "93107fde33f5b35c",
            ciphertext = "fbd3a31d120c8159"
        ),
        TestItem(
            key = "1d6fea9bf936f1cd245bb850f5c87941",
            plaintext = "f0dbbb8597141217",
            ciphertext = "8a60557525c1e64b"
        ),
        TestItem(
            key = "c7e1154eb74d087ace44792f6e8f97f0",
            plaintext = "f9f05c9a1e0769b2",
            ciphertext = "313df38563afaab7"
        ),
        TestItem(
            key = "6628751b6ad8c269b8f0848d126f30f0",
            plaintext = "4e8a64f5f216c31d",
            ciphertext = "9fddfa1d79d3be5f"
        ),
        TestItem(
            key = "63d72dcf8b6906c6821a4af1e01c1c7f",
            plaintext = "d132d1549a245ebc",
            ciphertext = "f43f94d414939b9b"
        )
    )
}

private val String.toXTEAKey: XTEA.Key
    get() = XTEA.Key(
        k0 = slice(IntRange(0, 7)).toUInt(16),
        k1 = slice(IntRange(8, 15)).toUInt(16),
        k2 = slice(IntRange(16, 23)).toUInt(16),
        k3 = slice(IntRange(24, 31)).toUInt(16)
    )

private val String.toXTEAData: XTEA.Data
    get() = XTEA.Data(
        v0 = slice(IntRange(0, 7)).toUInt(16),
        v1 = slice(IntRange(8, 15)).toUInt(16)
    )

private val XTEA.Data.hexString: String
    get() = v0.toString(16).padStart(8, '0') +
            v1.toString(16).padStart(8, '0')
