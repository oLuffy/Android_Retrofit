package com.view.zhaojian.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.view.zhaojian.view.R;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn)
    Button button1;
    @Bind(R.id.tv)
    TextView tx;
    @Bind(R.id.btn_cancel)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.btn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimatorActivity.startAction(MainActivity.this);
            }
        });
    }
}
