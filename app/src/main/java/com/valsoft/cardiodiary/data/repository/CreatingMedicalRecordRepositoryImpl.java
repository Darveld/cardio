package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.MedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.CreatingMedicalRecordDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.MedicalRecordDataStore;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.CreatingMedicalRecordRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CreatingMedicalRecordRepositoryImpl implements CreatingMedicalRecordRepository {

    private CreatingMedicalRecordDataStore mRecordDataStore;
    private CreatingMedicalDrugDataStore mDrugDataStore;

    public CreatingMedicalRecordRepositoryImpl(CreatingMedicalRecordDataStore recordDataStore, CreatingMedicalDrugDataStore drugDataStore){
        mRecordDataStore = recordDataStore;
        mDrugDataStore = drugDataStore;
    }

    @Override
    public Completable insertMedicalRecords(MedicalRecord medicalRecord, List<MedicalDrug> medicalDrugs) {
        if (medicalDrugs.size() != 0){
            return Single.fromCallable(()-> mRecordDataStore.insertRecord(medicalRecord))
                    .flatMapCompletable(aLong -> {
                        for (MedicalDrug item: medicalDrugs) {
                            item.setMedicalRecordId(aLong.intValue());
                        }
                        return Completable.fromAction(() -> mDrugDataStore.insertDrugs(medicalDrugs));
                    });

        }
        return Completable.fromAction(() -> mRecordDataStore.insertRecord(medicalRecord));
    }


}
