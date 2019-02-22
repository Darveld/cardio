package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.data.repository.datastore.quality.CreatingQualityDataStore;
import com.valsoft.cardiodiary.domain.repositories.quality.CreatingQualityRepository;

public class CreatingQualityRepositoryImpl implements CreatingQualityRepository{

    private CreatingQualityDataStore mDataStore;

    public CreatingQualityRepositoryImpl(CreatingQualityDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public void creatingQuality(QualityOfLife qualityOfLife) {
        mDataStore.creatingQuality(qualityOfLife);
    }
}
