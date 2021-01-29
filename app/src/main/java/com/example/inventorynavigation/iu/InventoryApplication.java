package com.example.inventorynavigation.iu;

import android.app.Application;


import com.example.inventorynavigation.data.InventoryDatabase;
import com.example.inventorynavigation.iu.preferences.InventoryPreferences;

public class InventoryApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InventoryDatabase.create(this);
        InventoryPreferences.newInstance(this);
    }
}
