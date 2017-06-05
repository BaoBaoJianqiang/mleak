package jianqiang.com.testleak;

import android.content.Context;
import android.util.Log;

import java.lang.ref.WeakReference;

public class AppManager_fix2 {
    private static AppManager_fix2 instance;

    private WeakReference<Context> reference = null;

    private AppManager_fix2(Context context) {
        reference = new WeakReference<Context>(context);
    }

    public static AppManager_fix2 getInstance(Context context) {
        if(instance == null) {
            instance = new AppManager_fix2(context);
        }

        return instance;
    }

    public void doSomething() {
        Context context = reference.get();
        if(context == null) {
            Log.v("baobao", "null");
        } else {
            Log.v("baobao", "not null");
        }
    }
}
