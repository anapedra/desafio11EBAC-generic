package org.anasantana.dao;

import org.anasantana.model.Car;

import java.util.*;

public class CarDAO implements GenericDAO<Car, String> {
    private final Map<String, Car> carStorage = new HashMap<>();

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(carStorage.values());
    }

    @Override
    public Optional<Car> findById(String id) {
        return Optional.ofNullable(carStorage.get(id));
    }

    @Override
    public Car save(Car car) {
        carStorage.put(car.getId(), car);
        return car;
    }

    @Override
    public List<Car> saveAll(List<Car> cars) {
        for (Car car : cars) {
            save(car);
        }
        return cars;
    }

    @Override
    public void deleteById(String id) {
        carStorage.remove(id);
    }

    @Override
    public void delete(Car car) {
        carStorage.values().removeIf(c -> c.equals(car));
    }

    @Override
    public void deleteAll() {
        carStorage.clear();
    }

    @Override
    public boolean existsById(String id) {
        return carStorage.containsKey(id);
    }

    @Override
    public long count() {
        return carStorage.size();
    }

    // 🔍 Métodos específicos para Car
    public Optional<Car> findByPlate(String plate) {
        return carStorage.values().stream()
                .filter(c -> c.getPlate().equalsIgnoreCase(plate))
                .findFirst();
    }

    public Optional<Car> findByChassis(String chassis) {
        return carStorage.values().stream()
                .filter(c -> c.getChassis().equalsIgnoreCase(chassis))
                .findFirst();
    }

    public List<Car> findByState(String state) {
        return carStorage.values().stream()
                .filter(c -> c.getState().name().equalsIgnoreCase(state))
                .toList();
    }

    public List<Car> findByYear(int year) {
        return carStorage.values().stream()
                .filter(c -> c.getYear() == year)
                .toList();
    }

    public List<Car> sortByYearAsc() {
        return carStorage.values().stream()
                .sorted(Comparator.comparingInt(Car::getYear))
                .toList();
    }

    public List<Car> sortByYearDesc() {
        return carStorage.values().stream()
                .sorted((a, b) -> b.getYear() - a.getYear())
                .toList();
    }
}
