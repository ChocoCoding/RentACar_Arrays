package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;

import java.util.List;

public interface IRentalOfficeRepository {
    void add(RentalOffice rentalOffice);
    void deleteByAddress(String address);
    List<RentalOffice> findAll();
    void add(Car car, RentalOffice rentalOffice);
    void delete(Car car, RentalOffice rentalOffice);
    List<Car> findAllCars(RentalOffice rentalOffice);
}
