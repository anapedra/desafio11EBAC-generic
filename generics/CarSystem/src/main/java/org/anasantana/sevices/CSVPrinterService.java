package org.anasantana.sevices;

import org.anasantana.model.Car;

import java.util.Map;

public class CSVPrinterService {

    public static void printCars(Map<String, Car> cars) {
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-17s | %-4s | %-6s | %-6s%n",
                "ID", "Marca", "Modelo", "Placa", "Chassi", "Ano", "Estado", "Tipo");

        System.out.println("-------------------------------------------------------------------------------------------");

        for (Car car : cars.values()) {
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-17s | %-4d | %-6s | %-6s%n",
                    car.getId(), car.getBrand(), car.getModel(), car.getPlate(),
                    car.getChassis(), car.getYear(), car.getState(), car.getCarType());
        }
    }
}
