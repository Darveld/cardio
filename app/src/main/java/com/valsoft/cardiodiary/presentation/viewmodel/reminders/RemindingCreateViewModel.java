package com.valsoft.cardiodiary.presentation.viewmodel.reminders;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.domain.repositories.reminding.CreatingRemindingRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemindingCreateViewModel extends ViewModel {

    @Inject
    CreatingRemindingRepository mRepository;

    private ObservableField<String> title = new ObservableField<>();
    private ObservableField<String> description = new ObservableField<>();
    private ObservableField<String> typeOfReminding = new ObservableField<>();
    private ObservableBoolean drugReminding = new ObservableBoolean();
    private ObservableBoolean visibility = new ObservableBoolean();
    private Date startDate, endDate;
    private MutableLiveData<Boolean> liveData = new MutableLiveData<>();

    public RemindingCreateViewModel() {
        CardioApp.getInstance().getComponentStorage().addCreateRemindingComponent().inject(this);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ObservableBoolean getVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility.set(visibility);
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public ObservableField<String> getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public ObservableField<String> getTypeOfReminding() {
        return typeOfReminding;
    }

    public void setTypeOfReminding(String typeOfReminding, boolean drugReminding, boolean visibility) {
        this.typeOfReminding.set(typeOfReminding);
        this.drugReminding.set(drugReminding);
        this.visibility.set(visibility);
    }

    public ObservableBoolean getDrugReminding() {
        return drugReminding;
    }

    public void setDrugReminding(boolean drugReminding) {
        this.drugReminding.set(drugReminding);
    }

    public void saveData(List<MedicalDrug> list){
        Reminding reminding = new Reminding();
        reminding.setTitle(title.get());
        reminding.setDescription(description.get());
        reminding.setTypeOfReminding(typeOfReminding.get());
        reminding.setFirstDate(startDate);
        reminding.setSecondaryDate(endDate);
        List<MedicalDrug> drugs = new ArrayList<>();
        if (drugReminding.get()){
            drugs.addAll(list);
        }
        mRepository.insertReminding(reminding, drugs)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onComplete() {
                        liveData.setValue(true);
                        Log.d("Request status ", "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Request status ", e.toString());
                    }
                });
    }

    @Override
    protected void onCleared() {
        CardioApp.getInstance().getComponentStorage().clearCreateRemindingComponent();
        super.onCleared();
    }

    public LiveData<Boolean> getLiveData() {
        return liveData;
    }

}
