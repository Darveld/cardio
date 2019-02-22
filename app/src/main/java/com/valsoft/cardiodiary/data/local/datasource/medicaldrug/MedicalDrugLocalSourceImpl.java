package com.valsoft.cardiodiary.data.local.datasource.medicaldrug;

import com.valsoft.cardiodiary.data.local.dao.MedicalDrugDao;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MedicalDrugLocalSourceImpl implements MedicalDrugLocalSource{

    private MedicalDrugDao mDao;

    public MedicalDrugLocalSourceImpl(MedicalDrugDao dao){
        mDao = dao;
    }


    @Override
    public Flowable<List<MedicalDrug>> getAllDrugs() {
        return mDao.getAllDrugs();
    }

    @Override
    public Maybe<List<MedicalDrug>> getDrugsByKey(long key) {
        return mDao.getDrugsByKey(key);
    }

    @Override
    public Single<MedicalDrug> getDrugById(long id) {
        return mDao.getDrugById(id);
    }

    @Override
    public void insertDrug(MedicalDrug medicalDrug) {
        mDao.insertDrug(medicalDrug);
    }

    @Override
    public void insertDrugs(List<MedicalDrug> medicalDrugs) {
        mDao.insertDrugs(medicalDrugs);
    }

    @Override
    public void deleteAllDrugs() {
        mDao.deleteAllDrugs();
    }

    @Override
    public void deleteDrug(MedicalDrug medicalDrug) {
        mDao.deleteDrug(medicalDrug);
    }
}
