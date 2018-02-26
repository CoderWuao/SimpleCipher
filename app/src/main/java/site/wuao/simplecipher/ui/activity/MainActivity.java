package site.wuao.simplecipher.ui.activity;

import android.app.Activity;
import android.os.Bundle;

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
}
