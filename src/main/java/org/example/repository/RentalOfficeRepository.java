package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;

import java.util.ArrayList;
import java.util.List;

public class RentalOfficeRepository implements IRentalOfficeRepository{
    List<RentalOffice> rentalOffices;
    CarRepository carRepository =  new CarRepository();

    public RentalOfficeRepository() {
        rentalOffices = new ArrayList<>();
    }


    @Override
    public void add(RentalOffice rentalOffice) {

        rentalOffices.add(rentalOffice);
    }

    @Override
    public void deleteByAddress(String address) {

        if (!rentalOffices.isEmpty()){
            for (RentalOffice rentalOffice:rentalOffices) {
                System.out.println(rentalOffice);
                if (rentalOffice.getAddress().equalsIgnoreCase(address)){
                    rentalOffices.remove(rentalOffice);
                }else System.out.println("Office doesn´t exist");
            }
        }else System.out.println("There are not offices registered");

    }

    @Override
    public List<RentalOffice> findAll() {
        return rentalOffices;
    }

    //Add car to a RentalOffice
    @Override
    public void add(Car car, RentalOffice rentalOffice) {
        for (Car carElement: carRepository.findAll()) {
            if (carElement.getLicensePlate().equals(car.getLicensePlate())){
                if (!isAssigned(car)){
                    carElement.setRentalOfficeAssigned(rentalOffice);
                    rentalOffice.getCars().add(carElement);
                }else System.out.println("This car already has an Office assigned");
            }
        }

    }

    @Override
    public void delete(Car car, RentalOffice rentalOffice) {
        if (isAssigned(car)){
            rentalOffice.getCars().remove(car);
        }else System.out.println("This car is not assigned to: " + car.getRentalOfficeAssigned());
    }


    @Override
    public List<Car> findAllCars(RentalOffice rentalOffice) {
        for (Car carElement : rentalOffice.getCars()) {
            System.out.println(carElement);
        }
        return rentalOffice.getCars();
    }

    public boolean isAssigned(Car car){
        return car.getRentalOfficeAssigned() != null;
    }
}
