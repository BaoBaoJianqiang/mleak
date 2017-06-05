package jianqiang.com.testleak;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class MyApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        refWatcher = LeakCanary.install(this);

//        ExcludedRefs excludedRefs = AndroidExcludedRefs.createAppDefaults()
//                .instanceField("jianqiang.com.testleak.AppManager_fix1", "instance").build();
//
//        refWatcher = LeakCanary.refWatcher(this)
//                .excludedRefs(excludedRefs)
//                .buildAndInstall();
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    private RefWatcher refWatcher;
}
