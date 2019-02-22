package com.valsoft.cardiodiary.data.repository.datastore.medicalrecord;

import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;

public interface CreatingMedicalRecordDataStore {

    long insertRecord(MedicalRecord medicalRecord);
}
