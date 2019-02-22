package com.valsoft.cardiodiary.data.repository.datastore.medicaldrug;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

public interface CreatingMedicalDrugDataStore {

    void insertDrug(MedicalDrug medicalDrug);

    void insertDrugs(List<MedicalDrug> medicalDrugs);
}
