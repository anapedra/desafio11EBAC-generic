package org.anasantana.model;

import org.anasantana.model.enums.CarState;

public class Toyota extends Car {
    private boolean hasLaneAssist;

    public Toyota() {}

    public Toyota(boolean hasLaneAssist) {
        this.hasLaneAssist = hasLaneAssist;
    }

    public Toyota(String id, String brand, String model, String plate, String chassis, Integer year, CarState state, boolean hasLaneAssist) {
        super(id, brand, model, plate, chassis, year, state);
        this.hasLaneAssist = hasLaneAssist;
    }

    public boolean hasLaneAssist() {
        return hasLaneAssist;
    }

    public void setHasLaneAssist(boolean hasLaneAssist) {
        this.hasLaneAssist = hasLaneAssist;
    }

    @Override
    public String getCarType() {
        return "Toyota";
    }

    @Override
    public String toString() {
        return "Toyota{" +
                "hasLaneAssist=" + hasLaneAssist +
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
