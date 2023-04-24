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
    }

    @Test
    void add() {
        Car car1 = Car.newCar("ABBA",rentalOffice1);
        carRepository.add(car1);
        carRepository.add(car1);

        for (Car car: carRepository.findAll()) {
            System.out.println(car);
        }
        Assertions.assertEquals(1, carRepository.findAll().size());
        Assertions.assertEquals(1,car1.getRentalOffice().getCars().size());

    }


    @Test
    void deleteById() {
        Car car2 = Car.newCar("BCCB",rentalOffice1);
        Car car3 = Car.newCar("CDDC",rentalOffice1);

        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.deleteById(1L);
        Assertions.assertEquals(1, carRepository.findAll().size());
        Assertions.assertEquals(1,car2.getRentalOffice().getCars().size());
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