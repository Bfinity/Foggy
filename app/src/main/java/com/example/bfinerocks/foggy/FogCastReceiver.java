package com.example.bfinerocks.foggy;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import javax.inject.Inject;

/**
 * Created by BFineRocks on 2/9/15.
 */
public class FogCastReceiver extends BroadcastReceiver {

    @Inject
    FogHorn alarm;

    @Inject
    EvaporatorNotification notification;

    private Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        notification.sendNotification();
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
          //
        }
    }

    public void enableReceiver(Context context){
        ComponentName receiver = new ComponentName(context, FogCastReceiver.class);
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
}
