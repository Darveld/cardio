package com.valsoft.cardiodiary.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;

import java.util.List;

public class MedicalRecordWithDrugs {

    @Embedded
    private MedicalRecord mMedicalRecord;

    @Relation(parentColumn = "id", entityColumn = "medical_record_id")
    private List<MedicalDrug> mDrugList;

    public MedicalRecord getMedicalRecord() {
        return mMedicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        mMedicalRecord = medicalRecord;
    }

    public List<MedicalDrug> getDrugList() {
        return mDrugList;
    }

    public void setDrugList(List<MedicalDrug> drugList) {
        mDrugList = drugList;
    }
}
