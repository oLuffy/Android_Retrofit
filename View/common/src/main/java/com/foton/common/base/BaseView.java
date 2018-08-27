package com.foton.common.base;

/**
 * des:baseview
 * Created by ZY
 */
public interface BaseView {
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
}
