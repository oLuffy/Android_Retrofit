package com.view.zhaojian.view.ui.paint;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.foton.common.base.BaseActivity;
import com.view.zhaojian.view.R;
import com.view.zhaojian.view.ui.MainActivity;
import com.view.zhaojian.view.ui.ValueAnimatorActivity;
import com.view.zhaojian.view.ui.animation.ObjectAnimatorActivity;
import com.view.zhaojian.view.view.CircleView;

import butterknife.Bind;
import butterknife.OnClick;

public class Paint1Activity extends BaseActivity {
    @Bind(R.id.root)
    FrameLayout rootFrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_paint1;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        rootFrag.addView(new CircleView(this));
    }

    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, Paint1Activity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
//    @OnClick({
//            R.id.root,
//
//    })
////    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn1:
//                ValueAnimatorActivity.startAction(Paint1Activity.this);
//                break;
//
//
//        }
//    }
}
