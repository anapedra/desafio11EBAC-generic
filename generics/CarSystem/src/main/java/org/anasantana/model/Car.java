package org.anasantana.model;

import org.anasantana.model.enums.CarState;

import java.util.Objects;

public abstract class Car {
    protected String id;
    protected String brand;
    protected String model;
    protected String plate;
    protected String chassis; // 🔑 VIN / Chassi do carro
    protected Integer year;
    protected CarState state;

    public Car() {}

    public Car(String id, String brand, String model, String plate,
               String chassis,Integer year, CarState state) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.chassis = chassis;
        this.year = year;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public CarState getState() {
        return state;
    }

    public void setState(CarState state) {
        this.state = state;
    }

    public abstract String getCarType();

    public boolean hasSpecificFeature() {
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(plate, car.plate) && Objects.equals(chassis, car.chassis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plate, chassis);
    }



}
