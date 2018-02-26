package site.wuao.library.digest;

import site.wuao.library.digest.base.MessageDigest;

/**
 * SHA-384
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
public class SHA384 extends MessageDigest {
    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static byte[] digest(byte[] data) {
        return digest(data, MESSAGE_DIGEST_ALGORITHM_SHA_384);
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static byte[] digest(String data) {
        return digest(data, MESSAGE_DIGEST_ALGORITHM_SHA_384);
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static String digestHex(byte[] data) {
        return digestHex(data, MESSAGE_DIGEST_ALGORITHM_SHA_384);
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static String digestHex(String data) {
        return digestHex(data, MESSAGE_DIGEST_ALGORITHM_SHA_384);
    }
}
