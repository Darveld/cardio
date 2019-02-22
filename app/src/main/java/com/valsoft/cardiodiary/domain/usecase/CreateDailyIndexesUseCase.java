package com.valsoft.cardiodiary.domain.usecase;

import java.util.Date;

import io.reactivex.Completable;

public interface CreateDailyIndexesUseCase {

    Completable createDailyIndexes(int feelings, int activity, int mood, int anxiety, int irritation, int concentration, int fatigue, int psychoemotionalStress, int sleep, Date date);
}
