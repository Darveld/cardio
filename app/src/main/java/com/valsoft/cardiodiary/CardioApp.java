package com.valsoft.cardiodiary;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import com.valsoft.cardiodiary.di.AppComponent;
import com.valsoft.cardiodiary.di.AppModule;
import com.valsoft.cardiodiary.di.DaggerAppComponent;
import com.valsoft.cardiodiary.presentation.ui.quality.QualityService;


public class CardioApp extends Application {

    private static CardioApp myApp;
    private ComponentStorage mComponentStorage;
    private AppComponent graph;
    private SharedPreferences sPref;

    public static CardioApp getInstance(){
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        graph = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        mComponentStorage = new ComponentStorage(graph);
        sPref = getSharedPreferences("Cardio", MODE_PRIVATE);
//        Intent intent = new Intent(this, QualityService.class);
//        if (Build.VERSION.SDK_INT>= 26){
//            startForegroundService(intent);
//        }else {
//            startService(intent);
//        }
    }

    public SharedPreferences getPref(){
        return sPref;
    }

    public ComponentStorage getComponentStorage() {
        return mComponentStorage;
    }
}
