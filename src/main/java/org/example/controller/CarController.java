package org.example.controller;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.example.service.CarServiceImpl;
import org.example.service.ICarService;
import java.util.List;

public class CarController {

    private ICarService service;
    public CarController() {
        service = new CarServiceImpl();
    }

    public void add(String licensePlate, RentalOffice rentalOffice){
        service.add(Car.newCar(licensePlate,rentalOffice));
    }

    public void deleteById(Long id){
        service.deleteById(id);
    }

    public List<Car> findAll(){
        return service.findAll();
    }

    public Car findByLicensePlate(String licensePlate){
        return service.findByLicensePlate(licensePlate);
    }

    public void update(Long id, String licensePlate, RentalOffice rentalOffice){
        Car car = new Car(id, licensePlate, rentalOffice);
        service.update(car);
    }
}
