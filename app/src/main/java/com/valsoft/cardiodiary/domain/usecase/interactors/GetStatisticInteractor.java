package com.valsoft.cardiodiary.domain.usecase.interactors;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticListUseCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;

public class GetStatisticInteractor implements GetStatisticListUseCase {

    private StatisticRepository mRepository;

    public GetStatisticInteractor(StatisticRepository repository){
        mRepository = repository;
    }

    @Override
    public Flowable<List<Statistic>> getStatistic() {
        return mRepository.getAllStatistics()
                .map(unsortedList -> {
                    if (unsortedList.size()>= 2){
                        List<Statistic> sortedListByMonth = new ArrayList<>(unsortedList);
                        Collections.sort(sortedListByMonth, (statistic, t1) -> statistic.getMonth()-t1.getMonth());
                        return sortedListByMonth;
                    }
                    return unsortedList;
                })
                .map(unsortedList -> {
                    if (unsortedList.size()>=2){
                        List<Statistic> sortedListByYear = new ArrayList<>(unsortedList);
                        Collections.sort(sortedListByYear, ((statistic, t1) -> t1.getYear() - statistic.getYear()));
                        return sortedListByYear;
                    }
                    return unsortedList;
                });
    }
}
