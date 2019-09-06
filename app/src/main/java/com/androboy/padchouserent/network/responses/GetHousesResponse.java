package com.androboy.padchouserent.network.responses;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.utils.HouseConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetHousesResponse {


    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<HouseVO> houseList;

    public boolean  isResponseOk()
    {
        return getCode() == HouseConstants.CODE_RESPONSE_OK && houseList != null ;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {

        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<HouseVO> getHouseList() {
        return houseList;
    }

    public void setEventList(List<HouseVO> eventList) {
        this.houseList = eventList;
    }
}
