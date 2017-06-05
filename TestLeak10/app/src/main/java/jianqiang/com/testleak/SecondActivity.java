package jianqiang.com.testleak;

import android.os.Bundle;
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
                for(int i = 0; i< 1000; i++) {
                    //Object obj = new Object();

                    Object obj = MyObject.obtain();

                    Log.v("baobao", obj.hashCode() + "");
                }
            }
        });

        setContentView(button);
    }
}