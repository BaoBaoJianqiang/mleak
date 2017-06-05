package jianqiang.com.testleak;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Bundle bundle = new Bundle();
                        bundle.putString("a1", "baobao");

                        Message message = new Message();
                        message.what = 1;
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                }, Integer.MAX_VALUE);  //无限期等待，这个handler就永远释放不了
            }
        });

        setContentView(button);
    }

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String a1 = bundle.getString("a1");
            Log.v("baobao", a1);
        }
    };
}