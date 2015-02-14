package com.example.bfinerocks.foggy;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.bfinerocks.foggy.models.FogLevel;

import javax.inject.Inject;


/**
 * Created by BFineRocks on 2/10/15.
 */
public class FogSetPresenterImpl implements FogSetPresenter {

    @Inject
    Context context;

    @Inject
    FogHorn alarm;

    @Inject
    FogCastReceiver receiver;

    private FogView fogView;
    private GraphImplementer grapher;
    private FogLevel fogLevel;

    @Inject
    public FogSetPresenterImpl(FogView fogView, GraphImplementer graphImplementer){
        this.fogView = fogView;
        this.grapher = graphImplementer;
        grapher.injectToGraph(this);
    }


    @Override
    public void onItemSelected(ArrayAdapter adapter, int position) {
        setFogLevel(position);
        fogView.updateTextView(String.valueOf(fogLevel.getNumberOfReminders()));

    }

    @Override
    public void onClick() {
        fogView.showSettingsSaved(context.getString(R.string.selection_screen_saved_toast));
        receiver.enableReceiver(context);
        alarm.setFogAlarm(fogLevel);
    }

    public void setFogLevel(int positionSelected){
        switch (positionSelected){
            case 0:
                fogLevel = FogLevel.Light;
                break;
            case 1:
                fogLevel = FogLevel.Medium;
                break;
            case 2:
                fogLevel = FogLevel.Heavy;
                break;
            default:
                break;
        }

    }
}
