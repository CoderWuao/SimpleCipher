package site.wuao.simplecipher.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.io.UnsupportedEncodingException;

import site.wuao.library.base64.Base64Util;
import site.wuao.library.cipher.CipherUtil;
import site.wuao.library.constant.CipherConst;
import site.wuao.library.desede.DESedeUtil;
import site.wuao.simplecipher.R;

/**
 * 首页
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
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void base64(View view) {
        String data = "wuao";

        String result = Base64Util.encodeStr2Str(data);
        String origin = Base64Util.decodeStr2Str(result);

        Log.i(TAG, "原文：" + data);
        Log.i(TAG, "编码：" + result);
        Log.i(TAG, "解码：" + origin);

        // 原文：wuao
        // 编码：d3Vhbw==
        // 解码：wuao

        String result01 = new String(Base64.encode(data.getBytes(), Base64.DEFAULT));
        String result02 = new String(Base64.encode(data.getBytes(), Base64.NO_PADDING));
        String result03 = new String(Base64.encode(data.getBytes(), Base64.NO_WRAP));
        String result04 = new String(Base64.encode(data.getBytes(), Base64.CRLF));
        String result05 = new String(Base64.encode(data.getBytes(), Base64.URL_SAFE));
        String result06 = new String(Base64.encode(data.getBytes(), Base64.NO_CLOSE));

        Log.i(TAG, "size:" + result01.length() + " DEFAULT:" + result01);
        Log.i(TAG, "size:" + result02.length() + " NO_PADDING:" + result02);
        Log.i(TAG, "size:" + result03.length() + " NO_WRAP:" + result03);
        Log.i(TAG, "size:" + result04.length() + " CRLF:" + result04);
        Log.i(TAG, "size:" + result05.length() + " URL_SAFE:" + result05);
        Log.i(TAG, "size:" + result06.length() + " NO_CLOSE:" + result06);

        // size:9  DEFAULT:    d3Vhbw==
        // size:7  NO_PADDING: d3Vhbw
        // size:8  NO_WRAP:    d3Vhbw==
        // size:10 CRLF:       d3Vhbw==
        // size:9  URL_SAFE:   d3Vhbw==
        // size:9  NO_CLOSE:   d3Vhbw==
    }

    public void des(View view) throws UnsupportedEncodingException {
//        String str = "wuao";
//        // key
//        byte[] bytes = DesUtil.createKey();
//        String encodeByte2Byte = new String(Base64Util.encodeByte2Byte(bytes));
//        // 加密
//        byte[] encrypt = DesUtil.encrypt(str.getBytes(), bytes);
//        String encode1 = Base64Util.encodeByte2Str(encrypt);
//        // 解密
//        byte[] decrypt = DesUtil.decrypt(encrypt, bytes);
//        String outPut = new String(decrypt);
//        Log.i(TAG, "des: " + encodeByte2Byte);
//        Log.i(TAG, "des: " + encode1);
//        Log.i(TAG, "des: " + outPut);


//        String java = Base64Util.encodeByte2Byte("Java加密与解密的艺术");
//        String s = Base64Util.decryptBase64AsStr(java);
//        Log.i(TAG, "des: " + java);
//        Log.i(TAG, "des: " + s);


        String data = "SimpleCipher";
        String key = "wuaowuao";

//        byte[] bytes = DesUtil.createKey();
//        String key = new String(bytes, CipherConst.CHARACTER_ENCODING_UTF_8);

//        String result = Base64Util.encodeByte2Str(DesUtil.encrypt(data.getBytes(), key.getBytes()));
//        String origin = new String(DesUtil.decrypt(Base64Util.decodeStr2Byte(result), key.getBytes()));

        String result = CipherUtil.encryptDes(data, key, CipherConst.ENCODING_BASE64);
        String origin = CipherUtil.decryptDes(result, key, CipherConst.ENCODING_BASE64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + key);
        Log.i(TAG, "加密: " + result);
        Log.i(TAG, "解密: " + origin);
    }

    public void desede(View view) {
        String data = "SimpleCipher";
//        String key = "wuaowuao";
//        String key = CipherUtil.createDESedeKey(CipherConst.ENCODING_BASE64);
        String key = new String(DESedeUtil.createKey());


        String encrypt = CipherUtil.encryptDESede(data, key, CipherConst.ENCODING_BASE64);
        String decrypt = CipherUtil.decryptDESede(encrypt, key, CipherConst.ENCODING_BASE64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + key);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    public void aes(View view) {
    }

    public void rsa(View view) {
    }
}
