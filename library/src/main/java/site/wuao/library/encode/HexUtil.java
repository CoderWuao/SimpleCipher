package site.wuao.library.encode;

import java.io.UnsupportedEncodingException;

import site.wuao.opsrc.apache.commons.codec.CharEncoding;


/**
 * 十六进制工具
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
public abstract class HexUtil {
    /** 十六进制输出字符 */
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static char[] encode(byte[] data) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return out;
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static char[] encode(String data) {
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
        char[] encode = encode(data);
        return new String(encode);
    }

    /**
     * 编码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String encodeString(String data) {
        try {
            char[] encode = encode(data.getBytes(CharEncoding.UTF_8));
            return new String(encode);
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
    public static byte[] decode(char[] data) {
        final int len = data.length;

        if ((len & 0x01) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }

        final byte[] out = new byte[len >> 1];

        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data[j], j) << 4;
            j++;
            f = f | toDigit(data[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 解码结果
     */
    public static byte[] decode(String data) {
        return decode(data.toCharArray());
    }

    /**
     * 解码
     *
     * @param data 数据
     * @return 编码结果
     */
    public static String decodeString(char[] data) {
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
            byte[] decode = decode(data.toCharArray());
            return new String(decode, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            // 不做处理
        }
        return null;
    }

    /**
     * 转字符
     *
     * @param ch char
     * @param index 索引
     * @return 字符
     */
    private static int toDigit(final char ch, final int index) {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }
}
