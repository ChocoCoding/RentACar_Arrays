package org.example.controller;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.example.service.IRentalOfficeService;
import org.example.service.RentalOfficeServiceImpl;

import java.util.List;

public class RentalOfficeController {
    private IRentalOfficeService service;

    public RentalOfficeController(){
        service = new RentalOfficeServiceImpl();
    }

    public void add(RentalOffice rentalOffice){
        service.add(rentalOffice);
    }

    public void deleteById(Long id){
        service.deleteById(id);
    }

    public void update(Long id, String address, Integer feeForDelivery){
        RentalOffice rentalOffice = new RentalOffice(id,address,feeForDelivery);
        service.update(rentalOffice);
    }

    public RentalOffice findById(Long id){
        return service.findById(id);
    }

    public List<RentalOffice> findAll(){
        return service.findAll();
    }

    public List<Car> findCars(Long id){
        return service.findCars(id);
    }
}
