package com.androboy.padchouserent.data.models;

import com.androboy.padchouserent.network.dataAgents.HouseDataAgent;
import com.androboy.padchouserent.network.dataAgents.HttpUrlHouseDataAgentImpl;

public abstract class BaseModel {

    protected HouseDataAgent mHouseDataAgent;

    BaseModel()
    {
        mHouseDataAgent = HttpUrlHouseDataAgentImpl.getObjectInstance();
    }
}
