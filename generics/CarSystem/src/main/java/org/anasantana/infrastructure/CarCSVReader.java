package org.anasantana.infrastructure;

import org.anasantana.factories.CarFactory;
import org.anasantana.model.Car;
import org.anasantana.model.enums.CarState;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CarCSVReader {

    public static Map<String, Car> readCarsFromCSV(String filePath) {
        Map<String, Car> cars = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Ignorar linhas em branco
                if (line.trim().isEmpty()) continue;

                String[] fields = Arrays.stream(line.split(","))
                                        .map(String::trim)
                                        .toArray(String[]::new);

                if (fields.length != 9) {
                    System.err.println("❌ Linha inválida (esperado 9 campos): " + line);
                    continue;
                }

                try {
                    String type = fields[0];
                    String id = fields[1];
                    String brand = fields[2];
                    String model = fields[3];
                    String plate = fields[4];
                    String chassis = fields[5];
                    Integer year = Integer.parseInt(fields[6]);
                    CarState state = CarState.valueOf(fields[7].toUpperCase());
                    boolean specificFeature = Boolean.parseBoolean(fields[8]);

                    Car car = CarFactory.createCar(type, id,brand,model, plate, chassis, year, state, specificFeature);
                    cars.put(chassis, car);

                } catch (Exception e) {
                    System.err.println("Erro ao processar linha: " + line);
                    System.err.println("Detalhes: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return cars;
    }
}
