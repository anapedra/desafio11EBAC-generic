package org.anasantana.sevices;

import org.anasantana.model.Car;
import org.anasantana.infrastructure.CarCSVReader;
import org.anasantana.infrastructure.CarCSVWriter;

import java.util.Map;

public class CarService {

    public Map<String, Car> loadCars(String path) {
        return CarCSVReader.readCarsFromCSV(path);
    }

    public void printCars(Map<String, Car> cars) {
        CSVPrinterService.printCars(cars);
    }

    public void exportCars(Map<String, Car> cars, String path) {
        CarCSVWriter.writeCarsToCSV(cars, path);
    }
}
