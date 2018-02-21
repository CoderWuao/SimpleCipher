package site.wuao.simplecipher.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.io.UnsupportedEncodingException;

import site.wuao.library.digest.MD5Util;
import site.wuao.library.digest.SHA1Util;
import site.wuao.library.encode.Base64Util;
import site.wuao.library.encode.HexUtil;
import site.wuao.library.encryption.asymmetry.RSA;
import site.wuao.library.encryption.asymmetry.RSAKey;
import site.wuao.library.encryption.symmetry.AES;
import site.wuao.library.encryption.symmetry.DES;
import site.wuao.library.encryption.symmetry.DESede;
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
public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void md5(View view) {
        String data = "MD5消息摘要";

        String digest = MD5Util.digestHex(data);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "摘要: " + digest);

        // aa24863099cf24696d4eb0f82c918849
    }

    public void sha1(View view) {
        String data = "MD5消息摘要";

        String digest = SHA1Util.digestHex(data);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "摘要: " + digest);
    }

    public void hex(View view) {
        String data = "wuao";

        String encode = HexUtil.encodeString(data);
        String decode = HexUtil.decodeString(encode);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "编码: " + encode);
        Log.i(TAG, "解码: " + decode);
    }

    public void base64(View view) {
        String data = "wuao";

        String encode = Base64Util.encodeString(data);
        String decode = Base64Util.decodeString(encode);

        Log.i(TAG, "原文：" + data);
        Log.i(TAG, "编码：" + encode);
        Log.i(TAG, "解码：" + decode);

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
        desBase64();
        desHex();
        desCustomKey();
    }

    private void desBase64() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void desHex() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyHex);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void desCustomKey() {
        DES instance = DES.getInstance();
        instance.init(DES.KEY_SIZE_56, DES.WORK_MODE_ECB, DES.PADDING_MODE_PKCS5Padding);

        String data = "SimpleSipher";
        String key = "wuaowuao";

        String keyBase64 = Base64Util.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    public void desede(View view) {
        desedeBase64();
        desedeHex();
        desedeCustomKey();
    }

    private void desedeBase64() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void desedeHex() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyHex);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void desedeCustomKey() {
        DESede instance = DESede.getInstance();
        instance.init(DESede.KEY_SIZE_168, DESede.WORK_MODE_ECB, DESede.PADDING_MODE_PKCS5Padding);

        String data = "SimpleCipher";
        String key = "wuaowuao";
        String keyBase64 = Base64Util.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    public void aes(View view) throws UnsupportedEncodingException {
        aesBase64();
        aesHex();
        aesCustomKey();
    }

    private void aesBase64() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyBase64 = instance.createKeyBase64();

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void aesHex() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "wuao";
        String keyHex = instance.createKeyHex();

        String encrypt = instance.encryptHex(data, keyHex);
        String decrypt = instance.decryptHex(encrypt, keyHex);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyHex);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    private void aesCustomKey() {
        AES instance = AES.getInstance();
        instance.init(AES.KEY_SIZE_128, AES.WORK_MODE_ECB, AES.PADDING_MODE_PKCS5Padding);

        String data = "SimpleCipher";
        String key = "wuaowuaowuaowuao";
        String keyBase64 = Base64Util.encodeString(key);

        String encrypt = instance.encryptBase64(data, keyBase64);
        String decrypt = instance.decryptBase64(encrypt, keyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "密钥: " + keyBase64);
        Log.i(TAG, "加密: " + encrypt);
        Log.i(TAG, "解密: " + decrypt);
    }

    public void rsa(View view) {
        rsaBase64();
        rsaHex();
    }

    private void rsaBase64() {
        RSA instance = RSA.getInstance();
        instance.init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        String data = "wuao";
        RSAKey key = instance.createKey();

        String encryptByPublicKey = instance.encryptByPublicKeyBase64(data, key.publicKeyBase64);
        String decryptByPrivateKey = instance.decryptByPrivateKeyBase64(encryptByPublicKey, key.privateKeyBase64);

        String encryptByPrivateKey = instance.encryptByPrivateKeyBase64(data, key.privateKeyBase64);
        String decryptByPublicKey = instance.decryptByPublicKeyBase64(encryptByPrivateKey, key.publicKeyBase64);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "公钥: " + key.publicKeyBase64);
        Log.i(TAG, "私钥: " + key.privateKeyBase64);
        Log.i(TAG, "公钥加密: " + encryptByPublicKey);
        Log.i(TAG, "私钥解密: " + decryptByPrivateKey);
        Log.i(TAG, "私钥加密: " + encryptByPrivateKey);
        Log.i(TAG, "公钥解密: " + decryptByPublicKey);
    }

    private void rsaHex() {
        RSA instance = RSA.getInstance();
        instance.init(RSA.KEY_SIZE_512, RSA.WORK_MODE_ECB, RSA.PADDING_MODE_PKCS1Padding);

        String data = "wuao";
        RSAKey key = instance.createKey();

        String encryptByPublicKey = instance.encryptByPublicKeyHex(data, key.publicKeyHex);
        String decryptByPrivateKey = instance.decryptByPrivateKeyHex(encryptByPublicKey, key.privateKeyHex);

        String encryptByPrivateKey = instance.encryptByPrivateKeyHex(data, key.privateKeyHex);
        String decryptByPublicKey = instance.decryptByPublicKeyHex(encryptByPrivateKey, key.publicKeyHex);

        Log.i(TAG, "原文: " + data);
        Log.i(TAG, "公钥: " + key.publicKeyHex);
        Log.i(TAG, "私钥: " + key.privateKeyHex);
        Log.i(TAG, "公钥加密: " + encryptByPublicKey);
        Log.i(TAG, "私钥解密: " + decryptByPrivateKey);
        Log.i(TAG, "私钥加密: " + encryptByPrivateKey);
        Log.i(TAG, "公钥解密: " + decryptByPublicKey);
    }
}
