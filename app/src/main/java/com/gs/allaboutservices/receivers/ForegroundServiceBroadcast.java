package com.gs.allaboutservices.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gs.allaboutservices.utils.LogUtils;
import com.gs.allaboutservices.services.VehicleForegroundService;

/*
* This class is used to start the service when boot completed action received by Broadcast receiver
* This needs a permission RECEIVE_BOOT_COMPLETED
* Also need to add action android.intent.action.BOOT_COMPLETED in manifest file.
*
* */
public class ForegroundServiceBroadcast extends BroadcastReceiver {

    private final String TAG = ForegroundServiceBroadcast.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            LogUtils.printLog(TAG, "Boot completed action received");
            Intent intent1 = new Intent(context, VehicleForegroundService.class);
            context.startForegroundService(intent1);
        } else {
            LogUtils.printLog(TAG, "Action received : " + intent.getAction(), "e");
        }
    }
}
