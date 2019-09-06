package com.androboy.padchouserent.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androboy.padchouserent.data.models.HouseModel;
import com.androboy.padchouserent.data.models.HouseModelImpl;

public class BaseActivity extends AppCompatActivity {

    protected HouseModel houseModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        houseModel = HouseModelImpl.getObjectInstance();

    }

}
