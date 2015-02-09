package com.example.bfinerocks.foggy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.example.bfinerocks.foggy.models.FogLevel;

import java.util.Calendar;

/**
 * Created by BFineRocks on 2/9/15.
 */
public class FogHorn {
    private AlarmManager fogAlarm;
    private PendingIntent alarmIntent;
    private FogLevel fogLevel;

    public FogHorn(Context context, FogLevel fogLevel){
        this.fogLevel = fogLevel;
        fogAlarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, FogHorn.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    public long getFogLevelAlarmSetting(){
        switch (fogLevel){
            case Light:
                return AlarmManager.INTERVAL_DAY;
            case Medium:
                return AlarmManager.INTERVAL_HALF_DAY;
            case Heavy:
                return AlarmManager.INTERVAL_HOUR;
            default:
                return AlarmManager.INTERVAL_DAY;
        }
    }

    public void setFogAlarm(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        long alarmSetting = getFogLevelAlarmSetting();
        fogAlarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmSetting, alarmIntent);
    }


}
