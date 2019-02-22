package com.valsoft.cardiodiary.domain.usecase.interactors;

import android.util.Log;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.domain.repositories.pressure.CreatingPressureRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.CreatePressureUseCase;

import java.util.Calendar;
import java.util.Date;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CreatePressureInteractor implements CreatePressureUseCase {

    private CreatingPressureRepository mPressureRepository;
    private CreatingStatisticRepository mCreatingStatisticRepository;
    private StatisticRepository mStatisticRepository;

    public CreatePressureInteractor(CreatingPressureRepository creatingPressureRepository,
                                    CreatingStatisticRepository creatingStatisticRepository, StatisticRepository statisticRepository){
        mPressureRepository = creatingPressureRepository;
        mCreatingStatisticRepository = creatingStatisticRepository;
        mStatisticRepository = statisticRepository;
    }

    @Override
    public Completable createPressure(int diastolic, int systolic, int frequency, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        return mStatisticRepository.getStatisticByDate(month, year)
                .flatMapCompletable(statistics -> {
                    if (statistics.isEmpty()){
                        Statistic statistic= new Statistic(month, year);
                        Log.d("Create Statistic", month+" "+year);
                        return Single.fromCallable(() -> mCreatingStatisticRepository.insertStatistic(statistic))
                                .flatMapCompletable(aLong ->
                                        Completable.fromAction(()->mPressureRepository.createPressure(diastolic, systolic, frequency, date, aLong)));
                    }
                    Statistic statistic = statistics.get(0);
                    Log.d("Get Statistic", statistic.getId()+" "+month+" "+year);
                    return Completable.fromAction(() -> mPressureRepository.createPressure(diastolic, systolic, frequency, date, statistic.getId()));
                });
    }


}
