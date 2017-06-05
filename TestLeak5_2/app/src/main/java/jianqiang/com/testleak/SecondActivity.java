package jianqiang.com.testleak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.ref.WeakReference;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new CustomHandler(this);

        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mHandler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.e("baobao", "msg send");
//
//                        Bundle bundle = new Bundle();
//                        bundle.putString("a1", "baobao");
//
//                        Message message = new Message();
//                        message.what = 1;
//                        message.setData(bundle);
//                        mHandler.sendMessage(message);
//                    }
//                }, 10000);  //无限期等待，这个handler就永远释放不了

                new Thread() {
                    @Override
                    public void run() {

                        mHandler.sendEmptyMessageDelayed(1, 10000);
                        Log.e("baobao", "msg send");
                    }
                }.start();
            }
        });

        setContentView(button);
    }

    private CustomHandler mHandler;
    static class CustomHandler extends Handler {
        // 内部声明一个弱引用，引用外部类
        private WeakReference<SecondActivity> reference;
        public CustomHandler(SecondActivity activity) {
            reference= new WeakReference<SecondActivity>(activity); }

        @Override
        public void handleMessage(Message msg) {
            SecondActivity activity = reference.get();
            if(null == activity){
                Log.e("baobao", "null");
            }else{
                Log.e("baobao", "not null");
            }
        }
    }
}
