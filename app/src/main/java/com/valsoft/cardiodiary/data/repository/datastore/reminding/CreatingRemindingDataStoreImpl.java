package com.valsoft.cardiodiary.data.repository.datastore.reminding;

import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Reminding;

public class CreatingRemindingDataStoreImpl implements CreatingRemindingDataStore {

    private RemindingLocalSource mLocalSource;

    public CreatingRemindingDataStoreImpl(RemindingLocalSource localSource) {
        mLocalSource = localSource;
    }

    @Override
    public long insertReminding(Reminding reminding) {
        return mLocalSource.insertReminding(reminding);
    }
}
