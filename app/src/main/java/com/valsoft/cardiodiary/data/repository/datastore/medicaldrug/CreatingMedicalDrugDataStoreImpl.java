package com.valsoft.cardiodiary.data.repository.datastore.medicaldrug;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

public class CreatingMedicalDrugDataStoreImpl implements CreatingMedicalDrugDataStore {

    private MedicalDrugLocalSource mLocalSource;

    public CreatingMedicalDrugDataStoreImpl(MedicalDrugLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public void insertDrug(MedicalDrug medicalDrug) {
        mLocalSource.insertDrug(medicalDrug);
    }

    @Override
    public void insertDrugs(List<MedicalDrug> medicalDrugs) {
        mLocalSource.insertDrugs(medicalDrugs);
    }
}
