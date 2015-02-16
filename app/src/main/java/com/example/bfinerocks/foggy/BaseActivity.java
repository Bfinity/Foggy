package com.example.bfinerocks.foggy;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import dagger.ObjectGraph;

/**
 * Created by BFineRocks on 2/10/15.
 */
public abstract class BaseActivity extends ActionBarActivity{

    private ObjectGraph activityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
/*        activityGraph = ((Foggy)getApplication()).createScopedGraph(getModules().toArray());
        activityGraph.inject(this);*/

}
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

 //   protected abstract List<Object> getModules();

}
