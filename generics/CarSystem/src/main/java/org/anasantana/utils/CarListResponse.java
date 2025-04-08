package org.anasantana.utils;

import org.anasantana.model.Car;

import java.util.List;

public class CarListResponse {
    private final List<Car> cars;
    private final String emptyMessage;

    public CarListResponse(List<Car> cars, String emptyMessage) {
        this.cars = cars;
        this.emptyMessage = emptyMessage;
    }

    public boolean isEmpty() {
        return cars == null || cars.isEmpty();
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getMessage(String successMessage) {
        return isEmpty() ? emptyMessage : successMessage;
    }
}
