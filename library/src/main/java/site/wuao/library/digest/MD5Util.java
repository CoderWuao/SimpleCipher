package site.wuao.library.digest;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import site.wuao.library.encode.HexUtil;
import site.wuao.opsrc.apache.commons.codec.CharEncoding;

/**
 * MD5工具
 *
 * @author wuao
 * @date 2018/2/6
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class MD5Util {
    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "MD5";

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static byte[] digest(byte[] data) {
        try {
            return MessageDigest.getInstance(KEY_ALGORITHM).digest(data);
        } catch (NoSuchAlgorithmException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static byte[] digest(String data) {
        try {
            return digest(data.getBytes(CharEncoding.UTF_8));
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static String digestHex(byte[] data) {
        byte[] digest = digest(data);
        return HexUtil.encodeString(digest);
    }

    /**
     * 摘要
     *
     * @param data 数据
     * @return 摘要结果
     */
    public static String digestHex(String data) {
        try {
            byte[] digest = digest(data.getBytes(CharEncoding.UTF_8));
            return HexUtil.encodeString(digest);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }
}
