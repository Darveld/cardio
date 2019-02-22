package com.valsoft.cardiodiary.domain.usecase.interactors;


import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;
import com.valsoft.cardiodiary.domain.model.DailyIndexesItem;
import com.valsoft.cardiodiary.domain.model.MiddleValuesOfFeelings;
import com.valsoft.cardiodiary.domain.model.PressureItem;
import com.valsoft.cardiodiary.domain.model.StatisticItem;
import com.valsoft.cardiodiary.domain.model.SymptomsItem;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticUseCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import io.reactivex.Single;

public class GetStatisticItemInteractor implements GetStatisticUseCase {

    private StatisticRepository mRepository;

    public GetStatisticItemInteractor(StatisticRepository repository){
        mRepository = repository;
    }

    @Override
    public Single<StatisticItem> getStatisticItem(long id) {
        return mRepository.getStatisticWithDiary(id)
                .map(this::mapperFromStatisticToItem);
    }

    private StatisticItem mapperFromStatisticToItem(StatisticWithDiary statisticWithDiary){
        List<PressureItem> pressureItems = new ArrayList<>();
        List<SymptomsItem> symptomsItems = new ArrayList<>();
        List<DailyIndexesItem> dailyIndexesItems = new ArrayList<>();
        for (Pressure pressure:statisticWithDiary.getPressures()) {
            int day = getDay(pressure.getDate());
            pressureItems.add(new PressureItem(pressure.getDiastolic(), pressure.getSystolic(), pressure.getFrequency(), day));
        }
        for (Symptoms symptoms:statisticWithDiary.getSymptoms()) {
            int day = getDay(symptoms.getDate());
            boolean natureOfPain = false;
            boolean edema = false;
            boolean dyspnea = false;
            if (symptoms.getNatureOfHeartPain()!= null && !symptoms.getNatureOfHeartPain().isEmpty())natureOfPain = true;
            if (symptoms.getEdema()!= null && !symptoms.getEdema().isEmpty())edema = true;
            if (symptoms.getDyspnea()!= null && !symptoms.getDyspnea().isEmpty())dyspnea = true;
            symptomsItems.add(new SymptomsItem(natureOfPain, symptoms.isHeartInterruptions(), symptoms.isPalpitation(),
                    symptoms.isHeadache(), dyspnea, symptoms.isDizziness(), symptoms.isLossOfConsciousness(), edema, day));
        }
        for (DailyIndexes dailyIndexes:statisticWithDiary.getIndexesList()){
            int day = getDay(dailyIndexes.getDate());
            dailyIndexesItems.add(new DailyIndexesItem(dailyIndexes.getFeelings(), dailyIndexes.getActivity(),
                    dailyIndexes.getMood(), dailyIndexes.getAnxiety(), dailyIndexes.getIrritation(), dailyIndexes.getConcentration(),
                    dailyIndexes.getFatigue(), dailyIndexes.getPsychoemotionalStress(), dailyIndexes.getSleep(), day));
        }
        Collections.sort(pressureItems, (pressureItem, t1) -> pressureItem.getxDay() - t1.getxDay());
        Collections.sort(symptomsItems, (symptomsItem, t1) -> symptomsItem.getxDay() - t1.getxDay());
        Collections.sort(dailyIndexesItems, ((dailyIndexesItem, t1) -> dailyIndexesItem.getxDay() - t1.getxDay()));
        return new StatisticItem(pressureItems, symptomsItems, dailyIndexesItems);
    }

    private int getDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
