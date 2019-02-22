package com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.domain.repositories.pressure.CreatingPressureRepository;
import com.valsoft.cardiodiary.domain.usecase.CreatePressureUseCase;

import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class PressureFormViewModel extends ViewModel {

    @Inject
    CreatePressureUseCase mPressureUseCase;
    private MutableLiveData<Boolean> savingStatus = new MutableLiveData<>();

    public PressureFormViewModel() {
        CardioApp.getInstance().getComponentStorage().addCreatePressureComponent().inject(this);
    }


    public void saveData(final int diastolic, final int systolic, final int frequency, final Date date){
        mPressureUseCase.createPressure(diastolic, systolic, frequency, date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        savingStatus.setValue(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        savingStatus.setValue(false);
                        Log.d("Request error ", e.toString());
                    }
                });
    }

    public LiveData<Boolean> getLiveData(){
        return savingStatus;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        CardioApp.getInstance().getComponentStorage().clearCreatePressureComponent();
    }
}
