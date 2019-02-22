package com.valsoft.cardiodiary.domain.repositories.quality;

import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public interface QualityRepository {

    Flowable<List<QualityOfLife>> getItems();

    Single<QualityOfLife> getItemById(long id);

    Single<List<QualityOfLife>> getItemByDate(Date date);

}
