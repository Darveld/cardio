package com.valsoft.cardiodiary.di;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    public static final String DATABASE_NAME = "cardio_database";
    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Provides
    public Context provideAppContext(){
        return mContext;
    }

    @Provides
    @Singleton
    public CardioDataBase provideDataBase(Context context){
        return Room.databaseBuilder(context, CardioDataBase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();
    }
}
