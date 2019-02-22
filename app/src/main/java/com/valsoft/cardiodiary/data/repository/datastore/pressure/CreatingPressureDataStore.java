package com.valsoft.cardiodiary.data.repository.datastore.pressure;

import com.valsoft.cardiodiary.data.local.entity.Pressure;

public interface CreatingPressureDataStore {
    void createPressure(Pressure pressure);
}
