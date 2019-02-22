package com.valsoft.cardiodiary.data.repository.datastore.medicaldrug;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MedicalDrugDataStoreImpl implements MedicalDrugDataStore{

    private MedicalDrugLocalSource mLocalSource;

    public MedicalDrugDataStoreImpl(MedicalDrugLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<MedicalDrug>> getAllDrugs() {
        return mLocalSource.getAllDrugs();
    }

    @Override
    public Maybe<List<MedicalDrug>> getDrugsByKey(long key) {
        return mLocalSource.getDrugsByKey(key);
    }

    @Override
    public Single<MedicalDrug> getDrugById(long id) {
        return mLocalSource.getDrugById(id);
    }
}
