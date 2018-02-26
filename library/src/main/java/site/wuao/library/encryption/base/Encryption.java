package site.wuao.library.encryption.base;

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
    private String mKeyAlgorithm;
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
        if (workMode == null || "".equals(workMode)) {
            throw new InvalidParameterException("invalid workMode: " + workMode);
        }
        if (paddingMode == null || "".equals(paddingMode)) {
            throw new InvalidParameterException("invalid paddingMode: " + paddingMode);
        }

        mKeySize = keySize;
        mCipherAlgorithm = mKeyAlgorithm + "/" + workMode + "/" + paddingMode;
    }

    /**
     * 获取密钥算法
     *
     * @return 密钥算法
     */
    protected String getKeyAlgorithm() {
        if (mKeyAlgorithm == null) {
            throw new RuntimeException("You do not define the key algorithm");
        }
        return mKeyAlgorithm;
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
}
