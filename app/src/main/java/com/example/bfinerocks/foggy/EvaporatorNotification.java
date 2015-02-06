package com.example.bfinerocks.foggy;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by BFineRocks on 2/6/15.
 */
public class EvaporatorNotification extends Notification {
    Drawable icon;
    String contentTitle;
    String contentText;

    public EvaporatorNotification(Context context){
        this.icon = context.getResources().getDrawable(R.drawable.fog);
        contentTitle = "Clear The Fog";
        contentText = "Now is later. So do it now.";
    }
}
