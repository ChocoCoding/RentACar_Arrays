package org.example.service;
import org.example.model.Car;
import org.example.repository.CarRepository;
import org.example.repository.ICarRepository;

import java.util.List;

public class CarServiceImpl implements ICarService{
    private ICarRepository repository;

    public CarServiceImpl() {
        repository = new CarRepository();
    }

    @Override
    public void add(Car car) {
        repository.add(car);
    }

    @Override
    public void deleteById(Long id) {
    repository.deleteById(id);
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return repository.findByLicensePlate(licensePlate);
    }

    @Override
    public void update(Car car) {
    repository.update(car);
    }

    @Override
    public Car findById(Long id) {
        return repository.findById(id);
    }
}
