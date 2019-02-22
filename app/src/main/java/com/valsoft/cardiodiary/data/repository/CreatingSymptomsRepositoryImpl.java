package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.CreatingSymptomsDataStore;
import com.valsoft.cardiodiary.domain.repositories.symptom.CreatingSymptomsRepository;

public class CreatingSymptomsRepositoryImpl implements CreatingSymptomsRepository {

    private CreatingSymptomsDataStore mDataStore;

    public CreatingSymptomsRepositoryImpl(CreatingSymptomsDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public void createSymptoms(Symptoms symptoms) {
        mDataStore.createSymptoms(symptoms);
    }
}
