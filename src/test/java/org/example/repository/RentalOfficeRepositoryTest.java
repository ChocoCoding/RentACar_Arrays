package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalOfficeRepositoryTest {
    RentalOfficeRepository repository ;
    @BeforeEach
    void setUp() {
        repository = new RentalOfficeRepository();
        Car car1 = new Car("ABBA");
        Car car2 = new Car("BCCB");
        repository.carRepository.add(car1);
        repository.carRepository.add(car2);
        for (Car car : repository.carRepository.findAll()) {
            System.out.println(car);
        }
        //RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",12);
        RentalOffice rentalOffice2 = new RentalOffice("Calle San Lorenzo", 10);
        //repository.add(rentalOffice1);
        repository.add(rentalOffice2);
        //repository.add(car1,rentalOffice1);
        repository.add(car2,rentalOffice2);

    }

    @Test
    void add() {
        Car car1 = new Car("ABBA");
        Car car2 = new Car("BCCB");
        RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",12);
        RentalOffice rentalOffice2 = new RentalOffice("Calle San Lorenzo", 10);
        repository.add(car1,rentalOffice1);
        repository.add(car2,rentalOffice1);
        Assertions.assertEquals(2,repository.findAllCars(rentalOffice1).size());
        Assertions.assertEquals(0,repository.findAllCars(rentalOffice2).size());
    }

    @Test
    void deleteByAddress() {
        repository.deleteByAddress("Calle San Pedro");
        Assertions.assertEquals(1,repository.findAll().size());
    }

    @Test
    void findAll() {
        Car car1 = new Car("ABBA");
        Car car2 = new Car("BCCB");
        RentalOffice rentalOffice1 = new RentalOffice("Calle San Pedro",12);
        repository.add(car1,rentalOffice1);
        Assertions.assertEquals(1,repository.findAllCars(rentalOffice1).size());
    }

    @Test
    void testAdd() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAllCars() {
    }
}