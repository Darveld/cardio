package com.valsoft.cardiodiary.data.repository.datastore.quality;

import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;

public class CreatingQualityDataStoreImpl implements CreatingQualityDataStore {

    private QualityOfLifeLocalSource mLocalSource;

    public CreatingQualityDataStoreImpl(QualityOfLifeLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public void creatingQuality(QualityOfLife qualityOfLife) {
        mLocalSource.insertItem(qualityOfLife);
    }
}
