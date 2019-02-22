package com.valsoft.cardiodiary.domain.usecase;

import java.util.Date;

import io.reactivex.Completable;

public interface CreatePressureUseCase {

    Completable createPressure(int diastolic, int systolic, int frequency, Date date);
}
