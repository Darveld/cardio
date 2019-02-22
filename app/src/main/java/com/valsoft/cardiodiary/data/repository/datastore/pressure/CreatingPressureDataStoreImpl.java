package com.valsoft.cardiodiary.data.repository.datastore.pressure;

import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Pressure;

public class CreatingPressureDataStoreImpl implements CreatingPressureDataStore {

    private PressureLocalSource mPressureLocalSource;

    public CreatingPressureDataStoreImpl(PressureLocalSource pressureLocalSource){
        mPressureLocalSource = pressureLocalSource;
    }

    @Override
    public void createPressure(Pressure pressure) {
        mPressureLocalSource.insertItem(pressure);
    }
}
