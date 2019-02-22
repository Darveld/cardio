package com.valsoft.cardiodiary.domain.usecase.interactors;

import android.util.Log;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.symptom.CreatingSymptomsRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateSymptomsUseCase;

import java.util.Calendar;

import io.reactivex.Completable;
import io.reactivex.Single;

public class CreateSymptomsInteractor implements CreateSymptomsUseCase {

    private CreatingSymptomsRepository mCreatingSymptomsRepository;
    private CreatingStatisticRepository mCreatingStatisticRepository;
    private StatisticRepository mStatisticRepository;

    public CreateSymptomsInteractor(CreatingSymptomsRepository creatingSymptomsRepository,
                                    CreatingStatisticRepository creatingStatisticRepository,
                                    StatisticRepository statisticRepository){
        mCreatingSymptomsRepository = creatingSymptomsRepository;
        mCreatingStatisticRepository = creatingStatisticRepository;
        mStatisticRepository = statisticRepository;

    }

    @Override
    public Completable createSymptoms(Symptoms symptoms) {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);
        return mStatisticRepository.getStatisticByDate(month, year)
                .flatMapCompletable(statistics -> {
                    if (statistics.isEmpty()){
                        Statistic statistic= new Statistic(month, year);
                        Log.d("Create Statistic", month+" "+year);
                        return Single.fromCallable(()-> mCreatingStatisticRepository.insertStatistic(statistic))
                                .flatMapCompletable(aLong -> {
                                    symptoms.setStatisticId(aLong);
                                    return Completable.fromAction(()->mCreatingSymptomsRepository.createSymptoms(symptoms));
                                });
                    }
                    Statistic statistic = statistics.get(0);
                    Log.d("Get Statistic", statistic.getId()+" "+month+" "+year);
                    symptoms.setStatisticId(statistic.getId());
                    return Completable.fromAction(() -> mCreatingSymptomsRepository.createSymptoms(symptoms));
                });
    }
}
