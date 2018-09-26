package com.z.baselibrary;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;
import com.z.baselibrary.net.HttpUtil;


/**
 * @author zhangkb
 * @date 2018/2/6 0006
 */

public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        HttpUtil.init(this);
        //  HttpUtil.init(this.getApplicationContext());
        String id = "d221d30451";
        Bugly.init(getApplicationContext(), id, true);
        CrashReport.initCrashReport(getApplicationContext(), id, false);

        Stetho.initializeWithDefaults(this);


    }


    public static BaseApplication get() {

        return application;
    }
}
