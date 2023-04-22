package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CarRepositoryTest {
    ICarRepository carRepository;
    IRentalOfficeRepository rentalRepository;
    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        rentalRepository = new RentalOfficeRepository();
    }

    @Test
    void add() {
        RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",20);
        RentalOffice rentalOffice2 = new RentalOffice("Calle San Jurjo",10);
        rentalRepository.add(rentalOffice1);
        rentalRepository.add(rentalOffice2);
        Car car1 = new Car("ABBA",rentalOffice1);
        Car car2 = new Car("BCCB",rentalOffice1);
        Car car3 = new Car("cCCB",rentalOffice1);
        Car car4 = new Car("rqrCB",rentalOffice2);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        for (Car car: rentalOffice1.getCars()) {
            System.out.println(car);
        }
        for (Car car: rentalOffice2.getCars()) {
            System.out.println(car);
        }

        for (RentalOffice rentalOffice: rentalRepository.findAll()){
            System.out.println(rentalOffice);
        }

        Assertions.assertEquals(4, carRepository.findAll().size());
        Assertions.assertEquals(3, rentalOffice1.getCars().size());

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