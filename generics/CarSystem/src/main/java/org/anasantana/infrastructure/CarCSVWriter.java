package org.anasantana.infrastructure;

import org.anasantana.model.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CarCSVWriter {

    public static void writeCarsToCSV(Map<String, Car> cars, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (Car car : cars.values()) {
                writer.write(String.join(",",
                        car.getCarType(),
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        car.getPlate(),
                        car.getChassis(),
                        String.valueOf(car.getYear()),
                        car.getState().name(),
                        String.valueOf(car.hasSpecificFeature())
                ));
                writer.write("\n");
            }

            System.out.println("Arquivo exportado com sucesso para: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Erro ao escrever CSV: " + e.getMessage());
        }
    }
}
