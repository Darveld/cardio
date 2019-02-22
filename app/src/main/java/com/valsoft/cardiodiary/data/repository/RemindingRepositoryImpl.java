package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.model.RemindingWithDrugs;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.RemindingDataStore;
import com.valsoft.cardiodiary.domain.repositories.reminding.RemindingRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class RemindingRepositoryImpl implements RemindingRepository {

    private RemindingDataStore mDataStore;

    public RemindingRepositoryImpl(RemindingDataStore dataStore) {
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<Reminding>> getAllReminding() {
        return mDataStore.getAllReminding();
    }

    @Override
    public Maybe<List<Reminding>> getRemindingByDate(Date date) {
        return mDataStore.getRemindingByDate(date);
    }

    @Override
    public Single<Reminding> getRemindingById(long id) {
        return mDataStore.getRemindingById(id);
    }

    @Override
    public Single<RemindingWithDrugs> getRemindingWithDrugs(long id) {
        return mDataStore.getRemindingWithDrugs(id);
    }
}
