package com.gs.allaboutservices.utils;

import android.util.Log;

public class LogUtils {

    public static void printLog(String tag, String msg) {
        Log.d("Shyam "+tag, msg);
    }

    public static void printLog(String tag, String msg, String type) {
        switch (type.toLowerCase()) {
            case "e":
                Log.e(tag, msg);
                break;
            case "w":
                Log.w(tag, msg);
                break;
            case "i":
                Log.i(tag, msg);
                break;
            case "d":
                Log.d(tag, msg);
                break;
            default:
                Log.wtf(tag, msg);
                break;
        }
    }
}
