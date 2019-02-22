package com.valsoft.cardiodiary.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "symptoms_table", foreignKeys = @ForeignKey(entity = Statistic.class, parentColumns = "id", childColumns = "statistic_id", onDelete = CASCADE))
@TypeConverters(Converter.class)
public class Symptoms {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "statistic_id")
    private Long statisticId;

    private String natureOfHeartPain;

    private String localization;

    private String irradiation;

    private int heartPainIntensity;

    private int heartPainDuration;

    private String heartPainCondition;

    private boolean heartInterruptions;

    private int heartInterruptionFrequency;

    private boolean palpitation;

    private int palpitationFrequency;

    private boolean headache;

    private int headacheDuration;

    private String dyspnea;

    private String conditionOfDyspnea;

    private boolean dizziness;

    private int dizzinesDiastolic;

    private int dizzinesSystolic;

    private int dizzinesFrequency;

    private boolean lossOfConsciousness;

    private int consciousnessDiastolic;

    private int consciousnessSystolic;

    private int consciousnessFrequency;

    private String edema;

    private Date date;

    public Symptoms(){
    }

    public Symptoms(Builder builder){
        this.natureOfHeartPain = builder.natureOfHeartPain;
        this.localization = builder.localization;
        this.irradiation = builder.irradiation;
        this.heartPainIntensity = builder.heartPainIntensity;
        this.heartPainDuration = builder.heartPainDuration;
        this.heartPainCondition = builder.heartPainCondition;
        this.heartInterruptions = builder.heartInterruptions;
        this.heartInterruptionFrequency = builder.heartInterruptionFrequency;
        this.palpitation = builder.palpitation;
        this.palpitationFrequency = builder.palpitationFrequency;
        this.headache = builder.headache;
        this.headacheDuration = builder.headacheDuration;
        this.dyspnea = builder.dyspnea;
        this.conditionOfDyspnea = builder.conditionOfDyspnea;
        this.dizziness = builder.dizziness;
        this.dizzinesDiastolic = builder.dizzinesDiastolic;
        this.dizzinesSystolic = builder.dizzinesSystolic;
        this.dizzinesFrequency = builder.dizzinesFrequency;
        this.lossOfConsciousness = builder.lossOfConsciousness;
        this.consciousnessDiastolic = builder.consciousnessDiastolic;
        this.consciousnessSystolic = builder.consciousnessSystolic;
        this.consciousnessFrequency = builder.consciousnessFrequency;
        this.edema = builder.edema;
        this.date = builder.date;
    }

    public Long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Long statisticId) {
        this.statisticId = statisticId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNatureOfHeartPain() {
        return natureOfHeartPain;
    }

    public void setNatureOfHeartPain(String natureOfHeartPain) {
        this.natureOfHeartPain = natureOfHeartPain;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getIrradiation() {
        return irradiation;
    }

    public void setIrradiation(String irradiation) {
        this.irradiation = irradiation;
    }

    public int getHeartPainIntensity() {
        return heartPainIntensity;
    }

    public void setHeartPainIntensity(int heartPainIntensity) {
        this.heartPainIntensity = heartPainIntensity;
    }

    public int getHeartPainDuration() {
        return heartPainDuration;
    }

    public void setHeartPainDuration(int heartPainDuration) {
        this.heartPainDuration = heartPainDuration;
    }

    public String getHeartPainCondition() {
        return heartPainCondition;
    }

    public void setHeartPainCondition(String heartPainCondition) {
        this.heartPainCondition = heartPainCondition;
    }

    public boolean isHeartInterruptions() {
        return heartInterruptions;
    }

    public void setHeartInterruptions(boolean heartInterruptions) {
        this.heartInterruptions = heartInterruptions;
    }

    public int getHeartInterruptionFrequency() {
        return heartInterruptionFrequency;
    }

    public void setHeartInterruptionFrequency(int heartInterruptionFrequency) {
        this.heartInterruptionFrequency = heartInterruptionFrequency;
    }

    public boolean isPalpitation() {
        return palpitation;
    }

    public void setPalpitation(boolean palpitation) {
        this.palpitation = palpitation;
    }

    public int getPalpitationFrequency() {
        return palpitationFrequency;
    }

    public void setPalpitationFrequency(int palpitationFrequency) {
        this.palpitationFrequency = palpitationFrequency;
    }

    public boolean isHeadache() {
        return headache;
    }

    public void setHeadache(boolean headache) {
        this.headache = headache;
    }

    public int getHeadacheDuration() {
        return headacheDuration;
    }

    public void setHeadacheDuration(int headacheDuration) {
        this.headacheDuration = headacheDuration;
    }

    public String getDyspnea() {
        return dyspnea;
    }

    public void setDyspnea(String dyspnea) {
        this.dyspnea = dyspnea;
    }

    public String getConditionOfDyspnea() {
        return conditionOfDyspnea;
    }

    public void setConditionOfDyspnea(String conditionOfDyspnea) {
        this.conditionOfDyspnea = conditionOfDyspnea;
    }

    public boolean isDizziness() {
        return dizziness;
    }

    public void setDizziness(boolean dizziness) {
        this.dizziness = dizziness;
    }

    public int getDizzinesDiastolic() {
        return dizzinesDiastolic;
    }

    public void setDizzinesDiastolic(int dizzinesDiastolic) {
        this.dizzinesDiastolic = dizzinesDiastolic;
    }

    public int getDizzinesSystolic() {
        return dizzinesSystolic;
    }

    public void setDizzinesSystolic(int dizzinesSystolic) {
        this.dizzinesSystolic = dizzinesSystolic;
    }

    public int getDizzinesFrequency() {
        return dizzinesFrequency;
    }

    public void setDizzinesFrequency(int dizzinesFrequency) {
        this.dizzinesFrequency = dizzinesFrequency;
    }

    public boolean isLossOfConsciousness() {
        return lossOfConsciousness;
    }

    public void setLossOfConsciousness(boolean lossOfConsciousness) {
        this.lossOfConsciousness = lossOfConsciousness;
    }

    public int getConsciousnessDiastolic() {
        return consciousnessDiastolic;
    }

    public void setConsciousnessDiastolic(int consciousnessDiastolic) {
        this.consciousnessDiastolic = consciousnessDiastolic;
    }

    public int getConsciousnessSystolic() {
        return consciousnessSystolic;
    }

    public void setConsciousnessSystolic(int consciousnessSystolic) {
        this.consciousnessSystolic = consciousnessSystolic;
    }

    public int getConsciousnessFrequency() {
        return consciousnessFrequency;
    }

    public void setConsciousnessFrequency(int consciousnessFrequency) {
        this.consciousnessFrequency = consciousnessFrequency;
    }

    public String getEdema() {
        return edema;
    }

    public void setEdema(String edema) {
        this.edema = edema;
    }

    public static class Builder{
        private String natureOfHeartPain;
        private String localization;
        private String irradiation;
        private int heartPainIntensity;
        private int heartPainDuration;
        private String heartPainCondition;
        private boolean heartInterruptions;
        private int heartInterruptionFrequency;
        private boolean palpitation;
        private int palpitationFrequency;
        private boolean headache;
        private int headacheDuration;
        private String dyspnea;
        private String conditionOfDyspnea;
        private boolean dizziness;
        private int dizzinesDiastolic;
        private int dizzinesSystolic;
        private int dizzinesFrequency;
        private boolean lossOfConsciousness;
        private int consciousnessDiastolic;
        private int consciousnessSystolic;
        private int consciousnessFrequency;
        private String edema;
        private Date date;

        public Builder(Date date){
            this.date = date;
        }

        public Builder addNatureOfHeartPain(String natureOfHeartPain){
            this.natureOfHeartPain = natureOfHeartPain;
            return this;
        }
        public Builder addLocalization(String localization){
            this.localization = localization;
            return this;
        }
        public Builder addIrradiation(String irradiation){
            this.irradiation = irradiation;
            return this;
        }
        public Builder addHeartPainIntensity(int heartPainIntensity){
            this.heartPainIntensity = heartPainIntensity;
            return this;
        }
        public Builder addHeartPainDuration(int heartPainDuration){
            this.heartPainDuration = heartPainDuration;
            return this;
        }
        public Builder addHeartPainCondition(String heartPainCondition){
            this.heartPainCondition = heartPainCondition;
            return this;
        }
        public Builder addHeartInterruptions(boolean heartInterruptions){
            this.heartInterruptions = heartInterruptions;
            return this;
        }
        public Builder addHeartInterruptionFrequency(int heartInterruptionFrequency){
            this.heartInterruptionFrequency = heartInterruptionFrequency;
            return this;
        }
        public Builder addPalpitation(boolean palpitation){
            this.palpitation = palpitation;
            return this;
        }
        public Builder addPalpitationFrequency(int palpitationFrequency){
            this.palpitationFrequency = palpitationFrequency;
            return this;
        }
        public Builder addHeadache(boolean headache){
            this.headache = headache;
            return this;
        }
        public Builder addHeadacheDuration(int headacheDuration){
            this.headacheDuration = headacheDuration;
            return this;
        }
        public Builder addDyspnea(String dyspnea){
            this.dyspnea = dyspnea;
            return this;
        }
        public Builder addConditionOfDyspnea(String conditionOfDyspnea){
            this.conditionOfDyspnea = conditionOfDyspnea;
            return this;
        }
        public Builder addDizziness(boolean dizziness){
            this.dizziness = dizziness;
            return this;
        }
        public Builder addDizzinesDiastolic(int dizzinesDiastolic){
            this.dizzinesDiastolic = dizzinesDiastolic;
            return this;
        }
        public Builder addDizzinesSystolic(int dizzinesSystolic){
            this.dizzinesSystolic = dizzinesSystolic;
            return this;
        }
        public Builder addDizzinesFrequency(int dizzinesFrequency){
            this.dizzinesFrequency = dizzinesFrequency;
            return this;
        }
        public Builder addLossOfConsciousness(boolean lossOfConsciousness){
            this.lossOfConsciousness = lossOfConsciousness;
            return this;
        }
        public Builder addConsciousnessDiastolic(int consciousnessDiastolic){
            this.consciousnessDiastolic = consciousnessDiastolic;
            return this;
        }
        public Builder addConsciousnessSystolic(int consciousnessSystolic){
            this.consciousnessSystolic = consciousnessSystolic;
            return this;
        }
        public Builder addConsciousnessFrequency(int consciousnessFrequency){
            this.consciousnessFrequency = consciousnessFrequency;
            return this;
        }
        public Builder addEdema(String edema){
            this.edema = edema;
            return this;
        }

        public Symptoms build(){
            return new Symptoms(this);
        }

    }
}


