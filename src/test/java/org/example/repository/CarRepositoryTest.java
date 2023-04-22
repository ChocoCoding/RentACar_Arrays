package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CarRepositoryTest {
    ICarRepository carRepository;
    IRentalOfficeRepository rentalRepository;
    RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",20);
    RentalOffice rentalOffice2 = new RentalOffice("Calle San Jurjo",10);
    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        rentalRepository = new RentalOfficeRepository();
        rentalRepository.add(rentalOffice1);
        rentalRepository.add(rentalOffice2);
        Car.newCar("ABABA",rentalOffice1);
        Car.newCar("CBBC",rentalOffice1);
        Car.newCar("DFFD",rentalOffice1);
        Car.newCar("DFFD",rentalOffice2);
    }

    @Test
    void add() {
        Car car1 = Car.newCar("ABBA",rentalOffice1);
        carRepository.add(rentalOffice1.getCars().get(0));
        carRepository.add(rentalOffice1.getCars().get(1));
        carRepository.add(rentalOffice1.getCars().get(2));
        carRepository.add(rentalOffice2.getCars().get(0));
        carRepository.add(car1);



        carRepository.deleteById(1L);
        for (Car car: carRepository.findAll()) {
            System.out.println(car);
        }
        Assertions.assertEquals(3, carRepository.findAll().size());

    }

    @Test
    void addCarToOffice() {

    }

    @Test
    void deleteById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void nextIdAvailable() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByLicensePlate() {
    }

    @Test
    void update() {
    }
}