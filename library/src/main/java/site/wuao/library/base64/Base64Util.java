package site.wuao.library.base64;


import java.io.UnsupportedEncodingException;

import site.wuao.library.constant.CipherConst;


/**
 * Base64工具
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
public abstract class Base64Util {
    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] encodeByte2Byte(byte[] data) {
        return Base64.encode(data, Base64.NO_WRAP);
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String encodeByte2Str(byte[] data) {
        try {
            return new String(encodeByte2Byte(data), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] encodeStr2Byte(String data) {
        try {
            return encodeByte2Byte(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String encodeStr2Str(String data) {
        try {
            return encodeByte2Str(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 解码结果
     */
    public static byte[] decodeByte2Byte(byte[] data) {
        return Base64.decode(data, Base64.NO_WRAP);
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String decodeByte2Str(byte[] data) {
        try {
            return new String(decodeByte2Byte(data), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static byte[] decodeStr2Byte(String data) {
        try {
            return decodeByte2Byte(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String decodeStr2Str(String data) {
        try {
            return decodeByte2Str(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

