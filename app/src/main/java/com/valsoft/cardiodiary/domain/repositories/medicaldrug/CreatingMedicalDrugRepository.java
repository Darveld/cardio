package com.valsoft.cardiodiary.domain.repositories.medicaldrug;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

public interface CreatingMedicalDrugRepository {

    void insertDrug(MedicalDrug medicalDrug);

    void insertDrugs(List<MedicalDrug> medicalDrugs);
}
