package com.valsoft.cardiodiary.data.repository.datastore.symptom;

import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

public class CreatingSymptomsDataStoreImpl implements CreatingSymptomsDataStore {

    private SymptomsLocalSource mSymptomsLocalSource;

    public CreatingSymptomsDataStoreImpl(SymptomsLocalSource symptomsLocalSource){
        mSymptomsLocalSource = symptomsLocalSource;
    }

    @Override
    public void createSymptoms(Symptoms symptoms) {
        mSymptomsLocalSource.insertItem(symptoms);
    }
}
