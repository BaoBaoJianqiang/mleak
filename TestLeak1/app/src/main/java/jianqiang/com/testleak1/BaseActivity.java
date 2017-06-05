package jianqiang.com.testleak1;

import android.app.Activity;
import android.os.Bundle;

import com.squareup.leakcanary.RefWatcher;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //增加这一句，可以防止因Utils导致的内存泄漏
        //Utils.reset();

        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }
}
