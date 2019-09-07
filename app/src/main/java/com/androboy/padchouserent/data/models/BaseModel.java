package com.androboy.padchouserent.data.models;

import com.androboy.padchouserent.network.dataAgents.HouseDataAgent;
import com.androboy.padchouserent.network.dataAgents.HttpUrlHouseDataAgentImpl;
import com.androboy.padchouserent.network.dataAgents.OkHttpDataAgentImpl;
import com.androboy.padchouserent.network.dataAgents.RetrofitDataAgentImpl;

public abstract class BaseModel {

    protected HouseDataAgent mHouseDataAgent;

    BaseModel()
    {
        mHouseDataAgent = RetrofitDataAgentImpl.getObjInstance();
    }
}
