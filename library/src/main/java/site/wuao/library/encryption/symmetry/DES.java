package site.wuao.library.encryption.symmetry;

import java.security.Key;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


/**
 * DES
 *
 * @author wuao
 * @date 2018/1/30
 * @github {https://github.com/CoderWuao}
 * @note -
 * ---------------------------------------------------------------------------------------------------------------------
 * @modified -
 * @date -
 * @github -
 * @note -
 */
public class DES extends SymmetricEncryption {
    /** 密钥长度 */
    public static final int KEY_SIZE_56 = 56;
    /** 工作模式 */
    public static final String WORK_MODE_ECB = "ECB";
    /** 工作模式 */
    public static final String WORK_MODE_CBC = "CBC";
    /** 工作模式 */
    public static final String WORK_MODE_PCBC = "PCBC";
    /** 工作模式 */
    public static final String WORK_MODE_CTR = "CTR";
    /** 工作模式 */
    public static final String WORK_MODE_CTS = "CTS";
    /** 工作模式 */
    public static final String WORK_MODE_CFB = "CFB";
    /** 工作模式 */
    public static final String WORK_MODE_OFB = "OFB";
    /** 填充方式 */
    public static final String PADDING_MODE_NoPadding = "NoPadding";
    /** 填充方式 */
    public static final String PADDING_MODE_PKCS5Padding = "PKCS5Padding";
    /** 填充方式 */
    public static final String PADDING_MODE_ISO10126Padding = "ISO10126Padding";

    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "DES";

    /**
     * 私有构造方法
     */
    private DES() {
        super(KEY_ALGORITHM);
    }

    /**
     * 获取单例对象
     *
     * @return 单例
     */
    public static DES getInstance() {
        return DESHolder.sInstance;
    }

    @Override
    protected Key transformKey(byte[] key) {
        Exception exception;
        try {
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(getKeyAlgorithm());
            return secretKeyFactory.generateSecret(desKeySpec);
        } catch (Exception e) {
            exception = e;
        }
        if (exception != null) {
            throw new RuntimeException(exception.getMessage());
        }
        return null;
    }

    /**
     * 单例持有者
     */
    private static class DESHolder {
        /** 单例对象 */
        private static final DES sInstance = new DES();
    }
}