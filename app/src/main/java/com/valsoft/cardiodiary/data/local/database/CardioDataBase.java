package com.valsoft.cardiodiary.data.local.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.valsoft.cardiodiary.data.local.dao.DailyIndexesDao;
import com.valsoft.cardiodiary.data.local.dao.MedicalDrugDao;
import com.valsoft.cardiodiary.data.local.dao.MedicalRecordDao;
import com.valsoft.cardiodiary.data.local.dao.PressureDao;
import com.valsoft.cardiodiary.data.local.dao.QualityOfLifeDao;
import com.valsoft.cardiodiary.data.local.dao.RemindingDao;
import com.valsoft.cardiodiary.data.local.dao.StatisticDao;
import com.valsoft.cardiodiary.data.local.dao.SymptomsDao;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

@Database(entities = {DailyIndexes.class, Pressure.class, Symptoms.class, MedicalRecord.class, MedicalDrug.class, Reminding.class, Statistic.class, QualityOfLife.class}, version = 1)
public abstract class CardioDataBase extends RoomDatabase {
    public abstract DailyIndexesDao mDailyIndexesDao();
    public abstract PressureDao mPressureDao();
    public abstract SymptomsDao mSymptomsDao();
    public abstract MedicalRecordDao mRecordDao();
    public abstract MedicalDrugDao mDrugDao();
    public abstract RemindingDao mRemindingDao();
    public abstract StatisticDao mStatisticDao();
    public abstract QualityOfLifeDao mQualityOfLifeDao();
}
