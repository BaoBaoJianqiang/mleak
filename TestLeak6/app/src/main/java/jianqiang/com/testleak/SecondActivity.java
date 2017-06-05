package jianqiang.com.testleak;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                new Thread() {
//                    @Override public void run() {
//                        while(true);
//                    }
//                }.start();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        while(true);
                    }
                }, Long.MAX_VALUE >> 1);
            }
        });

        setContentView(button);
    }
}