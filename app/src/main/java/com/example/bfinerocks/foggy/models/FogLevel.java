package com.example.bfinerocks.foggy.models;

/**
 * Created by BFineRocks on 2/6/15.
 */
public enum FogLevel {
    Light(1),
    Medium(3),
    Heavy(6);

    private final int numberOfReminders;

    FogLevel(int numberOfReminders){
        this.numberOfReminders = numberOfReminders;
    }

    public int getNumberOfReminders(){
        return numberOfReminders;
    }
}
