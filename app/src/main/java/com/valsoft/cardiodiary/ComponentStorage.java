package com.valsoft.cardiodiary;

import com.valsoft.cardiodiary.di.AppComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.DaggerDailyControlComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.DailyControlComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.create.CreateDailyIndexesComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.create.DaggerCreateDailyIndexesComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.get.DaggerGetDailyIndexesComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.get.GetDailyIndexesComponent;
import com.valsoft.cardiodiary.di.medicaldrug.DaggerMedicalDrugComponent;
import com.valsoft.cardiodiary.di.medicaldrug.MedicalDrugComponent;
import com.valsoft.cardiodiary.di.medicaldrug.create.CreateMedicalDrugComponent;
import com.valsoft.cardiodiary.di.medicaldrug.create.DaggerCreateMedicalDrugComponent;
import com.valsoft.cardiodiary.di.medicalrecord.DaggerMedicalRecordComponent;
import com.valsoft.cardiodiary.di.medicalrecord.MedicalRecordComponent;
import com.valsoft.cardiodiary.di.medicalrecord.create.CreateMedicalRecordComponent;
import com.valsoft.cardiodiary.di.medicalrecord.create.DaggerCreateMedicalRecordComponent;
import com.valsoft.cardiodiary.di.medicalrecord.get.DaggerGetMedicalRecordComponent;
import com.valsoft.cardiodiary.di.medicalrecord.get.GetMedicalRecordComponent;
import com.valsoft.cardiodiary.di.pressurescope.DaggerPressureComponent;
import com.valsoft.cardiodiary.di.pressurescope.PressureComponent;
import com.valsoft.cardiodiary.di.pressurescope.create.CreatePressureComponent;
import com.valsoft.cardiodiary.di.pressurescope.create.DaggerCreatePressureComponent;
import com.valsoft.cardiodiary.di.pressurescope.get.DaggerGetPressureComponent;
import com.valsoft.cardiodiary.di.pressurescope.get.GetPressureComponent;
import com.valsoft.cardiodiary.di.quality.DaggerQualityComponent;
import com.valsoft.cardiodiary.di.quality.QualityComponent;
import com.valsoft.cardiodiary.di.quality.create.CreateQualityComponent;
import com.valsoft.cardiodiary.di.quality.create.DaggerCreateQualityComponent;
import com.valsoft.cardiodiary.di.quality.get.DaggerGetQualityComponent;
import com.valsoft.cardiodiary.di.quality.get.GetQualityComponent;
import com.valsoft.cardiodiary.di.reminding.DaggerRemindingComponent;
import com.valsoft.cardiodiary.di.reminding.RemindingComponent;
import com.valsoft.cardiodiary.di.reminding.create.CreateRemindingComponent;
import com.valsoft.cardiodiary.di.reminding.create.DaggerCreateRemindingComponent;
import com.valsoft.cardiodiary.di.reminding.get.DaggerGetRemindingComponent;
import com.valsoft.cardiodiary.di.reminding.get.GetRemindingComponent;
import com.valsoft.cardiodiary.di.statistic.DaggerStatisticComponent;
import com.valsoft.cardiodiary.di.statistic.StatisticComponent;
import com.valsoft.cardiodiary.di.symptomscope.DaggerSymptomComponent;
import com.valsoft.cardiodiary.di.symptomscope.SymptomComponent;
import com.valsoft.cardiodiary.di.symptomscope.create.CreateSymptomComponent;
import com.valsoft.cardiodiary.di.symptomscope.create.DaggerCreateSymptomComponent;
import com.valsoft.cardiodiary.di.symptomscope.get.DaggerGetSymptomComponent;
import com.valsoft.cardiodiary.di.symptomscope.get.GetSymptomComponent;

public class ComponentStorage {

    private AppComponent graph;
    private PressureComponent mPressureComponent;
    private CreatePressureComponent mCreatePressureComponent;
    private SymptomComponent mSymptomComponent;
    private CreateSymptomComponent mCreateSymptomComponent;
    private DailyControlComponent mDailyControlComponent;
    private CreateDailyIndexesComponent mCreateDailyIndexesComponent;
    private GetPressureComponent mGetPressureComponent;
    private GetSymptomComponent mGetSymptomComponent;
    private GetDailyIndexesComponent mGetDailyIndexesComponent;
    private MedicalRecordComponent mMedicalRecordComponent;
    private MedicalDrugComponent mMedicalDrugComponent;
    private CreateMedicalRecordComponent mCreateMedicalRecordComponent;
    private CreateMedicalDrugComponent mCreateMedicalDrugComponent;
    private GetMedicalRecordComponent mGetMedicalRecordComponent;
    private RemindingComponent mRemindingComponent;
    private CreateRemindingComponent mCreateRemindingComponent;
    private GetRemindingComponent mGetRemindingComponent;
    private StatisticComponent mStatisticComponent;
    private QualityComponent mQualityComponent;
    private CreateQualityComponent mCreateQualityComponent;
    private GetQualityComponent mGetQualityComponent;

