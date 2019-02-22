package com.valsoft.cardiodiary.data.repository.datastore.medicaldrug;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface MedicalDrugDataStore {

    Flowable<List<MedicalDrug>> getAllDrugs();

    Maybe<List<MedicalDrug>> getDrugsByKey(long key);

    Single<MedicalDrug> getDrugById(long id);


}
