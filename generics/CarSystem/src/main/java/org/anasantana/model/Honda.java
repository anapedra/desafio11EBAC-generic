package org.anasantana.model;

import org.anasantana.model.enums.CarState;

public class Honda extends Car {
    private boolean isHybrid;

    public Honda() {}

    public Honda(boolean isHybrid) {
        this.isHybrid = isHybrid;
    }

    public Honda(String id, String brand, String model, String plate, String chassis, Integer year, CarState state, boolean isHybrid) {
        super(id, brand, model, plate, chassis, year, state);
        this.isHybrid = isHybrid;
    }

    public boolean isHybrid() { return isHybrid; }
    public void setHybrid(boolean hybrid) { isHybrid = hybrid; }

    @Override
    public String getCarType() {
        return "Honda";
    }

    @Override
    public String toString() {
        return "Honda{" +
                "isHybrid=" + isHybrid +
                ", id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", plate='" + plate + '\'' +
                ", chassis='" + chassis + '\'' +
                ", year=" + year +
                ", state=" + state +
                '}';
    }
}
