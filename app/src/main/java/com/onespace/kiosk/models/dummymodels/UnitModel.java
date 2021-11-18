package com.onespace.kiosk.models.dummymodels;

public class UnitModel {
    String unitName;
    String unitFloor;
    String unitArea;
    String unitAttribute;
    boolean isSelected = false;

    public UnitModel(String unitName, String unitFloor, String unitArea, String unitAttribute) {
        this.unitName = unitName;
        this.unitFloor = unitFloor;
        this.unitArea = unitArea;
        this.unitAttribute = unitAttribute;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitFloor() {
        return unitFloor;
    }

    public void setUnitFloor(String unitFloor) {
        this.unitFloor = unitFloor;
    }

    public String getUnitArea() {
        return unitArea;
    }

    public void setUnitArea(String unitArea) {
        this.unitArea = unitArea;
    }

    public String getUnitAttribute() {
        return unitAttribute;
    }

    public void setUnitAttribute(String unitAttribute) {
        this.unitAttribute = unitAttribute;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
