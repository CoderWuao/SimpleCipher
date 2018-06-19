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
String data = "wuao";
String digest = MD2.digestHex(data);

System.out.println("原文: " + data);
System.out.println("摘要: " + digest);

// 原文: wuao
// 摘要: ab737d2f07588dd5242aaa4b135ed780
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