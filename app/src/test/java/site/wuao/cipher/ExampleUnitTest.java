package site.wuao.cipher;

import org.junit.Assert;
import org.junit.Test;

import site.wuao.library.digest.MD2;
import site.wuao.library.digest.MD5;
import site.wuao.library.digest.SHA1;
import site.wuao.library.digest.SHA224;
import site.wuao.library.digest.SHA256;
import site.wuao.library.digest.SHA384;
import site.wuao.library.digest.SHA512;
import site.wuao.library.encode.Base64;
import site.wuao.library.encode.Hex;
import site.wuao.library.encryption.asymmetry.RSA;
import site.wuao.library.encryption.asymmetry.RSAKey;
import site.wuao.library.encryption.symmetry.AES;
import site.wuao.library.encryption.symmetry.DES;
import site.wuao.library.encryption.symmetry.DESede;

/**
 * 测试
 *
 * @author wuao
 * @date 2018/2/13
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class ExampleUnitTest {
    @Test
    public void rsaHex() {
        RSA instance = RSA.getInstance();
        instance.init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        String data = "wuao";
        RSAKey key = instance.createKey();

        String encryptByPublicKey = instance.encryptByPublicKeyHex(data, key.publicKeyHex);
        String decryptByPrivateKey = instance.decryptByPrivateKeyHex(encryptByPublicKey, key.privateKeyHex);

        String encryptByPrivateKey = instance.encryptByPrivateKeyHex(data, key.privateKeyHex);
        String decryptByPublicKey = instance.decryptByPublicKeyHex(encryptByPrivateKey, key.publicKeyHex);

        System.out.println("原文: " + data);
        System.out.println("公钥: " + key.publicKeyHex);
        System.out.println("私钥: " + key.privateKeyHex);
        System.out.println("公钥加密: " + encryptByPublicKey);
        System.out.println("私钥解密: " + decryptByPrivateKey);
        System.out.println("私钥加密: " + encryptByPrivateKey);
        System.out.println("公钥解密: " + decryptByPublicKey);

        // 原文: wuao
        // 公钥: 305c300d06092a864886f70d0101010500034b003048024100b7de5962c00e03b539255c36bfdd36e0533a130f8335393f5ac11b5e5e1d449a3ed328dcdd1c50698
        // d909b5dc03513a2ae39a73c66cb5ca10ed3fb27acd3189f0203010001
        // 私钥: 30820154020100300d06092a864886f70d01010105000482013e3082013a020100024100b7de5962c00e03b539255c36bfdd36e0533a130f8335393f5ac11b5e5e1
        // d449a3ed328dcdd1c50698d909b5dc03513a2ae39a73c66cb5ca10ed3fb27acd3189f0203010001024100a7cdca20008d09bf43a720106b6c15600734d21e6f2d8cd0901f
        // fabd56013a1047b15943ee1989bef5c40c4442ab5c89ce6b8cacdcd39428682662f835a20159022100f85f0915f81f047310258241adb3850d8e1beb0144fc8fc2a7a22a2
        // f34c42393022100bd841f9e0c269ae87748ecdc332c7e0d472995130cf3fa4b46a40299c389b64502205c7d5f6fcbef1904142e339c6ba7df5355e935914a7456c0a11635
        // 6950d7fd7b02205388a4430eca0967c40451daf177800c2c3cc8e7bfc2dea5457acf66a548d31d02204742d940b418718790499ef94d6758c3e7fa365f58d786481a0737c
        // 4ee2e07d5
        // 公钥加密: 19b0bcae360ee091505bd34822176a424a4e3fa13a0f2c97b66cc7247654d4b7d030caa1c26b9f3979a5c0f9e606aa597c462bbacf9eb967d4d5842f3fae1217
        // 私钥解密: wuao
        // 私钥加密: 284b71a6ba5cf806dcdf75165e47164e1b8f01faf7d757a397c141e8b56dfa3e6744e906e15033911a8ee68f3b427be556074473965e339c6c54dcee9dcc294f
        // 公钥解密: wuao
    }

    @Test
    public void rsaBase64() {
        RSA instance = RSA.getInstance();
        instance.init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        String data = "wuao";
        RSAKey key = instance.createKey();

        String encryptByPublicKey = instance.encryptByPublicKeyBase64(data, key.publicKeyBase64);
        String decryptByPrivateKey = instance.decryptByPrivateKeyBase64(encryptByPublicKey, key.privateKeyBase64);

        String encryptByPrivateKey = instance.encryptByPrivateKeyBase64(data, key.privateKeyBase64);
        String decryptByPublicKey = instance.decryptByPublicKeyBase64(encryptByPrivateKey, key.publicKeyBase64);

        System.out.println("原文: " + data);
        System.out.println("公钥: " + key.publicKeyBase64);
        System.out.println("私钥: " + key.privateKeyBase64);
        System.out.println("公钥加密: " + encryptByPublicKey);
        System.out.println("私钥解密: " + decryptByPrivateKey);
        System.out.println("私钥加密: " + encryptByPrivateKey);
        System.out.println("公钥解密: " + decryptByPublicKey);

        // 原文: wuao
        // 公钥: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ1QWsdZSjD92nXqbVwI3Nz9ZCIs25yVl8YTGbCmktfzUpzCPzioMyn+n1kDn5Kw836Gz3kmkVmWpjczMW8E+nECAwEAAQ==
        // 私钥: MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAnVBax1lKMP3adeptXAjc3P1kIizbnJWXxhMZsKaS1/NSnMI/OKgzKf6fWQOfkrDzfobPeSaRWZamNzMxbw
        // T6cQIDAQABAkAGmd6VStvgHmbSV9nq6LxL0Z4oCPXWJjjOKPMFBJhY014HrrwgJn3onq2fDJA/PIUXOH5VC2vRqj5wiZhMOA05AiEA4jDluMDgvfYiJLcWemWadSiGwMcmwmwMAs
        // 3yGo8ggy8CIQCyC7hsgZbb3xgI5pw4vmyqTIstRaoVk2x3le9HHO10XwIhAMnVuCdUdTcNGwqIFZbCc0F4GEaNbxiuMUmPXCo27VwhAiARYmGUfqa7OzI+lD3GsJktm6GvPvEXgD
        // iECKi/Wcy5owIhAIbVbtBlHT/UqA+yQHOFZ9sJC11k6ctrrJRRGR4091Xb
        // 公钥加密: OVqdcqqjvubQc9kB7xyY5axJ7ztFGT9EUdnQPGV8rlZVoRDfFtoS0xD676uWnuZC3hUUWJX/z1QaZxZsHdqBOg==
        // 私钥解密: wuao
        // 私钥加密: YCk2bv/mwWpObqB6l7YFm4VwcvvV8+TVI981V54pjxrWXA0UUOqY5ill/KUiZMuD25KzyjlEEaIiKwoB8uAymA==
        // 公钥解密: wuao
    }

    @Test
    public void aesCustomKey() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "AES";
        String key = "wuaowuaowuaowuao";
        String keyBase64 = Base64.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: AES
        // 密钥: d3Vhb3d1YW93dWFvd3Vhbw==
        // 加密: sMWS1yrF2rxOocsp7avrQQ==
        // 解密: AES
    }

    @Test
    public void aesHex() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyHex);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: 6434553d158cc2d2a79b5c5d79a2f689
        // 加密: 9bf6e1f0b9891380662063e2c850afe0
        // 解密: wuao
    }

    @Test
    public void aesBase64() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: enkI5VAiNbLh9iaT/INCzw==
        // 加密: NDfrhbrNZEfoN2GYGPseKw==
        // 解密: wuao
    }

    @Test
    public void desedeCustomKey() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "DESede";
        String key = "wuaowuaowuaowuaowuaowuao";
        String keyBase64 = Base64.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: DESede
        // 密钥: d3Vhb3d1YW93dWFvd3Vhb3d1YW93dWFv
        // 加密: L0oCz5ojUwc=
        // 解密: DESede
    }

    @Test
    public void desedeHex() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyHex);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: 896eea01150e5123d01cc7aee60d5e7f752c3125fbec5b0d
        // 加密: 84f3fb7f7146706b
        // 解密: wuao
    }

    @Test
    public void desedeBase64() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: lECFubMfa5hnPX9GmLwxB9Pxa8uKf3mG
        // 加密: RE/lwstG2wY=
        // 解密: wuao
    }

    @Test
    public void desCustomKey() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "DES";
        String key = "wuaowuao";
        String keyBase64 = Base64.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: DES
        // 密钥: d3Vhb3d1YW8=
        // 加密: ciIDW2MOP8A=
        // 解密: DES
    }

    @Test
    public void desHex() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyHex);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: 385ef110fb893ea7
        // 加密: 79cd526c76cfcb26
        // 解密: wuao
    }

    @Test
    public void desBase64() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        System.out.println("原文: " + data);
        System.out.println("密钥: " + keyBase64);
        System.out.println("加密: " + encrypt);
        System.out.println("解密: " + decrypt);

        // 原文: wuao
        // 密钥: dgv7aMjf0wI=
        // 加密: RN1vymICovA=
        // 解密: wuao
    }

    @Test
    public void hex() {
        String data = "wuao";

        String encode = Hex.encodeString(data);
        String decode = Hex.decodeString(encode);

        System.out.println("原文：" + data);
        System.out.println("编码：" + encode);
        System.out.println("解码：" + decode);

        // 原文：wuao
        // 编码：7775616f
        // 解码：wuao
    }

    @Test
    public void base64() {
        String data = "wuao";

        String encode = Base64.encodeString(data);
        String decode = Base64.decodeString(encode);

        System.out.println("原文：" + data);
        System.out.println("编码：" + encode);
        System.out.println("解码：" + decode);

        // 原文：wuao
        // 编码：d3Vhbw==
        // 解码：wuao
    }

    @Test
    public void encode() {
        // base64
        String encodeBase64 = Base64.encodeString("wuao");
        String decodeBase64 = Base64.decodeString(encodeBase64);
        Assert.assertEquals(encodeBase64,"d3Vhbw==");
        Assert.assertEquals(decodeBase64,"wuao");

        // hex
        String encodeHex = Hex.encodeString("wuao");
        String decodeHex = Hex.decodeString(encodeHex);
        Assert.assertEquals(encodeHex,"7775616f");
        Assert.assertEquals(decodeHex,"wuao");
    }

    @Test
    public void messageDigest() {
        Assert.assertEquals(MD2.digestHex("wuao"),"ab737d2f07588dd5242aaa4b135ed780");
        Assert.assertEquals(MD5.digestHex("wuao"), "08d40236d48c5377f95193190ace250f");
        Assert.assertEquals(SHA1.digestHex("wuao"), "9ad403bfd80c6af2cff4d1a7b1635cf5bec9a4fe");
        Assert.assertEquals(SHA224.digestHex("wuao"), "abce923277c0af0a950f2a7325f59294c0139695299f6004cbcc5a5a");
        Assert.assertEquals(SHA256.digestHex("wuao"), "15d3c1c0b6707fc8ae818ab8f7ffbb0d8f86425c6ab1352da3af6d15219988a6");
        Assert.assertEquals(SHA384.digestHex("wuao"), "84fd25dca4cadc5b1538b6dea1104bc9e6d8906e957060a1cdb04da5b4b7054c5704e1b176babe5d313966fc781c876b");
        Assert.assertEquals(SHA512.digestHex("wuao"), "f12f52e45028e3a190ac6ec7653a8a6a9403abb0f36d313c824c3200e9825c846a334139c8db9f2cec6eec87c4644224c6eda9d895b18fe3bd7a7964869e0c31");
    }
}