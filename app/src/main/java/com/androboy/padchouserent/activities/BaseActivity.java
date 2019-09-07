package com.androboy.padchouserent.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androboy.padchouserent.data.models.HouseModel;
import com.androboy.padchouserent.data.models.HouseModelImpl;

public class BaseActivity extends AppCompatActivity {

    protected HouseModel mhouseModel;

    public BaseActivity(){ mhouseModel = HouseModelImpl.getObjectInstance();}

}
