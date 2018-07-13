package com.z.baselibrary.log;

import android.util.Log;

import com.z.baselibrary.Config;

/**
 * Created by zhangkb on 2017/12/25 0025.
 */

public class LogUtils {


    private static final String TAG = "LogUtils";
    private static LogUtils logUtils;
    private static boolean isDebug = Config.getConfig().isDebug();

    private LogUtils() {
    }


    public static  LogUtils getInstance() {
        if (logUtils == null) {
            logUtils = new LogUtils();
        }
        return logUtils;

    }
    public void d(String text) {
        if (isDebug) {
            Log.d(TAG, text);
        }

    }

    public void d(String tag, String text) {
        if (isDebug) {
            Log.d(tag, text);
        }

    }

    public void e(String tag, String text) {
        if (isDebug) {
            Log.e(tag, text);
        }

    }
}
