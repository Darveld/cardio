package com.valsoft.cardiodiary.domain.repositories.pressure;

import java.util.Date;

public interface CreatingPressureRepository {
    void createPressure(int diastolic, int systolic, int frequency, Date date, long statisticId);
}
