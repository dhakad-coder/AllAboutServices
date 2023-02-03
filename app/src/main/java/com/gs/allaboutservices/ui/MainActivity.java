package com.gs.allaboutservices.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gs.allaboutservices.R;
import com.gs.allaboutservices.services.VehicleBackgroundService;
import com.gs.allaboutservices.services.VehicleForegroundService;
import com.gs.allaboutservices.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Intent foregroundServiceIntent;
    private Intent backgroundServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d(TAG, "Shyam onCreate: Back Service is running " + isMyServiceRunning());
        Log.d(TAG, "Shyam onCreate: Fore Service is running " + isForegroundServiceRunning());
        findViewById(R.id.pressme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * This is background service calling which will be active till app is not terminated
                 * service will keep on running till it in back stack or in foreground
                 * once app is killed service will stop
                 * */

                /*if (isMyServiceRunning()) {
                    Log.d(TAG, "Shyam onClick: Service Already running");
                    return;
                }

                Intent backgroundServiceIntent = new Intent(MainActivity.this, VehicleBackgroundService.class);
                startService(backgroundServiceIntent);*/

                /*
                 * This is foreground service calling
                 * Steps to follow
                 * 1. starts with startForegroundService()
                 * 2. call startForeground(id, notification); in onStartCommand method in service
                 * 3. Add a check in the activity to check if service is already running
                 *
                 * This service will be independent from application so if the app is terminated or
                 * killed, service will be running in background and a non-cancellable notification will be shown in the notification panel
                 *
                 * */
                if (isForegroundServiceRunning()) {
                    Log.d(TAG, "Shyam onClick: Foreground Service Already running");
                    return;
                }
                foregroundServiceIntent = new Intent(MainActivity.this, VehicleForegroundService.class);
                startForegroundService(foregroundServiceIntent);
                Log.d(TAG, "Shyam onClick: Service started running");
            }
        });

        findViewById(R.id.stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * Stopping foreground service
                 * */
                if (foregroundServiceIntent != null)
                    stopService(foregroundServiceIntent);
                /*
                 * Stopping background service
                 * */
                if (backgroundServiceIntent != null)
                    stopService(backgroundServiceIntent);
            }
        });
    }

    /*
     * Checking if VehicleBackgroundService is running or not
     * */
    public boolean isMyServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (VehicleBackgroundService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /*
     * Checking if VehicleForegroundService is running or not
     * */
    public boolean isForegroundServiceRunning() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            LogUtils.printLog(TAG, "Loop " + service.clientPackage);
            if (VehicleForegroundService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}