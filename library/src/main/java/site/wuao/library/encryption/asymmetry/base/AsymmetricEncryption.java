package site.wuao.library.encryption.asymmetry.base;

import site.wuao.library.encryption.base.Encryption;

/**
 * 非对称加密
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
public class AsymmetricEncryption extends Encryption {
    /**
     * 构造函数
     *
     * @param keyAlgorithm 密钥算法
     */
    protected AsymmetricEncryption(String keyAlgorithm) {
        super(keyAlgorithm);
    }
}
