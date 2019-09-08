package com.androboy.padchouserent.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.androboy.padchouserent.data.vos.HouseVO;

import java.util.List;

@Dao
public abstract class HouseDAO {

    @Query("SELECT * FROM house")
    public abstract List<HouseVO> getAllHouses();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertHouse(List<HouseVO> houses);

}
