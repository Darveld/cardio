package com.valsoft.cardiodiary.data.local.datasource.reminding;

import com.valsoft.cardiodiary.data.local.dao.RemindingDao;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.model.RemindingWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class RemindingLocalSourceImpl implements RemindingLocalSource{

    private RemindingDao mDao;

    public RemindingLocalSourceImpl(RemindingDao dao) {
        mDao = dao;
    }

    @Override
    public Flowable<List<Reminding>> getAllReminding() {
        return mDao.getAllReminding();
    }

    @Override
    public Maybe<List<Reminding>> getRemindingByDate(Date date) {
        return mDao.getRemindingByDate(date);
    }

    @Override
    public Single<Reminding> getRemindingById(long id) {
        return mDao.getRemindingById(id);
    }

    @Override
    public Single<RemindingWithDrugs> getRemindingWithDrugs(long id) {
        return mDao.getRemindingWithDrugs(id);
    }

    @Override
    public long insertReminding(Reminding reminding) {
        return mDao.insertReminding(reminding);
    }

    @Override
    public void deleteAllReminding() {
        mDao.deleteAllReminding();
    }

    @Override
    public void deleteReminding(Reminding reminding) {
        mDao.deleteReminding(reminding);
    }
}
