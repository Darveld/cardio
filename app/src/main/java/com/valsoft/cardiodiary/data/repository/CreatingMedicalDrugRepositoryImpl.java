package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.domain.repositories.medicaldrug.CreatingMedicalDrugRepository;

import java.util.List;

public class CreatingMedicalDrugRepositoryImpl  implements CreatingMedicalDrugRepository{

    private CreatingMedicalDrugDataStore mDataStore;

    public CreatingMedicalDrugRepositoryImpl(CreatingMedicalDrugDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public void insertDrug(MedicalDrug medicalDrug) {
        mDataStore.insertDrug(medicalDrug);
    }

    @Override
    public void insertDrugs(List<MedicalDrug> medicalDrugs) {
        mDataStore.insertDrugs(medicalDrugs);
    }
}
