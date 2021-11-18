package com.onespace.kiosk.models.dummymodels;

public class ReservationModel {
    String reserveNum;
    String reserveExtraLarge;
    String reserveFloor;
    String reserveArea;
    String reserveDate;
    String reserveMoveInDate;
    boolean isSelected = false;

    public ReservationModel(String reserveNum, String reserveExtraLarge, String reserveFloor, String reserveArea, String reserveDate, String reserveMoveInDate) {
        this.reserveNum = reserveNum;
        this.reserveExtraLarge = reserveExtraLarge;
        this.reserveFloor = reserveFloor;
        this.reserveArea = reserveArea;
        this.reserveDate = reserveDate;
        this.reserveMoveInDate = reserveMoveInDate;
    }

    public String getReserveNum() {
        return reserveNum;
    }

    public void setReserveNum(String reserveNum) {
        this.reserveNum = reserveNum;
    }

    public String getReserveExtraLarge() {
        return reserveExtraLarge;
    }

    public void setReserveExtraLarge(String reserveExtraLarge) {
        this.reserveExtraLarge = reserveExtraLarge;
    }

    public String getReserveFloor() {
        return reserveFloor;
    }

    public void setReserveFloor(String reserveFloor) {
        this.reserveFloor = reserveFloor;
    }

    public String getReserveArea() {
        return reserveArea;
    }

    public void setReserveArea(String reserveArea) {
        this.reserveArea = reserveArea;
    }

    public String getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(String reserveDate) {
        this.reserveDate = reserveDate;
    }

    public String getReserveMoveInDate() {
        return reserveMoveInDate;
    }

    public void setReserveMoveInDate(String reserveMoveInDate) {
        this.reserveMoveInDate = reserveMoveInDate;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
