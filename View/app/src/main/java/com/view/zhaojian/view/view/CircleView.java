package com.view.zhaojian.view.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhaojian4 on 2018/8/28.
 */

public class CircleView extends View{
    Context mContext;
    public CircleView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        float []pts={10,10,100,100,200,200,400,400};
        Paint paint = new Paint();//第一步新建画笔
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setColor(Color.GREEN);//设置画笔颜色
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);//设置填充风格   FILL为全部填充，FILL_AND_STROKE为填充内容和描边  这两者没有区别，STROKE为只描边
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);//设置画笔宽度
        canvas.drawRGB(200,200,200);//设置画布背景颜色
        canvas.drawCircle(190,200,150,paint);//画圆
        canvas.drawLine(50,50,300,600,paint);//画线
        canvas.drawLines(pts,paint);//画多条线
        canvas.drawPoint(800,800,paint);//画点
        RectF rectF = new RectF(10,300,400,800);
        canvas.drawRect(rectF,paint);//画矩形
        RectF rectF1 = new RectF(400,300,600,800);
        canvas.drawRoundRect(rectF1,10,10,paint);//画圆角矩形
        canvas.drawOval(rectF,paint);//画椭圆
        RectF rectF2= new RectF(100, 10, 300, 100);

        canvas.drawArc(rectF,0,90,false,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
    }
}
