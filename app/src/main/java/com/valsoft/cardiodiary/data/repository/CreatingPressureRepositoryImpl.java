package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.CreatingPressureDataStore;
import com.valsoft.cardiodiary.domain.repositories.pressure.CreatingPressureRepository;

import java.util.Date;

public class CreatingPressureRepositoryImpl implements CreatingPressureRepository {

    private CreatingPressureDataStore dataStore;

    public CreatingPressureRepositoryImpl(CreatingPressureDataStore dataStore){
        this.dataStore = dataStore;
    }

    @Override
    public void createPressure(int diastolic, int systolic, int frequency, Date date, long statisticId) {
        Pressure pressure = new Pressure(diastolic, systolic, frequency, date, statisticId);
        dataStore.createPressure(pressure);
    }
}
