package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.CreatingRemindingDataStore;
import com.valsoft.cardiodiary.domain.repositories.reminding.CreatingRemindingRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CreatingRemindingRepositoryImpl implements CreatingRemindingRepository {

    private CreatingRemindingDataStore mRemindingDataStore;
    private CreatingMedicalDrugDataStore mDrugDataStore;

    public CreatingRemindingRepositoryImpl(CreatingRemindingDataStore remindingDataStore, CreatingMedicalDrugDataStore drugDataStore) {
        mRemindingDataStore = remindingDataStore;
        mDrugDataStore = drugDataStore;
    }

    @Override
    public Completable insertReminding(Reminding reminding, List<MedicalDrug> list) {
        if (list.size() != 0){
            return Single.fromCallable(() -> mRemindingDataStore.insertReminding(reminding))
                    .flatMapCompletable(aLong -> {
                        for (MedicalDrug item: list) {
                            item.setRemindingId(aLong.intValue());
                        }
                       return Completable.fromAction(() -> mDrugDataStore.insertDrugs(list));
                    });
        }

        return Completable.fromAction(() -> mRemindingDataStore.insertReminding(reminding));
    }
}
