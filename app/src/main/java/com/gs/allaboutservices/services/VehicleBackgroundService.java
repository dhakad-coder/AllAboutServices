package com.gs.allaboutservices.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.gs.allaboutservices.utils.LogUtils;

public class VehicleBackgroundService extends Service {

    private final String TAG = VehicleBackgroundService.class.getSimpleName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        return null;
    }

    @Override
    public void onDestroy() {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        LogUtils.printLog(TAG, "onDestroy Service is killed");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onRebind(intent);
    }

    @Nullable
    @Override
    public ComponentName startService(Intent service) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        return super.startService(service);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onLowMemory();
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onTrimMemory(int level) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        super.onTrimMemory(level);
    }

    @Nullable
    @Override
    public ComponentName startForegroundService(Intent service) {
        LogUtils.printLog(TAG, new Throwable().getStackTrace()[0].getMethodName());
        return super.startForegroundService(service);
    }
}
