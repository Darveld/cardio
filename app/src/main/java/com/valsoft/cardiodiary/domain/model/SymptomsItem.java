package com.valsoft.cardiodiary.domain.model;

public class SymptomsItem {

    private boolean heartPain;

    private boolean heartInterruptions;

    private boolean palpitation;

    private boolean headache;

    private boolean dyspnea;

    private boolean dizziness;

    private boolean lossOfConsciousness;

    private boolean edema;

    private int xDay;

    public SymptomsItem(boolean heartPain, boolean heartInterruptions, boolean palpitation, boolean headache, boolean dyspnea, boolean dizziness, boolean lossOfConsciousness, boolean edema, int xDay) {
        this.heartPain = heartPain;
        this.heartInterruptions = heartInterruptions;
        this.palpitation = palpitation;
        this.headache = headache;
        this.dyspnea = dyspnea;
        this.dizziness = dizziness;
        this.lossOfConsciousness = lossOfConsciousness;
        this.edema = edema;
        this.xDay = xDay;
    }

    public boolean isDyspnea() {
        return dyspnea;
    }

    public void setDyspnea(boolean dyspnea) {
        this.dyspnea = dyspnea;
    }

    public boolean getHeartPain() {
        return heartPain;
    }

    public void setHeartPain(boolean heartPain) {
        this.heartPain = heartPain;
    }

    public boolean getHeartInterruptions() {
        return heartInterruptions;
    }

    public void setHeartInterruptions(boolean heartInterruptions) {
        this.heartInterruptions = heartInterruptions;
    }

    public boolean getPalpitation() {
        return palpitation;
    }

    public void setPalpitation(boolean palpitation) {
        this.palpitation = palpitation;
    }

    public boolean getHeadache() {
        return headache;
    }

    public void setHeadache(boolean headache) {
        this.headache = headache;
    }

    public boolean getDizziness() {
        return dizziness;
    }

    public void setDizziness(Boolean dizziness) {
        this.dizziness = dizziness;
    }

    public Boolean getLossOfConsciousness() {
        return lossOfConsciousness;
    }

    public void setLossOfConsciousness(boolean lossOfConsciousness) {
        this.lossOfConsciousness = lossOfConsciousness;
    }

    public boolean getEdema() {
        return edema;
    }

    public void setEdema(boolean edema) {
        this.edema = edema;
    }

    public int getxDay() {
        return xDay;
    }

    public void setxDay(int xDay) {
        this.xDay = xDay;
    }
}
