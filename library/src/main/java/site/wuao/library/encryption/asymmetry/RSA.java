package site.wuao.library.encryption.asymmetry;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import site.wuao.library.encode.Base64Util;
import site.wuao.library.encode.HexUtil;
import site.wuao.opsrc.apache.commons.codec.CharEncoding;

/**
 * RSA
 *
 * @author wuao
 * @date 2018/2/5
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class RSA extends AsymmetricEncryption {
    /** 密钥长度 */
    public static final int KEY_SIZE_512 = 512;
    /** 密钥长度 */
    public static final int KEY_SIZE_65536 = 65536;
    /** 工作模式 */
    public static final String WORK_MODE_ECB = "ECB";
    /** 填充方式 */
    public static final String PADDING_MODE_NoPadding = "NoPadding";
    /** 填充方式 */
    public static final String PADDING_MODE_PKCS1Padding = "PKCS1Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_OAEPWITHMD5AndMGF1Padding = "OAEPWITHMD5AndMGF1Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_OAEPWITHSHA1AndMGF1Padding = "OAEPWITHSHA1AndMGF1Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_OAEPWITHSHA256AndMGF1Padding = "OAEPWITHSHA256AndMGF1Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_OAEPWITHSHA384AndMGF1Padding = "OAEPWITHSHA384AndMGF1Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_OAEPWITHSHA512AndMGF1Padding = "OAEPWITHSHA512AndMGF1Padding";

    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 私有构造方法
     */
    private RSA() {
        super(KEY_ALGORITHM);
    }

    /**
     * 获取单例对象
     *
     * @return 单例
     */
    public static RSA getInstance() {
        return RSAHolder.sInstance;
    }

    /**
     * 创建密钥
     *
     * @return 密钥
     */
    public RSAKey createKey() {
        Exception exception;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(getKeyAlgorithm());
            keyPairGenerator.initialize(getKeySize());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            byte[] privateKey = keyPair.getPrivate().getEncoded();
            byte[] publicKey = keyPair.getPublic().getEncoded();
            RSAKey key = new RSAKey();
            key.privateKey = privateKey;
            key.publicKey = publicKey;
            key.privateKeyBase64 = Base64Util.encodeString(privateKey);
            key.publicKeyBase64 = Base64Util.encodeString(publicKey);
            key.privateKeyHex = HexUtil.encodeString(privateKey);
            key.publicKeyHex = HexUtil.encodeString(publicKey);
            return key;
        } catch (NoSuchAlgorithmException e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 公钥加密
     *
     * @param data 数据
     * @param key 密钥
     * @return 加密结果
     */
    public byte[] encryptByPublicKey(byte[] data, byte[] key) {
        Exception exception;
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(getKeyAlgorithm());
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 公钥加密
     *
     * @param data 数据
     * @param base64Key 密钥
     * @return 加密结果
     */
    public String encryptByPublicKeyBase64(String data, String base64Key) {
        try {
            byte[] encrypt = encryptByPublicKey(data.getBytes(CharEncoding.UTF_8), Base64Util.decode(base64Key));
            return Base64Util.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 公钥加密
     *
     * @param data 数据
     * @param hexKey 密钥
     * @return 加密结果
     */
    public String encryptByPublicKeyHex(String data, String hexKey) {
        try {
            byte[] encrypt = encryptByPublicKey(data.getBytes(CharEncoding.UTF_8), HexUtil.decode(hexKey));
            return HexUtil.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 私钥加密
     *
     * @param data 数据
     * @param key 密钥
     * @return 加密结果
     */
    public byte[] encryptByPrivateKey(byte[] data, byte[] key) {
        Exception exception;
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(getKeyAlgorithm());
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 私钥加密
     *
     * @param data 数据
     * @param base64Key 密钥
     * @return 加密结果
     */
    public String encryptByPrivateKeyBase64(String data, String base64Key) {
        try {
            byte[] encrypt = encryptByPrivateKey(data.getBytes(CharEncoding.UTF_8), Base64Util.decode(base64Key));
            return Base64Util.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 私钥加密
     *
     * @param data 数据
     * @param hexKey 密钥
     * @return 加密结果
     */
    public String encryptByPrivateKeyHex(String data, String hexKey) {
        try {
            byte[] encrypt = encryptByPrivateKey(data.getBytes(CharEncoding.UTF_8), HexUtil.decode(hexKey));
            return HexUtil.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 公钥解密
     *
     * @param data 数据
     * @param key 密钥
     * @return 解密结果
     */
    public byte[] decryptByPublicKey(byte[] data, byte[] key) {
        Exception exception;
        try {
            // 获取公钥
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(getKeyAlgorithm());
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            // 解密
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 公钥解密
     *
     * @param base64Data 数据
     * @param base64Key 密钥
     * @return 解密结果
     */
    public  String decryptByPublicKeyBase64(String base64Data, String base64Key) {
        try {
            byte[] decrypt = decryptByPublicKey(Base64Util.decode(base64Data), Base64Util.decode(base64Key));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 公钥解密
     *
     * @param hexData 数据
     * @param hexKey 密钥
     * @return 解密结果
     */
    public  String decryptByPublicKeyHex(String hexData, String hexKey) {
        try {
            byte[] decrypt = decryptByPublicKey(HexUtil.decode(hexData), HexUtil.decode(hexKey));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param data 数据
     * @param key 密钥
     * @return 解密结果
     */
    public byte[] decryptByPrivateKey(byte[] data, byte[] key) {
        Exception exception;
        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(getKeyAlgorithm());
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param base64Data 数据
     * @param base64Key 密钥
     * @return 解密结果
     */
    public  String decryptByPrivateKeyBase64(String base64Data, String base64Key) {
        try {
            byte[] decrypt = decryptByPrivateKey(Base64Util.decode(base64Data), Base64Util.decode(base64Key));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 私钥解密
     *
     * @param hexData 数据
     * @param hexKey 密钥
     * @return 解密结果
     */
    public  String decryptByPrivateKeyHex(String hexData, String hexKey) {
        try {
            byte[] decrypt = decryptByPrivateKey(HexUtil.decode(hexData), HexUtil.decode(hexKey));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 单例持有者
     */
    private static class RSAHolder {
        /** 单例对象 */
        private static final RSA sInstance = new RSA();
    }
}