    public ComponentStorage(AppComponent graph){
        this.graph = graph;
    }

    public PressureComponent addPressureComponent(){
        if (mPressureComponent == null){
            mPressureComponent = DaggerPressureComponent.builder().appComponent(graph).build();
            return mPressureComponent;
        }
        return mPressureComponent;
    }

    public void clearPressureComponent(){
        mPressureComponent = null;
    }

    public CreatePressureComponent addCreatePressureComponent(){
        if (mPressureComponent == null){
            return null;
        }
        if (mCreatePressureComponent == null){
            mCreatePressureComponent = DaggerCreatePressureComponent.builder().pressureComponent(mPressureComponent).build();
            return mCreatePressureComponent;
        }
        return mCreatePressureComponent;
    }

    public void clearCreatePressureComponent(){
        mCreatePressureComponent = null;
    }

    public SymptomComponent addSymptomComponent(){
        if (mSymptomComponent == null){
            mSymptomComponent = DaggerSymptomComponent.builder().appComponent(graph).build();
            return mSymptomComponent;
        }
        return mSymptomComponent;
    }

    public void clearSymptomComponent(){
        mSymptomComponent = null;
    }

    public CreateSymptomComponent addCreateSymptomComponent() {
        if (mSymptomComponent == null){
            return null;
        }
        if (mCreateSymptomComponent == null){
            mCreateSymptomComponent = DaggerCreateSymptomComponent.builder().symptomComponent(mSymptomComponent).build();
            return mCreateSymptomComponent;
        }
        return mCreateSymptomComponent;
    }

    public void clearCreateSymptomComponent(){
        mCreateSymptomComponent = null;
    }

    public DailyControlComponent addDailyControlComponent(){
        if (mDailyControlComponent == null){
            mDailyControlComponent = DaggerDailyControlComponent.builder().appComponent(graph).build();
            return mDailyControlComponent;
        }
        return mDailyControlComponent;
    }

    public void clearDailyControlComponent(){
        mDailyControlComponent = null;
    }

    public CreateDailyIndexesComponent addCreateDailyIndexesComponent() {
        if (mDailyControlComponent == null){
            return null;
        }

        if (mCreateDailyIndexesComponent == null){
            mCreateDailyIndexesComponent = DaggerCreateDailyIndexesComponent.builder().dailyControlComponent(mDailyControlComponent).build();
            return mCreateDailyIndexesComponent;
        }
        return mCreateDailyIndexesComponent;
    }

    public void clearCreateDailyIndexesComponent(){
        mCreateDailyIndexesComponent = null;
    }

    public GetPressureComponent addGetPressureComponent(){
        if (mPressureComponent == null){
            return null;
        }

        if (mGetPressureComponent == null){
            mGetPressureComponent = DaggerGetPressureComponent.builder().pressureComponent(mPressureComponent).build();
            return mGetPressureComponent;
        }
        return mGetPressureComponent;
    }

    public void cleareGetPressureComponent(){
        mGetPressureComponent = null;
    }

    public GetSymptomComponent addGetSymptomComponent(){
        if (mSymptomComponent == null){
            return null;
        }

        if (mGetSymptomComponent == null){
            mGetSymptomComponent = DaggerGetSymptomComponent.builder().symptomComponent(mSymptomComponent).build();
            return mGetSymptomComponent;
        }
        return mGetSymptomComponent;
    }


    public void clearGetSymptomComponent(){
        mGetSymptomComponent = null;
    }

    public GetDailyIndexesComponent addGetDailyIndexesComponent(){
        if (mDailyControlComponent == null){
            return null;
        }

        if (mGetDailyIndexesComponent == null){
            mGetDailyIndexesComponent = DaggerGetDailyIndexesComponent.builder().dailyControlComponent(mDailyControlComponent).build();
            return mGetDailyIndexesComponent;
        }
        return mGetDailyIndexesComponent;
    }

    public void clearGetDailyIndexesComponent(){
        mGetDailyIndexesComponent = null;
    }

    public MedicalRecordComponent addMedicalRecordComponent(){
        if (mMedicalRecordComponent == null){
            mMedicalRecordComponent = DaggerMedicalRecordComponent.builder().appComponent(graph).build();
            return mMedicalRecordComponent;
        }
        return mMedicalRecordComponent;
    }

    public void clearMedicalRecordComponent(){
        mMedicalRecordComponent = null;
    }

