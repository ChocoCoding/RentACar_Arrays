package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;

import java.util.List;

public interface IRentalOfficeRepository {
    void add(RentalOffice rentalOffice);
    void deleteById(Long id);
    List<RentalOffice> findAll();
    List<Car> findCars(Long id);
    void update(RentalOffice rentalOffice);
    RentalOffice findById(Long id);

}
