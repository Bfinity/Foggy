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
                Foggy.class
        }
)
public class AppModule {
    private final Foggy app;

    public AppModule(Foggy app){
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext(){
        return app;
    }

}
