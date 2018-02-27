package site.wuao.library.encode;


import java.io.UnsupportedEncodingException;

import site.wuao.opsrc.org.apache.commons.codec.CharEncoding;


/**
 * Base64
 *
 * @author wuao
 * @date 2018/1/24
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class Base64 {
    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] encode(byte[] data) {
        return site.wuao.opsrc.android.util.Base64.encode(data, site.wuao.opsrc.android.util.Base64.NO_WRAP);
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] encode(String data) {
        try {
            return encode(data.getBytes(CharEncoding.UTF_8));
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String encodeString(byte[] data) {
        try {
            byte[] encode = encode(data);
            return new String(encode, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String encodeString(String data) {
        try {
            byte[] encode = encode(data.getBytes(CharEncoding.UTF_8));
            return new String(encode, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 解码结果
     */
    public static byte[] decode(byte[] data) {
        return site.wuao.opsrc.android.util.Base64.decode(data, site.wuao.opsrc.android.util.Base64.NO_WRAP);
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] decode(String data) {
        try {
            return decode(data.getBytes(CharEncoding.UTF_8));
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String decodeString(byte[] data) {
        try {
            byte[] decode = decode(data);
            return new String(decode, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String decodeString(String data) {
        try {
            byte[] decode = decode(data.getBytes(CharEncoding.UTF_8));
            return new String(decode, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }
}

