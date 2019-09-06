package com.androboy.padchouserent.data.models;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.network.dataAgents.HouseDataAgent;
import com.androboy.padchouserent.utils.HouseConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseModelImpl extends BaseModel implements HouseModel {

    private static HouseModelImpl objInstance;
    private Map<Integer , HouseVO> houseDataRepository;

    private HouseModelImpl()
    {
        houseDataRepository = new HashMap<>();
    }

    public static HouseModelImpl getObjectInstance()
    {
        if(objInstance == null){
            objInstance = new HouseModelImpl();
        }

            return objInstance;
    }
    //Network Layer
    @Override
    public void getHouses(final getHousesFromDataLayerDelegate delegate) {
        mHouseDataAgent.getHouses(HouseConstants.DUMMY_ACCESS_TOKEN, new HouseDataAgent.GetHousesFromNetworkDelegate() {
            @Override
            public void onSuccess(List<HouseVO> houses) {
                for(HouseVO house : houses)
                {
                    houseDataRepository.put(house.getId() , house);
                }
                delegate.onSuccess(houses);
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        });
    }
}
