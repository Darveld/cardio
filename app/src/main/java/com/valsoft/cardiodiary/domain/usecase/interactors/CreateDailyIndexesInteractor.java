package com.valsoft.cardiodiary.domain.usecase.interactors;

import android.util.Log;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.CreatingDailyIndexesRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateDailyIndexesUseCase;

import java.util.Calendar;
import java.util.Date;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CreateDailyIndexesInteractor implements CreateDailyIndexesUseCase {

    private CreatingDailyIndexesRepository mCreatingDailyIndexesRepository;
    private CreatingStatisticRepository mCreatingStatisticRepository;
    private StatisticRepository mStatisticRepository;

    public CreateDailyIndexesInteractor(CreatingDailyIndexesRepository dailyIndexesRepository,
                                        CreatingStatisticRepository creatingStatisticRepository,
                                        StatisticRepository statisticRepository){
        mCreatingDailyIndexesRepository = dailyIndexesRepository;
        mCreatingStatisticRepository = creatingStatisticRepository;
        mStatisticRepository = statisticRepository;

    }

    @Override
    public Completable createDailyIndexes(int feelings, int activity, int mood, int anxiety,
                                          int irritation, int concentration, int fatigue,
                                          int psychoemotionalStress, int sleep, Date date) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        return mStatisticRepository.getStatisticByDate(month, year)
                .flatMapCompletable(statistics -> {
                    if (statistics.isEmpty()){
                        Statistic statistic = new Statistic(month, year);
                        Log.d("Create Statistic", month+" "+year);
                        return Single.fromCallable(()->mCreatingStatisticRepository.insertStatistic(statistic))
                                .flatMapCompletable(aLong -> Completable.fromAction(
                                        () -> mCreatingDailyIndexesRepository.createDailyIndexes(feelings, activity, mood,
                                                anxiety, irritation, concentration, fatigue, psychoemotionalStress, sleep, date, aLong)
                                ));
                    }
                    Statistic statistic = statistics.get(0);
                    Log.d("Get Statistic", statistic.getId()+" "+month+" "+year);
                    return Completable.fromAction(
                            () -> mCreatingDailyIndexesRepository.createDailyIndexes(feelings, activity, mood,
                                    anxiety, irritation, concentration, fatigue, psychoemotionalStress, sleep, date, statistic.getId())
                    );
                });
    }
}
