package org.example.service;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.example.repository.IRentalOfficeRepository;
import org.example.repository.RentalOfficeRepository;

import java.util.List;

public class RentalOfficeServiceImpl implements IRentalOfficeService{
    private IRentalOfficeRepository repository;

    public RentalOfficeServiceImpl(){
        repository = new RentalOfficeRepository();
    }

    @Override
    public void add(RentalOffice rentalOffice){
        repository.add(rentalOffice);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(RentalOffice rentalOffice) {
        repository.update(rentalOffice);
    }

    @Override
    public RentalOffice findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<RentalOffice> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Car> findCars(Long id) {
        return repository.findCars(id);
    }




}
