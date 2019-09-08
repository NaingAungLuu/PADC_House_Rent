package com.androboy.padchouserent.data.models;

import android.content.Context;

import com.androboy.padchouserent.network.dataAgents.HouseDataAgent;
import com.androboy.padchouserent.network.dataAgents.HttpUrlHouseDataAgentImpl;
import com.androboy.padchouserent.network.dataAgents.OkHttpDataAgentImpl;
import com.androboy.padchouserent.network.dataAgents.RetrofitDataAgentImpl;
import com.androboy.padchouserent.persistence.HouseDatabase;

public abstract class BaseModel {

    protected HouseDataAgent mHouseDataAgent;
    protected HouseDatabase mDatabase;

    BaseModel(Context context)
    {
        mHouseDataAgent = RetrofitDataAgentImpl.getObjInstance();
        mDatabase = HouseDatabase
                .getObjInstance(context);
    }
}
