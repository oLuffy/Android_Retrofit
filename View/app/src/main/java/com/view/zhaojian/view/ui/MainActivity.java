package com.view.zhaojian.view.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.foton.common.base.BaseActivity;
import com.foton.common.commonutils.ToastUitl;
import com.view.zhaojian.view.R;
import com.view.zhaojian.view.ui.animation.ObjectAnimatorActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.btn1)
    Button button1;
    @Bind(R.id.tv1)
    Button tx;
    @Bind(R.id.btn_cancel1)
    Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ValueAnimatorActivity.startAction(MainActivity.this);
//            }
//        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({
            R.id.btn1,
            R.id.tv1,
            R.id.btn_cancel1,
           })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                ValueAnimatorActivity.startAction(MainActivity.this);
                break;
            case R.id.btn_cancel1:
                ObjectAnimatorActivity.startAction(MainActivity.this);
                break;
            case R.id.tv1:

                break;

        }
    }

}
