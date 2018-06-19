# Cipher


# Download
* gradle
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://www.jitpack.io' }
	}
}
```
```groovy
dependencies {
    compile 'com.github.CoderWuao:cipher:x.x.x'
}
```
* maven
```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://www.jitpack.io</url>
	</repository>
</repositories>
```
```xml
<dependency>
	<groupId>com.github.CoderWuao</groupId>
	<artifactId>cipher</artifactId>
	<version>x.x.x</version>
</dependency>
```


# Usage
### MessageDigest
```java
// md2
Assert.assertEquals(MD2.digestHex("wuao"),"ab737d2f07588dd5242aaa4b135ed780");
// md5
Assert.assertEquals(MD5.digestHex("wuao"), "08d40236d48c5377f95193190ace250f");
// sha1
Assert.assertEquals(SHA1.digestHex("wuao"), "9ad403bfd80c6af2cff4d1a7b1635cf5bec9a4fe");
// sha224
Assert.assertEquals(SHA224.digestHex("wuao"), "abce923277c0af0a950f2a7325f59294c0139695299f6004cbcc5a5a");
// sha256
Assert.assertEquals(SHA256.digestHex("wuao"), "15d3c1c0b6707fc8ae818ab8f7ffbb0d8f86425c6ab1352da3af6d15219988a6");
// sha384
Assert.assertEquals(SHA384.digestHex("wuao"), "84fd25dca4cadc5b1538b6dea1104bc9e6d8906e957060a1cdb04da5b4b7054c5704e1b176babe5d313966fc781c876b");
// sha512
Assert.assertEquals(SHA512.digestHex("wuao"), "f12f52e45028e3a190ac6ec7653a8a6a9403abb0f36d313c824c3200e9825c846a334139c8db9f2cec6eec87c4644224c6eda9d895b18fe3bd7a7964869e0c31");
```

# License
```
Copyright 2013 Wuao

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```