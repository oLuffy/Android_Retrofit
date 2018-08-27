package com.foton.common.base;

import android.content.Context;

import com.foton.common.baserx.RxManager;

/**
 * des:基类presenter
 * Created by ZY
 */
public abstract class BasePresenter<T,E>{
    public Context mContext;
    public E mModel;
    public T mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }
    public void onStart(){

    }
    public void onDestroy() {
        mRxManage.clear();
    }
}
