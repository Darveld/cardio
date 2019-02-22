package com.valsoft.cardiodiary.data.local.datasource.medicaldrug;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface MedicalDrugLocalSource {

    Flowable<List<MedicalDrug>> getAllDrugs();

    Maybe<List<MedicalDrug>> getDrugsByKey(long key);

    Single<MedicalDrug> getDrugById(long id);

    void insertDrug(MedicalDrug medicalDrug);

    void insertDrugs(List<MedicalDrug> medicalDrugs);

    void deleteAllDrugs();

    void deleteDrug(MedicalDrug medicalDrug);

}
