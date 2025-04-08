package org.anasantana.factories;

import org.anasantana.factories.exceptions.UnknownCarTypeException;
import org.anasantana.model.Car;

import org.anasantana.model.Ford;
import org.anasantana.model.Honda;
import org.anasantana.model.Toyota;
import org.anasantana.model.enums.CarState;

public class CarFactory {

    public static Car createCar(
            String type,
            String id,
            String brand,
            String model,
            String plate,
            String chassis,
            Integer year,
            CarState state,
            boolean specificFeature // cada tipo interpreta isso de forma diferente
    ) {
        return switch (type.toLowerCase()) {
            case "honda" -> new Honda(id, brand, model, plate, chassis, year, state, specificFeature);
            case "ford"  -> new Ford(id, brand, model, plate, chassis, year, state, specificFeature);
            case "toyota" -> new Toyota(id, brand, model, plate, chassis, year, state, specificFeature);
            default -> throw new UnknownCarTypeException("Car type not recognized: " + type);
        };
    }
}
