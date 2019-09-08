package com.androboy.padchouserent.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.androboy.padchouserent.data.vos.HouseVO;
import com.androboy.padchouserent.persistence.daos.HouseDAO;
import com.androboy.padchouserent.utils.HouseConstants;

@Database(entities = {HouseVO.class} , version = 1 , exportSchema = false)
public abstract class HouseDatabase extends RoomDatabase {
        private static HouseDatabase objInstance;



        public static HouseDatabase getObjInstance(Context context)
        {
            if(objInstance == null)
            {
             objInstance =   Room.databaseBuilder(context , HouseDatabase.class , HouseConstants.HOUSE_DB)
                                    .allowMainThreadQueries()
                                    .fallbackToDestructiveMigration()
                                    .build();
            }
            return objInstance;
        }

        public abstract HouseDAO houseDAO();

        public boolean isHouseDataEmpty()
        {
            return houseDAO().getAllHouses().isEmpty();
        }

}
