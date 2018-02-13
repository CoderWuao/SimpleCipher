package site.wuao.library.encryption.symmetry;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import site.wuao.library.encode.Base64Util;
import site.wuao.library.encode.HexUtil;
import site.wuao.library.encryption.Encryption;
import site.wuao.opsrc.apache.commons.codec.CharEncoding;

/**
 * 对称加密
 *
 * @author wuao
 * @date 2018/1/31
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public abstract class SymmetricEncryption extends Encryption {
    /**
     * 构造函数
     *
     * @param keyAlgorithm 密钥算法
     */
    protected SymmetricEncryption(String keyAlgorithm) {
        super(keyAlgorithm);
    }

    /**
     * 创建密钥
     *
     * @return 密钥
     */
    public byte[] createKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(getKeyAlgorithm());
            keyGenerator.init(getKeySize());
            return keyGenerator.generateKey().getEncoded();
        } catch (NoSuchAlgorithmException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 创建密钥
     *
     * @return 密钥
     */
    public String createKeyBase64() {
        return Base64Util.encodeString(createKey());
    }

    /**
     * 创建密钥
     *
     * @return 密钥
     */
    public String createKeyHex() {
        return HexUtil.encodeString(createKey());
    }

    /**
     * 加密
     *
     * @param data 数据
     * @param key 密钥
     * @return 加密结果
     */
    public byte[] encrypt(byte[] data, byte[] key) {
        Exception exception;
        try {
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, transformKey(key));
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
     * 加密
     *
     * @param data 数据
     * @param base64Key 密钥
     * @return 加密结果
     */
    public String encryptBase64(String data, String base64Key) {
        try {
            byte[] encrypt = encrypt(data.getBytes(CharEncoding.UTF_8), Base64Util.decode(base64Key));
            return Base64Util.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 加密
     *
     * @param data 数据
     * @param hexKey 密钥
     * @return 加密结果
     */
    public String encryptHex(String data, String hexKey) {
        try {
            byte[] encrypt = encrypt(data.getBytes(CharEncoding.UTF_8), HexUtil.decode(hexKey));
            return HexUtil.encodeString(encrypt);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 解密
     *
     * @param data 数据
     * @param key 密钥
     * @return 解密结果
     */
    public  byte[] decrypt(byte[] data, byte[] key) {
        Exception exception;
        try {
            Cipher cipher = Cipher.getInstance(getCipherAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, transformKey(key));
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
     * 解密
     *
     * @param base64Data 数据
     * @param base64Key 密钥
     * @return 解密结果
     */
    public  String decryptBase64(String base64Data, String base64Key) {
        try {
            byte[] decrypt = decrypt(Base64Util.decode(base64Data), Base64Util.decode(base64Key));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 解密
     *
     * @param hexData 数据
     * @param hexKey 密钥
     * @return 解密结果
     */
    public  String decryptHex(String hexData, String hexKey) {
        try {
            byte[] decrypt = decrypt(HexUtil.decode(hexData), HexUtil.decode(hexKey));
            return new String(decrypt, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 转化密钥
     *
     * @param key 密钥
     * @return 转化结果
     */
    protected abstract Key transformKey(byte[] key);
}
