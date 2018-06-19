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
        // init
        RSA.getInstance().init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        // create key
        RSAKey key = RSA.getInstance().createKey();

        // encrypt by public key & decrypt by private key
        String encryptByPublicKey = RSA.getInstance().encryptByPublicKeyHex("wuao", key.publicKeyHex);
        String decryptByPrivateKey = RSA.getInstance().decryptByPrivateKeyHex(encryptByPublicKey, key.privateKeyHex);
        Assert.assertEquals(decryptByPrivateKey, "wuao");

        // encrypt by private key & decrypt by public key
        String encryptByPrivateKey = RSA.getInstance().encryptByPrivateKeyHex("wuao", key.privateKeyHex);
        String decryptByPublicKey = RSA.getInstance().decryptByPublicKeyHex(encryptByPrivateKey, key.publicKeyHex);
        Assert.assertEquals(decryptByPublicKey, "wuao");
    }

    @Test
    public void rsaBase64() {
        // init
        RSA.getInstance().init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        // create key
        RSAKey key = RSA.getInstance().createKey();

        // encrypt by public key & decrypt by private key
        String encryptByPublicKey = RSA.getInstance().encryptByPublicKeyBase64("wuao", key.publicKeyBase64);
        String decryptByPrivateKey = RSA.getInstance().decryptByPrivateKeyBase64(encryptByPublicKey, key.privateKeyBase64);
        Assert.assertEquals(decryptByPrivateKey, "wuao");

        // encrypt by private key & decrypt by public key
        String encryptByPrivateKey = RSA.getInstance().encryptByPrivateKeyBase64("wuao", key.privateKeyBase64);
        String decryptByPublicKey = RSA.getInstance().decryptByPublicKeyBase64(encryptByPrivateKey, key.publicKeyBase64);
        Assert.assertEquals(decryptByPublicKey, "wuao");
    }

    @Test
    public void aesCustomKey() {
        // init
        AES.getInstance().init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        // create custom key
        String keyBase64 = Base64.encodeString("1234567890123456");

        // encrypt & decrypt
        String encrypt = AES.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = AES.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void aesHex() {
        // init
        AES.getInstance().init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        // create hex key
        String keyHex = AES.getInstance().createKeyHex();

        // encrypt & decrypt
        String encrypt = AES.getInstance().encryptHex("wuao", keyHex);
        String decrypt = AES.getInstance().decryptHex(encrypt, keyHex);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void aesBase64() {
        // init
        AES.getInstance().init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        // create base64 key
        String keyBase64 = AES.getInstance().createKeyBase64();

        // encrypt & decrypt
        String encrypt = AES.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = AES.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desedeCustomKey() {
        // init
        DESede.getInstance().init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        // create custom key
        String keyBase64 = Base64.encodeString("123456789012345678901234");

        // encrypt & decrypt
        String encrypt = DESede.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = DESede.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desedeHex() {
        // init
        DESede.getInstance().init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        // create hex key
        String keyHex = DESede.getInstance().createKeyHex();

        // encrypt & decrypt
        String encrypt = DESede.getInstance().encryptHex("wuao", keyHex);
        String decrypt = DESede.getInstance().decryptHex(encrypt, keyHex);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desedeBase64() {
        // init
        DESede.getInstance().init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        // create base64 key
        String keyBase64 = DESede.getInstance().createKeyBase64();

        // encrypt & decrypt
        String encrypt = DESede.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = DESede.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desCustomKey() {
        // init
        DES.getInstance().init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        // create custom key
        String keyBase64 = Base64.encodeString("12345678");

        // encrypt & decrypt
        String encrypt = DES.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = DES.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desHex() {
        // init
        DES.getInstance().init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        // create hex key
        String keyHex = DES.getInstance().createKeyHex();

        // encrypt & decrypt
        String encrypt = DES.getInstance().encryptHex("wuao", keyHex);
        String decrypt = DES.getInstance().decryptHex(encrypt, keyHex);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void desBase64() {
        // init
        DES.getInstance().init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        // create base64 key
        String keyBase64 = DES.getInstance().createKeyBase64();

        // encrypt & decrypt
        String encrypt = DES.getInstance().encryptBase64("wuao", keyBase64);
        String decrypt = DES.getInstance().decryptBase64(encrypt, keyBase64);
        Assert.assertEquals(decrypt, "wuao");
    }

    @Test
    public void encode() {
        // base64
        String encodeBase64 = Base64.encodeString("wuao");
        String decodeBase64 = Base64.decodeString(encodeBase64);
        Assert.assertEquals(encodeBase64, "d3Vhbw==");
        Assert.assertEquals(decodeBase64, "wuao");

        // hex
        String encodeHex = Hex.encodeString("wuao");
        String decodeHex = Hex.decodeString(encodeHex);
        Assert.assertEquals(encodeHex, "7775616f");
        Assert.assertEquals(decodeHex, "wuao");
    }

    @Test
    public void messageDigest() {
        Assert.assertEquals(MD2.digestHex("wuao"), "ab737d2f07588dd5242aaa4b135ed780");
        Assert.assertEquals(MD5.digestHex("wuao"), "08d40236d48c5377f95193190ace250f");
        Assert.assertEquals(SHA1.digestHex("wuao"), "9ad403bfd80c6af2cff4d1a7b1635cf5bec9a4fe");
        Assert.assertEquals(SHA224.digestHex("wuao"), "abce923277c0af0a950f2a7325f59294c0139695299f6004cbcc5a5a");
        Assert.assertEquals(SHA256.digestHex("wuao"), "15d3c1c0b6707fc8ae818ab8f7ffbb0d8f86425c6ab1352da3af6d15219988a6");
        Assert.assertEquals(SHA384.digestHex("wuao"), "84fd25dca4cadc5b1538b6dea1104bc9e6d8906e957060a1cdb04da5b4b7054c5704e1b176babe5d313966fc781c876b");
        Assert.assertEquals(SHA512.digestHex("wuao"), "f12f52e45028e3a190ac6ec7653a8a6a9403abb0f36d313c824c3200e9825c846a334139c8db9f2cec6eec87c4644224c6eda9d895b18fe3bd7a7964869e0c31");
    }
}