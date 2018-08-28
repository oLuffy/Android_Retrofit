package com.view.zhaojian.view.ui.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.view.zhaojian.view.R;

import butterknife.Bind;

public class ObjectAnimatorActivity extends AppCompatActivity {
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
        tx = (TextView) findViewById(R.id.tv);
        button1= (Button) findViewById(R.id.btn);
        button2= (Button) findViewById(R.id.btn_cancel);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation1();
            }
        });
    }
    /**
     * 入口
     *
     * @param activity
     */
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, ObjectAnimatorActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
    }
    public void doAnimation(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tx,"alpha",1,0,1);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }
    public void doAnimation2(){
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                char text = (char)animation.getAnimatedValue();
                tx.setText(String.valueOf(text));
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                doAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.setInterpolator(new MyInterploator1());
        valueAnimator.start();
    }
    public class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt  = (int)startValue;
            int endInt = (int)endValue;
            int curInt = (int)(startInt + fraction *(endInt - startInt));
            char result = (char)curInt;
            return result;
        }
    }

    public void doAnimation1(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,1800);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                tx.layout(tx.getLeft(),curValue,tx.getRight(),curValue+tx.getHeight());
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                doAnimation2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.setInterpolator(new MyInterploator1());
        valueAnimator.start();
    }
    public class MyInterploator implements TimeInterpolator{

        @Override
        public float getInterpolation(float input) {
            return 1-input;
        }
    }
    public class MyInterploator1 implements TimeInterpolator{

        @Override
        public float getInterpolation(float input) {
            return input;
        }
    }
}