    public MedicalDrugComponent addMedicalDrugComponent(){
        if (mMedicalDrugComponent == null){
            mMedicalDrugComponent = DaggerMedicalDrugComponent.builder().appComponent(graph).build();
            return mMedicalDrugComponent;
        }
        return mMedicalDrugComponent;
    }

    public void clearMedicalDrugComponent(){
        mMedicalDrugComponent = null;
    }

    public CreateMedicalRecordComponent addCreateMedicalRecordComponent(){
        if (mMedicalRecordComponent == null){
            return null;
        }
        if (mCreateMedicalRecordComponent == null){
            mCreateMedicalRecordComponent = DaggerCreateMedicalRecordComponent.builder().medicalRecordComponent(mMedicalRecordComponent).build();
            return mCreateMedicalRecordComponent;
        }
        return mCreateMedicalRecordComponent;
    }

    public void clearCreateMedicalRecordComponent(){
        mCreateMedicalRecordComponent = null;
    }

    public CreateMedicalDrugComponent addCreateMedicalDrugComponent(){
        if (mMedicalDrugComponent == null){
            return null;
        }
        if (mCreateMedicalDrugComponent == null){
            mCreateMedicalDrugComponent = DaggerCreateMedicalDrugComponent.builder().medicalDrugComponent(mMedicalDrugComponent).build();
            return mCreateMedicalDrugComponent;
        }
        return mCreateMedicalDrugComponent;
    }

    public void clearCreateMedicalDrugComponent(){
        mCreateMedicalDrugComponent = null;
    }

    public GetMedicalRecordComponent addGetMedicalRecordComponent(){
        if (mMedicalRecordComponent == null){
            return null;
        }
        if (mGetMedicalRecordComponent == null){
            mGetMedicalRecordComponent = DaggerGetMedicalRecordComponent.builder().medicalRecordComponent(mMedicalRecordComponent).build();
            return mGetMedicalRecordComponent;
        }
        return mGetMedicalRecordComponent;
    }

    public void clearGetMedicalRecordComponent(){
        mGetMedicalRecordComponent = null;
    }

    public RemindingComponent addRemindingComponent(){
        if (mRemindingComponent == null){
            mRemindingComponent = DaggerRemindingComponent.builder().appComponent(graph).build();
            return mRemindingComponent;
        }
        return mRemindingComponent;
    }

    public void clearRemindingComponent(){
        mRemindingComponent = null;
    }

    public CreateRemindingComponent addCreateRemindingComponent(){
        if (mRemindingComponent == null){
            return null;
        }
        if (mCreateRemindingComponent == null){
            mCreateRemindingComponent = DaggerCreateRemindingComponent.builder().remindingComponent(mRemindingComponent).build();
            return mCreateRemindingComponent;
        }
        return mCreateRemindingComponent;
    }

    public void clearCreateRemindingComponent(){
        mCreateRemindingComponent = null;
    }

    public GetRemindingComponent addGetRemindingComponent(){
        if (mRemindingComponent == null){
            return null;
        }

        if (mGetRemindingComponent == null){
            mGetRemindingComponent = DaggerGetRemindingComponent.builder().remindingComponent(mRemindingComponent).build();
            return mGetRemindingComponent;
        }
        return mGetRemindingComponent;
    }

    public void clearGetRemindingComponent(){
        mGetRemindingComponent = null;
    }

    public StatisticComponent addStatisticComponent(){
        if (mStatisticComponent == null){
            mStatisticComponent = DaggerStatisticComponent.builder().appComponent(graph).build();
            return mStatisticComponent;
        }
        return mStatisticComponent;
    }

    public void clearStatisticComponent(){
        mStatisticComponent = null;
    }

    public QualityComponent addQualityComponent(){
        if (mQualityComponent == null){
            mQualityComponent = DaggerQualityComponent.builder().appComponent(graph).build();
            return mQualityComponent;
        }
        return mQualityComponent;
    }

    public void clearQualityComponent(){
        mQualityComponent = null;
    }

    public CreateQualityComponent addCreateQualityComponent(){
        if (mQualityComponent == null){
            return null;
        }

        if (mCreateQualityComponent == null){
            mCreateQualityComponent = DaggerCreateQualityComponent.builder().qualityComponent(mQualityComponent).build();
            return mCreateQualityComponent;
        }
        return mCreateQualityComponent;
    }

    public void clearCreateQualityComponent(){
        mCreateQualityComponent = null;
    }

    public GetQualityComponent addGetQualityComponent(){
        if (mQualityComponent == null){
            return null;
        }
        if (mGetQualityComponent == null){
            mGetQualityComponent = DaggerGetQualityComponent.builder().qualityComponent(mQualityComponent).build();
            return mGetQualityComponent;
        }
        return mGetQualityComponent;
    }

    public void clearGetQualityComponent(){
        mGetQualityComponent = null;
    }
}
