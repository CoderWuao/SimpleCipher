package site.wuao.library.cipher;


import java.io.UnsupportedEncodingException;

import site.wuao.library.base64.Base64Util;
import site.wuao.library.constant.CipherConst;
import site.wuao.library.des.DesUtil;
import site.wuao.library.desede.DESedeUtil;

public abstract class CipherUtil {
    public static String createDesKey(int encoding) {
        byte[] key = DesUtil.createKey();
        switch (encoding) {
            case CipherConst.ENCODING_BASE64:
                return Base64Util.encodeByte2Str(key);
            case CipherConst.ENCODING_HEX:
                // TODO: 2018/1/25
                break;
            default:
                break;
        }
        return null;
    }

    public static String createDESedeKey(int encoding) {
        byte[] key = DESedeUtil.createKey();
        switch (encoding) {
            case CipherConst.ENCODING_BASE64:
                return Base64Util.encodeByte2Str(key);
            case CipherConst.ENCODING_HEX:
                // TODO: 2018/1/25
                break;
            default:
                break;
        }
        return null;
    }

    public static String encryptDes(String data, String key, int encoding) {
        try {
            byte[] encrypt = DesUtil.encrypt(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8), key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
            switch (encoding) {
                case CipherConst.ENCODING_BASE64:
                    return Base64Util.encodeByte2Str(encrypt);
                case CipherConst.ENCODING_HEX:
                    // TODO: 2018/1/25
                    break;
                default:
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptDESede(String data, String key, int encoding) {
        try {
            byte[] encrypt = DESedeUtil.encrypt(data.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8), key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8));
            switch (encoding) {
                case CipherConst.ENCODING_BASE64:
                    return Base64Util.encodeByte2Str(encrypt);
                case CipherConst.ENCODING_HEX:
                    // TODO: 2018/1/25
                    break;
                default:
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDes(String data, String key, int encoding) {
        try {
            byte[] decode = null;
            switch (encoding) {
                case CipherConst.ENCODING_BASE64:
                    decode = Base64Util.decodeStr2Byte(data);
                    break;
                case CipherConst.ENCODING_HEX:
                    // TODO: 2018/1/25
                    break;
                default:
                    break;
            }
            return new String(DesUtil.decrypt(decode, key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8)), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptDESede(String data, String key, int encoding) {
        try {
            byte[] decode = null;
            switch (encoding) {
                case CipherConst.ENCODING_BASE64:
                    decode = Base64Util.decodeStr2Byte(data);
                    break;
                case CipherConst.ENCODING_HEX:
                    // TODO: 2018/1/25
                    break;
                default:
                    break;
            }
            return new String(DESedeUtil.decrypt(decode, key.getBytes(CipherConst.CHARACTER_ENCODING_UTF_8)), CipherConst.CHARACTER_ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
