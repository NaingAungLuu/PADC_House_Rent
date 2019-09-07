package com.androboy.padchouserent.data.models;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.network.dataAgents.HouseDataAgent;
import com.androboy.padchouserent.utils.HouseConstants;

import java.util.ArrayList;
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


    @Override
    public HouseVO getHouseInfo(int houseId)
    {
        return houseDataRepository.get(houseId);
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

    @Override
    public List<HouseVO> searchHouseById(String key)
    {
        List<HouseVO> houseList = new ArrayList<>();
        List<HouseVO> foundList = new ArrayList<>();

        for(HouseVO house : houseDataRepository.values())
        {
            houseList.add(house);
        }
        for(HouseVO house : houseList)
        {
            System.out.println(house.getHouseName());
            if(house.getHouseName().contains(key))
            {

                foundList.add(house);
            }
        }
        return foundList;

    }
}
