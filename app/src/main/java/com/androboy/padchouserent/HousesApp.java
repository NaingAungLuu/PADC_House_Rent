package com.androboy.padchouserent;

import android.app.Application;

import com.androboy.padchouserent.data.models.HouseModelImpl;

public class HousesApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        HouseModelImpl.initializeHouseModel(getApplicationContext());
    }
}
