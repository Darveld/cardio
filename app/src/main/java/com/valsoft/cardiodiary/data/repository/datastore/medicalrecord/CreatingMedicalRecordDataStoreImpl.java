package com.valsoft.cardiodiary.data.repository.datastore.medicalrecord;

import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;

public class CreatingMedicalRecordDataStoreImpl implements CreatingMedicalRecordDataStore{

    private MedicalRecordLocalSource mLocalSource;

    public CreatingMedicalRecordDataStoreImpl(MedicalRecordLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public long insertRecord(MedicalRecord medicalRecord) {
        return mLocalSource.insertRecord(medicalRecord);
    }
}
