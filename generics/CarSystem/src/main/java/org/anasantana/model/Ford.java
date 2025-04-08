package org.anasantana.model;

import org.anasantana.model.enums.CarState;


public class Ford extends Car {
    private boolean offRoadControl;

    public Ford() {
        super();
    }

    public Ford(boolean offRoadControl) {
        super();
        this.offRoadControl = offRoadControl;
    }

    public Ford(String id, String brand, String model, String plate, String chassis,
                Integer year, CarState state, boolean offRoadControl) {
        super(id, brand, model, plate, chassis, year, state);
        this.offRoadControl = offRoadControl;
    }



    public boolean hasOffRoadControl() {
        return offRoadControl;
    }

    public void setOffRoadControl(boolean offRoadControl) {
        this.offRoadControl = offRoadControl;
    }

    @Override
    public String getCarType() {
        return "Ford";
    }

    @Override
    public String toString() {
        return "Ford{" +
                "offRoadControl=" + offRoadControl +
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
