package com.valsoft.cardiodiary.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.Reminding;

import java.util.List;

public class RemindingWithDrugs {

    @Embedded
    private Reminding mReminding;

    @Relation(parentColumn = "id", entityColumn = "reminding_id")
    private List<MedicalDrug> mDrugList;

    public Reminding getReminding() {
        return mReminding;
    }

    public void setReminding(Reminding reminding) {
        mReminding = reminding;
    }

    public List<MedicalDrug> getDrugList() {
        return mDrugList;
    }

    public void setDrugList(List<MedicalDrug> drugList) {
        mDrugList = drugList;
    }
}
