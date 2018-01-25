package site.wuao.library.cipher;


import java.io.UnsupportedEncodingException;

import site.wuao.library.aes.AesUtil;
import site.wuao.library.base64.Base64Util;
import site.wuao.library.constant.CipherConst;
import site.wuao.library.des.DesUtil;
import site.wuao.library.desede.DESedeUtil;

public abstract class CipherUtil {

    private static String transformByte2Str(byte[] data, int encoding) {
        switch (encoding) {
            case CipherConst.ENCODING_BASE64:
                return Base64Util.encodeByte2Str(data);
            case CipherConst.ENCODING_HEX:
                // TODO: 2018/1/25
                break;
            default:
                break;
        }
        return null;
    }

    private static byte[] transformStr2Byte(String data, int encoding) {
        switch (encoding) {
            case CipherConst.ENCODING_BASE64:
                return Base64Util.decodeStr2Byte(data);
            case CipherConst.ENCODING_HEX:
                // TODO: 2018/1/25
                break;
            default:
                break;
        }
        return null;
    }

    public static String createDesKey(int encoding) {
        return transformByte2Str(DesUtil.createKey(), encoding);
    }

    public static String createDESedeKey(int encoding) {
        return transformByte2Str(DESedeUtil.createKey(), encoding);
    }

    public static String createAesKey(int encoding) {
        return transformByte2Str(AesUtil.createKey(), encoding);
    }

    public static String encryptDes(String data, String key, int encoding) {
        try {
            byte[] encrypt = DesUtil.encrypt(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8), key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
            return transformByte2Str(encrypt, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptDESede(String data, String key, int encoding) {
        try {
            byte[] encrypt = DESedeUtil.encrypt(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8), key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
            return transformByte2Str(encrypt, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptAes(String data, String key, int encoding) {
        try {
            byte[] encrypt = AesUtil.encrypt(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8), key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
            return transformByte2Str(encrypt, encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDes(String data, String key, int encoding) {
        try {
            byte[] decode = transformStr2Byte(data, encoding);
            return new String(DesUtil.decrypt(decode, key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8)), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDESede(String data, String key, int encoding) {
        try {
            byte[] decode = transformStr2Byte(data, encoding);
            return new String(DESedeUtil.decrypt(decode, key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8)), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptAes(String data, String key, int encoding) {
        try {
            byte[] decode = transformStr2Byte(data, encoding);
            return new String(AesUtil.decrypt(decode, key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8)), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
