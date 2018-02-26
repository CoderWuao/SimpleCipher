package site.wuao.library.digest.base;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import site.wuao.library.encode.HexUtil;
import site.wuao.opsrc.org.apache.commons.codec.CharEncoding;

/**
 * 消息摘要
 *
 * @author wuao
 * @date 2018/2/24
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class MessageDigest {
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_MD2 = "MD2";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_MD4 = "MD4";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_MD5 = "MD5";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_SHA_1 = "SHA-1";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_SHA_224 = "SHA-224";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_SHA_256 = "SHA-256";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_SHA_384 = "SHA-384";
    /** 消息摘要算法 */
    protected static final String MESSAGE_DIGEST_ALGORITHM_SHA_512 = "SHA-512";

    /**
     * 摘要
     *
     * @param data 数据
     * @param keyAlgorithm 密钥算法
     * @return 摘要结果
     */
    protected static byte[] digest(byte[] data, String keyAlgorithm) {
        Exception exception;
        try {
            return java.security.MessageDigest.getInstance(keyAlgorithm).digest(data);
        } catch (NoSuchAlgorithmException e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @param keyAlgorithm 密钥算法
     * @return 摘要结果
     */
    protected static byte[] digest(String data, String keyAlgorithm) {
        try {
            return digest(data.getBytes(CharEncoding.UTF_8), keyAlgorithm);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @param keyAlgorithm 密钥算法
     * @return 摘要结果
     */
    protected static String digestHex(byte[] data, String keyAlgorithm) {
        byte[] digest = digest(data, keyAlgorithm);
        return HexUtil.encodeString(digest);
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @param keyAlgorithm 密钥算法
     * @return 摘要结果
     */
    protected static String digestHex(String data, String keyAlgorithm) {
        try {
            byte[] digest = digest(data.getBytes(CharEncoding.UTF_8), keyAlgorithm);
            return HexUtil.encodeString(digest);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }
}
