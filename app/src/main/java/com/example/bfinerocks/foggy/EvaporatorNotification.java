package com.example.bfinerocks.foggy;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

/**
 * Created by BFineRocks on 2/6/15.
 */
public class EvaporatorNotification {
    Context mContext;
    int icon;
    String contentTitle;
    String contentText;
    int mId;

    public EvaporatorNotification(Context context){
        this.mContext = context;
        this.icon = R.drawable.fog;
        this.contentTitle = "Clear The Fog";
        this.contentText = "Now is later. So do it Now.";
        this.mId = 100;
    }

    public void sendNotification(){
        Notification.Builder builder = new Notification.Builder(mContext)
                .setSmallIcon(icon)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setAutoCancel(true);
        NotificationManager manager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(mId,builder.build());
    }


}
