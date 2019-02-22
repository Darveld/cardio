package com.valsoft.cardiodiary.data.repository.datastore.reminding;

import com.valsoft.cardiodiary.data.local.entity.Reminding;

public interface CreatingRemindingDataStore {

    long insertReminding(Reminding reminding);
}
