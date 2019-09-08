package com.androboy.padchouserent.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "house" , indices = {@Index(value = "id" , unique = true)})
public class HouseVO {



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "house_id_pk")
    private int houseIdPK;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "house_image_url")
    @SerializedName("house_image_url")
    private String imageUrl;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String houseName;

    @ColumnInfo(name =  "description")
    @SerializedName("description")
    private String housedescription;

    @ColumnInfo(name = "price")
    @SerializedName("price")
    private long housePrice;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String houseAddress;

    @ColumnInfo(name = "square_feet")
    @SerializedName("square_feet")
    private int houseWidth;

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    private  String houseLatitude;


    public int getHouseIdPK() {
        return houseIdPK;
    }

    public void setHouseIdPK(int houseIdPK) {
        this.houseIdPK = houseIdPK;
    }

    public void setHousePrice(long housePrice) {
        this.housePrice = housePrice;
    }


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
