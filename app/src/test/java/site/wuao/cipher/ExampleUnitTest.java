package site.wuao.cipher;

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
        System.out.println("公钥: " + key.publicKeyBase64);
        System.out.println("私钥: " + key.privateKeyBase64);
        System.out.println("公钥加密: " + encryptByPublicKey);
        System.out.println("私钥解密: " + decryptByPrivateKey);
        System.out.println("私钥加密: " + encryptByPrivateKey);
        System.out.println("公钥解密: " + decryptByPublicKey);

        // 原文: wuao
        // 公钥: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKzpvPLQDCrHhrTUKfqeMMrmFR+VNFStfve6wdCZKRyyzkvPefKSqkBCiP7+IGPAQRSGHkbow7AM8UFpqqK0p5kCAwEAAQ==
        // 私钥: MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEArOm88tAMKseGtNQp+p4wyuYVH5U0VK1+97rB0JkpHLLOS8958pKqQEKI/v4gY8BBFIYeRujDsAzxQWmqorS
        // nmQIDAQABAkBFIlM8lfg3Zn0ycZ2zKWqCxUluzj4VGSUpsU7qs0IfyalY44zZlEe0MM0F2TfaEYWJ5ZAgf1IVoRMehsdEKgWNAiEA4P7F723faUikVIroVRJE9zCu9FxC4lE03hpF
        // o4dx7/MCIQDEvaVVg/nZHmFCInwbdS/UeLj7/2KR7B/nx08da+N5QwIgF/5zg1YXRjYN+Eob/r6FBkt1zO9t3o7EcY8hsA/IscsCIGMpUxPvGRceANdcmkEcp6bn0hTxe7Ug1lP0W
        // SPzJQwRAiEAt54akVnOuZXqd45RjWjfCEi7ERZ4W8toKgcEycPekw0=
        // 公钥加密: 375dff8c263abd81bee022842266ecfc2db997c13a1415289d0d8567720a66e2c7ae6db2969bac57a06369bf35a6287cff7bacb916bef5999654623884e8781e
        // 私钥解密: wuao
        // 私钥加密: 1fc44dd82474a6b680ef86f33421e5a03438941e054688035322a127ccbc4dc3858a7bd557b9958dbdc5227c693786920d2c2fa5df9af62a29b867ef7cb9e52f
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
    public void sha512() {
        String data = "wuao";
        String digest = SHA512.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: f12f52e45028e3a190ac6ec7653a8a6a9403abb0f36d313c824c3200e9825c846a334139c8db9f2cec6eec87c4644224c6eda9d895b18fe3bd7a7964869e0c31
    }


    @Test
    public void sha384() {
        String data = "wuao";
        String digest = SHA384.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: 84fd25dca4cadc5b1538b6dea1104bc9e6d8906e957060a1cdb04da5b4b7054c5704e1b176babe5d313966fc781c876b
    }


    @Test
    public void sha256() {
        String data = "wuao";
        String digest = SHA256.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: 15d3c1c0b6707fc8ae818ab8f7ffbb0d8f86425c6ab1352da3af6d15219988a6
    }

    @Test
    public void sha224() {
        String data = "wuao";
        String digest = SHA224.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: abce923277c0af0a950f2a7325f59294c0139695299f6004cbcc5a5a
    }

    @Test
    public void sha1() {
        String data = "wuao";
        String digest = SHA1.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: 9ad403bfd80c6af2cff4d1a7b1635cf5bec9a4fe
    }

    @Test
    public void md5() {
        String data = "wuao";
        String digest = MD5.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: 08d40236d48c5377f95193190ace250f
    }

    @Test
    public void md2() {
        String data = "wuao";
        String digest = MD2.digestHex(data);

        System.out.println("原文: " + data);
        System.out.println("摘要: " + digest);

        // 原文: wuao
        // 摘要: ab737d2f07588dd5242aaa4b135ed780
    }
}