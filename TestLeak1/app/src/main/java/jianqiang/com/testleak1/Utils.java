package jianqiang.com.testleak1;

import android.app.Activity;
import android.content.Intent;

public class Utils {

    private static Activity sActivity;

    public static void setActivity(Activity activity) {
        sActivity = activity;
    }

    public static void startActivity(Class nextActivity) {
        Intent intent = new Intent(sActivity, nextActivity);
        sActivity.startActivity(intent);
    }

    public static void reset() {
        sActivity = null;
    }
}
