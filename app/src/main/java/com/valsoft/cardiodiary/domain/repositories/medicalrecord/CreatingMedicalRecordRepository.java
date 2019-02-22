package com.valsoft.cardiodiary.domain.repositories.medicalrecord;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;

import java.util.List;

import io.reactivex.Completable;

public interface CreatingMedicalRecordRepository {

    Completable insertMedicalRecords(MedicalRecord medicalRecord, List<MedicalDrug> medicalDrugs);
}
