package com.example.bfinerocks.foggy;

import android.widget.ArrayAdapter;

/**
 * Created by BFineRocks on 2/10/15.
 */
public interface FogSetPresenter {
    public void onItemSelected(ArrayAdapter adapter, int position);
    public void onClick();
}
