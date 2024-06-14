# XTEA Kotlin implementation
## Summary
Simple kotlin implementation of the [XTEA(eXtended TEA)](https://en.wikipedia.org/wiki/XTEA) encryption algorithm. 

## Usage
Add the following dependency into the `dependencies` section of your `build.gradle.kts`
``` kotlin
        implementation("de.quartettmobile.xtea-kt:xtea-kt:1.0")
```
Use the `XTEA` object to encipher/decipher data.
``` kotlin
        val key = XTEA.Key(k0 = 0xf5ff9b28u, k1 = 0xdc32c866u, k2 = 0xe65d0706u, k3 = 0xf6a2189cu)
        val data = XTEA.Data(v0 = 0x646d1ff0u, v1 = 0x4ff2dd13u)
        val enciphered = XTEA.encipher(data = data, key = key)
        ...
        val deciphered = XTEA.decipher(data = enciphered, key = key)
```
