package com.valsoft.cardiodiary.data.local.datasource.reminding;


import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.model.RemindingWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface RemindingLocalSource {

    Flowable<List<Reminding>> getAllReminding();

    Maybe<List<Reminding>> getRemindingByDate(Date date);

    Single<Reminding> getRemindingById(long id);

    Single<RemindingWithDrugs> getRemindingWithDrugs(long id);

    long insertReminding(Reminding reminding);

    void deleteAllReminding();

    void deleteReminding(Reminding reminding);

}
