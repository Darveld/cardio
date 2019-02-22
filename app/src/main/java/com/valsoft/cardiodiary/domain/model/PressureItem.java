package com.valsoft.cardiodiary.domain.model;

public class PressureItem {

    private int y1;

    private int y2;

    private int y3;

    private int xDay;

    public PressureItem(int y1, int y2, int y3, int xDay) {
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.xDay = xDay;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public int getxDay() {
        return xDay;
    }

    public void setxDay(int xDay) {
        this.xDay = xDay;
    }
}
