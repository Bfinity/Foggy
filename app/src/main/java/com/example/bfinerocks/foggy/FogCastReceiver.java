package com.example.bfinerocks.foggy;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * Created by BFineRocks on 2/9/15.
 */
public class FogCastReceiver extends BroadcastReceiver {

    private Context mContext;
    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        //todo display notification
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            //todo set alarm
        }
    }

    public void enableReceiver(){
        ComponentName receiver = new ComponentName(mContext, FogCastReceiver.class);
        PackageManager packageManager = mContext.getPackageManager();
        packageManager.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }
}
