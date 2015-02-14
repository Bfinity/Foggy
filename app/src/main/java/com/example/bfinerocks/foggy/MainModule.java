package com.example.bfinerocks.foggy;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by BFineRocks on 2/10/15.
 */

@Module(
        library = true,
        injects = {
                MainActivity.class,
                MainFragment.class,
                BaseFragment.class,
                FogSetPresenterImpl.class,
                FogCastReceiver.class
        },
        addsTo = AppModule.class
)

public class MainModule {

    private FogView view;
    private GraphImplementer grapher;

    public MainModule(FogView fogView, GraphImplementer grapher){
        this.view = fogView;
        this.grapher = grapher;
    }

    @Provides
    @Singleton
    public FogView provideFogView(){
        return view;
    }

    @Provides
    @Singleton public GraphImplementer providerGrapher(){
        return grapher;
    }

    @Provides
    @Singleton
    public FogSetPresenter providePresenter(FogView fogView){
        return new FogSetPresenterImpl(fogView, grapher);
    }

    @Provides
    @Singleton
    public EvaporatorNotification provideNotification(Context context){
        return new EvaporatorNotification(context);
    }

    @Provides
    @Singleton
    public FogHorn provideFogHornAlarm(Context context){
        return new FogHorn(context);
    }

    @Provides
    @Singleton
    public FogCastReceiver provideReceiver(){
        return new FogCastReceiver();
    }

}
