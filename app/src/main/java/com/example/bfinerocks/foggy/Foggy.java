package com.example.bfinerocks.foggy;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by BFineRocks on 2/10/15.
 */
public class Foggy extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    protected List<Object> getModules(){
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopedGraph(Object... modules){
        return objectGraph = objectGraph.plus(modules);
    }

    public void inject(Object object){
        objectGraph.inject(object);
    }

}
