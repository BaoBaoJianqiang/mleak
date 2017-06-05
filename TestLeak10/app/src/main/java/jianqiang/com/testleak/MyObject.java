package jianqiang.com.testleak;

import android.support.v4.util.Pools;

public class MyObject {

    private static Pools.SynchronizedPool<MyObject> MY_POOLS
            = new Pools.SynchronizedPool<>(10);

    public static MyObject obtain() {
        MyObject object = MY_POOLS.acquire();
        if (object == null)
            object = new MyObject();
        return object;
    }

    public void recycle() {
        MY_POOLS.release(this);
    }
}
