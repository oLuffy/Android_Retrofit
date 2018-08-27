package com.view.zhaojian.view.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * APPLICATION
 */
public class BaseApplication extends Application {

    private static BaseApplication baseApplication;
    private static int mMainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        mMainThreadId = android.os.Process.myTid();
    }

    public static Context getAppContext() {
        return baseApplication;
    }
    public static Resources getAppResources() {
        return baseApplication.getResources();
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }
}
