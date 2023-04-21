package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {
    ICarRepository carRepository;
    RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",20);

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        Car car1 = new Car("ABBA",rentalOffice1);
        carRepository.add(car1);
    }

    @Test
    void add() {
        RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",20);
        Car car1 = new Car("ABBA",rentalOffice1);
        carRepository.add(car1);
        Assertions.assertEquals(1,carRepository.findAll().size());
        carRepository.add(car1);
        Assertions.assertEquals(1,carRepository.findAll().size());
    }

    @Test
    void addCarToOffice() {
        Assertions.assertEquals(1,rentalOffice1.getCars().size());
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