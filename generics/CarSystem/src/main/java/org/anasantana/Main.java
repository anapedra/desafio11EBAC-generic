package org.anasantana;

import org.anasantana.dao.CarDAO;
import org.anasantana.model.Car;
import org.anasantana.model.Ford;
import org.anasantana.model.Honda;
import org.anasantana.model.Toyota;
import org.anasantana.model.enums.CarState;
import org.anasantana.sevices.CarService;
import org.anasantana.utils.CarCSVGenerator;
import org.anasantana.utils.CarListResponse;


import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CarService service = new CarService();
        CarDAO carDAO = new CarDAO();
        CarListResponse novos = new CarListResponse(carDAO.findByState("NOVO"), " ");
        System.out.println(novos.getMessage("\n Carros NOVOS:"));
        novos.getCars().forEach(System.out::println);
        CarCSVGenerator.generateSampleCSV("cars.csv");
        String inputPath = "cars.csv";
        String outputPath = "exported_cars.csv";


        Map<String, Car> cars = service.loadCars(inputPath);
        service.printCars(cars);
        service.exportCars(cars, outputPath);


        Car c1 = new Honda("1", "Honda", "Civic", "ABC1D23", "9BWZZZ377VT004251", 2018, CarState.NOVO,true);
        Car c2 = new Ford("2", "Ford", "Focus", "DEF2E45", "9BWZZZ377VT004252", 2019, CarState.USADO,false);
        Car c3 = new Toyota("3", "Toyota", "Corolla", "GHI3F67", "9BWZZZ377VT004253", 2020, CarState.NOVO,true);
        Car c4 = new Honda("4", "Honda", "Fit", "JKL4G89", "9BWZZZ377VT004254", 2021, CarState.USADO,false);
        Car c5 = new Ford("5", "Ford", "Ka", "MNO5H01", "9BWZZZ377VT004255", 2022, CarState.NOVO,true);

        carDAO.saveAll(List.of(c1, c2, c3, c4, c5));

        System.out.println("\n Todos os carros:");
        carDAO.findAll().forEach(System.out::println);

        System.out.println("\n Buscar por ID '3':");
        carDAO.findById("3").ifPresent(System.out::println);

        System.out.println("\nBuscar por placa 'JKL4G89':");
        carDAO.findByPlate("JKL4G89").ifPresent(System.out::println);

        System.out.println("\n Buscar por chassi '9BWZZZ377VT004251':");
        carDAO.findByChassis("9BWZZZ377VT004251").ifPresent(System.out::println);

        System.out.println("\n Total de carros: " + carDAO.count());


        System.out.println("\n❓ Existe o carro de ID '2'? " + (carDAO.existsById("2") ? "Sim" : "Não"));


        System.out.println("\n Carros NOVOS:");
        carDAO.findByState("NOVO").forEach(System.out::println);


        System.out.println("\n Carros do ano 2020:");
        carDAO.findByYear(2020).forEach(System.out::println);


        System.out.println("\n Carros ordenados por ano (asc):");
        carDAO.sortByYearAsc().forEach(System.out::println);


        System.out.println("\n Carros ordenados por ano (desc):");
        carDAO.sortByYearDesc().forEach(System.out::println);


        System.out.println("\n Deletando carro com ID '4'...");
        carDAO.deleteById("4");


        System.out.println("\n Lista após deletar:");
        carDAO.findAll().forEach(System.out::println);



        System.out.println("\n Limpando tudo...");
        carDAO.deleteAll();
        System.out.println("Lista está vazia? "+(carDAO.findAll().isEmpty() ? "Sim, lista está vazia" : "Não, a lista não está vazia"));

        Car c6 = new Honda("6", "Honda", "Civic", "ABC1D23", "9BWZZZ377VT004251", 2018, CarState.NOVO,true);
        Car c7 = new Ford("7", "Ford", "Focus", "DEF2E45", "9BWZZZ377VT004252", 2019, CarState.USADO,false);
        Car c8 = new Toyota("8", "Toyota", "Corolla", "GHI3F67", "9BWZZZ377VT004253", 2020, CarState.NOVO,true);
        carDAO.saveAll(List.of(c6,c7,c8));

        System.out.println("\nAdicionando carros...\nLista está vazia? "+(carDAO.findAll().isEmpty() ? "Sim, lista está vazia" : "Não, a lista não está vazia"));


    }
}
