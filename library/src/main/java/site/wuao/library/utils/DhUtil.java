package site.wuao.library.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DH工具
 *
 * @author wuao
 * @date 2018.02.05
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @note -
 */
public class DhUtil {
    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "DH";
    /** 本地密钥算法 */
    private static final String SECRET_ALGORITHM = "AES";
    /** 公钥 */
    private static final String PUBLIC_KEY = "DHPublicKey";
    /** 私钥 */
    private static final String PRIVATE_KEY = "DHPrivateKey";
    /** 密钥长度 */
    private static final int KEY_SIZE = 512;

    /**
     * 初始化甲方密钥
     *
     * @return 密钥map
     */
    public static HashMap<String, Object> initKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            DHPrivateKey privateKey = (DHPrivateKey) keyPair.getPrivate();
            DHPrivateKey publicKey = (DHPrivateKey) keyPair.getPublic();
            HashMap<String, Object> keyMap = new HashMap<>();
            keyMap.put(PRIVATE_KEY, privateKey);
            keyMap.put(PUBLIC_KEY, publicKey);
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 初始化乙方密钥
     *
     * @return 密钥map
     */
    public static HashMap<String, Object> initKey(byte[] key) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
            // 由甲方公钥构建乙方密钥
            DHParameterSpec dhParameterSpec = ((DHPublicKey) pubKey).getParams();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            keyPairGenerator.initialize(dhParameterSpec);
            KeyPair keyPair = keyPairGenerator.genKeyPair();
            DHPrivateKey privateKey = (DHPrivateKey) keyPair.getPrivate();
            DHPrivateKey publicKey = (DHPrivateKey) keyPair.getPublic();
            HashMap<String, Object> keyMap = new HashMap<>();
            keyMap.put(PRIVATE_KEY, privateKey);
            keyMap.put(PUBLIC_KEY, publicKey);
            return keyMap;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param data 数据
     * @param key 密钥
     * @return 加密结果
     */
    public byte[] encrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
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
    public byte[] decrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, SECRET_ALGORITHM);
            Cipher cipher = Cipher.getInstance(secretKeySpec.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 构建密钥
     *
     * @param publicKey 公钥
     * @param privateKey 私钥
     * @return 本地密钥
     */
    public static byte[] getSecretKey(byte[] publicKey, byte[] privateKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey);
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            KeyAgreement keyAgreement = KeyAgreement.getInstance(keyFactory.getAlgorithm());
            keyAgreement.init(priKey);
            keyAgreement.doPhase(pubKey, true);
            SecretKey secretKey = keyAgreement.generateSecret(SECRET_ALGORITHM);
            return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取私钥
     *
     * @param keyMap map
     * @return 私钥
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    public static byte[] getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }
}
