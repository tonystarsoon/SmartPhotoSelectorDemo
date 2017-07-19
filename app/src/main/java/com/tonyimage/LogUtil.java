package com.tonyimage;

import android.util.Log;

/**
 *
 */

public class LogUtil {
    private LogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isDebug = true;
    private static final String TAG = "DriverApp";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        LogUtil.i(TAG, msg);
    }

    public static void d(String msg) {
        LogUtil.d(TAG, msg);
    }

    public static void e(String msg) {
        LogUtil.e(TAG, msg);

    }

    public static void v(String msg) {
        LogUtil.v(TAG, msg);

    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg == null ? "null" : msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg == null ? "null" : msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg == null ? "null" : msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg == null ? "null" : msg);
    }
}
