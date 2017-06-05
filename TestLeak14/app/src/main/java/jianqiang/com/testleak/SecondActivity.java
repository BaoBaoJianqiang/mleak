package jianqiang.com.testleak;

import android.os.Bundle;
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
            AppManager_fix3.getInstance(SecondActivity.this).doSomething();
            }
        });

        setContentView(button);
    }
}