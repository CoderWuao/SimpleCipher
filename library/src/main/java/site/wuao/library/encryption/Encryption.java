package site.wuao.library.encryption;

import android.text.TextUtils;

import java.security.InvalidParameterException;

/**
 * 加密
 *
 * @author wuao
 * @date 2018/2/5
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class Encryption {
    /** 密钥算法 */
    protected String mKeyAlgorithm;

    /** 密钥长度 */
    private int mKeySize;
    /** 加密解密算法/工作模式/填充方式 */
    private String mCipherAlgorithm;

    /**
     * 构造函数
     *
     * @param keyAlgorithm 密钥算法
     */
    protected Encryption(String keyAlgorithm) {
        mKeyAlgorithm = keyAlgorithm;
    }

    /**
     * 获取密钥长度
     *
     * @return 密钥长度
     */
    protected int getKeySize() {
        if (mKeySize == 0) {
            throw new RuntimeException("please call the method \"init\" first");
        }
        return mKeySize;
    }

    /**
     * 获取加密算法
     *
     * @return 加密算法
     */
    protected String getCipherAlgorithm() {
        if (mCipherAlgorithm == null) {
            throw new RuntimeException("please call the method \"init\" first");
        }
        return mCipherAlgorithm;
    }

    /**
     * 初始化
     *
     * @param keySize 密钥长度
     * @param workMode 工作模式
     * @param paddingMode 填充方式
     */
    public void init(int keySize, String workMode, String paddingMode) {
        if (keySize <= 0) {
            throw new InvalidParameterException("invalid keySize: " + keySize + " bits");
        }
        if (TextUtils.isEmpty(workMode)) {
            throw new InvalidParameterException("invalid workMode: " + workMode);
        }
        if (TextUtils.isEmpty(paddingMode)) {
            throw new InvalidParameterException("invalid paddingMode: " + paddingMode);
        }

        mKeySize = keySize;
        mCipherAlgorithm = mKeyAlgorithm + "/" + workMode + "/" + paddingMode;
    }
}
