package org.example.service;
import org.example.model.Car;
import java.util.List;

public interface ICarService {
    void add(Car car);
    void deleteById(Long id);
    List<Car> findAll();
    Car findByLicensePlate(String licensePlate);
    void update(Car car);
    Car findById(Long id);
}
