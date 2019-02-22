package com.valsoft.cardiodiary.domain.usecase;

import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import io.reactivex.Completable;

public interface CreateSymptomsUseCase {

    Completable createSymptoms(Symptoms symptoms);
}
