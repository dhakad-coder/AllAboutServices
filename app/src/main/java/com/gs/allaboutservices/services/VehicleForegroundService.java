package com.gs.allaboutservices.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.gs.allaboutservices.utils.LogUtils;
import com.gs.allaboutservices.R;

public class VehicleForegroundService extends Service {

    private static final String CHANNEL_ID = "1232";
    private final String TAG = VehicleForegroundService.class.getSimpleName();

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
        startForeground(1232, getNotification());
        return super.onStartCommand(intent, flags, startId);
    }

    private Notification getNotification() {
            NotificationChannel chan = new NotificationChannel(
                    CHANNEL_ID,
                    VehicleForegroundService.class.getSimpleName(),
                    NotificationManager.IMPORTANCE_LOW);
            chan.setLightColor(Color.BLUE);
            chan.setLockscreenVisibility(Notification.VISIBILITY_SECRET);

            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            assert manager != null;
            manager.createNotificationChannel(chan);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                    this, CHANNEL_ID);
        return notificationBuilder.setOngoing(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Babu, Your foreground service is running...")
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setChannelId(CHANNEL_ID)
                .build();
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
