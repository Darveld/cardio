package com.valsoft.cardiodiary.presentation.viewmodel.reminders;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.domain.repositories.reminding.RemindingRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemindingFormViewModel extends ViewModel {

    @Inject
    RemindingRepository mRepository;

    private MutableLiveData<Reminding> remindingLiveData = new MutableLiveData<>();
    private MutableLiveData<List<MedicalDrug>> drugLiveData = new MutableLiveData<>();
    private Disposable mDisposable;

    public RemindingFormViewModel() {
        CardioApp.getInstance().getComponentStorage().addGetRemindingComponent().inject(this);
    }

    public void getReminding(long id, String type){
        if (type.equals("Прийом ліків") ){
           mDisposable = mRepository.getRemindingWithDrugs(id)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(remindingWithDrugs -> {
                        remindingLiveData.setValue(remindingWithDrugs.getReminding());
                        drugLiveData.setValue(remindingWithDrugs.getDrugList());
                   });
        }else {
            mDisposable = mRepository.getRemindingById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(reminding -> remindingLiveData.setValue(reminding));
        }
    }

    public LiveData<Reminding> getRemindingLiveData(){
        return remindingLiveData;
    }

    public LiveData<List<MedicalDrug>> getDrugsLiveData(){
        return drugLiveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        super.onCleared();
    }
}
