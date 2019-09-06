package com.androboy.padchouserent.data.vos;

import com.google.gson.annotations.SerializedName;

public class HouseVO {

    @SerializedName("id")
    private int id;

    @SerializedName("house_image_url")
    private String imageUrl;

    @SerializedName("name")
    private String houseName;

    @SerializedName("description")
    private String housedescription;

    @SerializedName("price")
    private long housePrice;

    @SerializedName("address")
    private String houseAddress;

    @SerializedName("square_feet")
    private int houseWidth;

    @SerializedName("latitude")
    private  String houseLatitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHousedescription() {
        return housedescription;
    }

    public void setHousedescription(String housedescription) {
        this.housedescription = housedescription;
    }

    public long getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public int getHouseWidth() {
        return houseWidth;
    }

    public void setHouseWidth(int houseWidth) {
        this.houseWidth = houseWidth;
    }

    public String getHouseLatitude() {
        return houseLatitude;
    }

    public void setHouseLatitude(String houseLatitude) {
        this.houseLatitude = houseLatitude;
    }

    public String getHouseLongitude() {
        return houseLongitude;
    }

    public void setHouseLongitude(String houseLongitude) {
        this.houseLongitude = houseLongitude;
    }

    @SerializedName("longitude")
    private String houseLongitude;


}
