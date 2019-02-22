package com.valsoft.cardiodiary.presentation.viewmodel.quality;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.domain.repositories.quality.QualityRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QualityViewModel extends ViewModel {

    @Inject
    QualityRepository mRepository;
    private Disposable mDisposable;
    private MutableLiveData<QualityOfLife> liveData = new MutableLiveData<>();

    public QualityViewModel(){
        CardioApp.getInstance().getComponentStorage().addGetQualityComponent().inject(this);
    }

    public void getQuality(long id){
        mDisposable = mRepository.getItemById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        qualityOfLife -> {
                            liveData.setValue(qualityOfLife);
                        },
                        throwable -> {
                            Log.d("Error request", throwable.getMessage());
                        }
                );
    }

    public LiveData<QualityOfLife> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        super.onCleared();
    }
}
