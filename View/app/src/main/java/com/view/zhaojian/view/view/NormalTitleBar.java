package com.view.zhaojian.view.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.view.zhaojian.view.R;
import com.view.zhaojian.view.utils.DisplayUtil;


public class NormalTitleBar extends RelativeLayout {
    public ImageView image_title;
    public ImageView ivRight;
    public TextView tvTitle, tvRight;
    public RelativeLayout rlCommonTitle;
    public LinearLayout layoutBack;
    public ImageView imgLeft;
    public LinearLayout layoutClose;
    public ImageView imgClose;
    public FilterEditText filterEditText;

    public LinearLayout layoutSearch;
    public LinearLayout layoutClear;
    public TextView txtContent;
    private Context context;

    public NormalTitleBar(Context context) {
        super(context, null);
        this.context = context;
        init(context);
    }

    public NormalTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(context);
        //setHeaderHeight();
    }

    private void init(Context context){
        View view = View.inflate(context, R.layout.bar_normal, this);
        layoutBack = (LinearLayout) findViewById(R.id.layout_back);
        imgLeft = (ImageView) findViewById(R.id.img_back);
        layoutClose = (LinearLayout) findViewById(R.id.layout_close);
        imgClose = (ImageView) findViewById(R.id.img_close);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvRight = (TextView) findViewById(R.id.tv_right);
        ivRight = (ImageView) findViewById(R.id.image_right);
        image_title= (ImageView) findViewById(R.id.image_title);
        filterEditText= (FilterEditText) findViewById(R.id.edit_content);
        layoutSearch = (LinearLayout) findViewById(R.id.layout_search);
        layoutClear = (LinearLayout) findViewById(R.id.layout_clear);
        rlCommonTitle = (RelativeLayout) findViewById(R.id.common_title);
        txtContent = (TextView) findViewById(R.id.txt_content);
        layoutClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                filterEditText.setText("");
            }
        });
    }

    public void setHeaderHeight() {
        rlCommonTitle.setPadding(0, DisplayUtil.getStatusBarHeight(context), 0, 0);
        rlCommonTitle.requestLayout();
    }

    /**
     * 设置view可见
     * @param optView
     * @param visible
     */
    public void setViewsVisibility(View optView,boolean visible) {
        if (visible) {
            optView.setVisibility(View.VISIBLE);
        } else {
            optView.setVisibility(View.GONE);
        }
    }

    /**
     * 管理返回按钮
     */
    public void setBackVisibility(boolean visible) {
        if (visible) {
            layoutBack.setVisibility(View.VISIBLE);
        } else {
            layoutBack.setVisibility(View.GONE);
        }
    }

    /**
     * 设置标题栏左侧字符串
     * @param visiable
     */
    public void setTvLeftVisiable(boolean visiable){
        if (visiable){
            layoutBack.setVisibility(View.VISIBLE);
        }else{
            layoutBack.setVisibility(View.GONE);
        }
    }




    /**
     * 管理标题
     */
    public void setTitleVisibility(boolean visible) {
        if (visible) {
            tvTitle.setVisibility(View.VISIBLE);
        } else {
            tvTitle.setVisibility(View.GONE);
        }
    }

    public void setTitleText(String string) {
        tvTitle.setText(string);
    }

    public void setTitleBg(Bitmap bitmap) {
        image_title.setVisibility(VISIBLE);
        image_title.setImageBitmap(bitmap);
    }

    /**
     * 右图标
     */
    public void setRightImagVisibility(boolean visible) {
        ivRight.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    /**
     * 中部标题图片
     */
    public void setRightImagSrc(int id) {
        ivRight.setVisibility(View.VISIBLE);
        ivRight.setImageResource(id);
    }



    /*
     * 点击事件
     */
    public void setOnBackListener(OnClickListener listener) {
        layoutBack.setOnClickListener(listener);
    }

    public void setOnRightImageListener(OnClickListener listener) {
        ivRight.setOnClickListener(listener);
        tvRight.setOnClickListener(listener);
    }
}
