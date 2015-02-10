package com.example.bfinerocks.foggy;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by BFineRocks on 2/10/15.
 */
public abstract class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ((Foggy)getApplication()).inject(this);
    }
}
