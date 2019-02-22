package com.valsoft.cardiodiary.data.repository.datastore.quality;

import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface QualityDataStore {

    Flowable<List<QualityOfLife>> getItems();

    Single<QualityOfLife> getItemById(long id);

    Single<List<QualityOfLife>> getItemByDate(Date date);

}
