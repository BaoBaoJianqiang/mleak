package jianqiang.com.testleak;

import android.content.Context;

public class AppManager_fix1 {
    private static AppManager_fix1 instance;

    private Context context;
    private AppManager_fix1(Context context) {
        this.context = context.getApplicationContext();
    }

    public static AppManager_fix1 getInstance(Context context) {
        if(instance == null) {
            instance = new AppManager_fix1(context);
        }

        return instance;
    }

    public void doSomething() {
        //
    }
}
