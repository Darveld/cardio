package com.valsoft.cardiodiary.data.repository.datastore.reminding;

import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.model.RemindingWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class RemindingDataStoreImpl implements RemindingDataStore {

    private RemindingLocalSource mLocalSource;

    public RemindingDataStoreImpl(RemindingLocalSource localSource) {
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<Reminding>> getAllReminding() {
        return mLocalSource.getAllReminding();
    }

    @Override
    public Maybe<List<Reminding>> getRemindingByDate(Date date) {
        return mLocalSource.getRemindingByDate(date);
    }

    @Override
    public Single<Reminding> getRemindingById(long id) {
        return mLocalSource.getRemindingById(id);
    }

    @Override
    public Single<RemindingWithDrugs> getRemindingWithDrugs(long id) {
        return mLocalSource.getRemindingWithDrugs(id);
    }
}
