package com.valsoft.cardiodiary.presentation.viewmodel.quality;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.domain.repositories.quality.QualityRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QualityListViewModel extends ViewModel {

    @Inject
    QualityRepository mRepository;

    private MutableLiveData<List<QualityOfLife>> liveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> checkedLiveData = new MutableLiveData<>();
    private Disposable mDisposable;
    public QualityListViewModel(){
        CardioApp.getInstance().getComponentStorage().addQualityComponent();
        CardioApp.getInstance().getComponentStorage().addGetQualityComponent().inject(this);
        getItems();
    }

    private void getItems(){
        mDisposable = mRepository.getItems()
                .map(qualityOfLives -> {
                    if (qualityOfLives.size()>=2){
                        List<QualityOfLife> sortedList = new ArrayList<>(qualityOfLives);
                        Collections.sort(sortedList, ((qualityOfLife, t1) -> (int) t1.getId() - (int) qualityOfLife.getId()));
                        return sortedList;
                    }
                    return qualityOfLives;
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        qualityOfLives -> {
                            liveData.setValue(qualityOfLives);
                            Calendar calNow = Calendar.getInstance();
                            Calendar cal = Calendar.getInstance();
                            if (qualityOfLives.size()>0){
                                cal.setTime(qualityOfLives.get(0).getDate());

                                if (calNow.getTimeInMillis()>cal.getTimeInMillis()){
                                    if (calNow.get(Calendar.MONTH)>cal.get(Calendar.MONTH)&&calNow.get(Calendar.DAY_OF_MONTH)>=cal.get(Calendar.DAY_OF_MONTH)){
                                        checkedLiveData.setValue(true);
                                        Log.d("status quality", "true1");
                                    }else if (calNow.get(Calendar.MONTH)-cal.get(Calendar.MONTH)==2){
                                        checkedLiveData.setValue(true);
                                        Log.d("status quality", "true2");
                                    }else if (cal.get(Calendar.MONTH)==11 && calNow.get(Calendar.MONTH)==0 && calNow.get(Calendar.DAY_OF_MONTH)>=cal.get(Calendar.DAY_OF_MONTH)){
                                        checkedLiveData.setValue(true);
                                        Log.d("status quality", "true3");
                                    }else {
                                        checkedLiveData.setValue(false);
                                        Log.d("status quality", "false");
                                    }
                                }else {
                                    checkedLiveData.setValue(false);
                                }
                            }
                        },
                        throwable -> {
                            Log.d("Error request", throwable.getMessage());
                        }
                );
    }

    public LiveData<List<QualityOfLife>> getLiveData(){
        return liveData;
    }

    public LiveData<Boolean> getCheckedLiveData(){
        return checkedLiveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearQualityComponent();
        CardioApp.getInstance().getComponentStorage().clearGetQualityComponent();
        super.onCleared();
    }
}
