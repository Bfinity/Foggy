package com.example.bfinerocks.foggy;

import android.app.Fragment;
import android.os.Bundle;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by BFineRocks on 2/10/15.
 */
public abstract class BaseFragment extends Fragment implements GraphImplementer {

    private ObjectGraph activityGraph;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        activityGraph = ((Foggy)getActivity().getApplication()).createScopedGraph(getModules().toArray());
        activityGraph.inject(this);
    }

    @Override
    public void injectToGraph(Object object) {
        activityGraph.inject(object);
    }


    protected abstract List<Object> getModules();
}
