package com.valsoft.cardiodiary.di;


import android.content.Context;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    Context context();
    CardioDataBase cardioDataBase();

}
