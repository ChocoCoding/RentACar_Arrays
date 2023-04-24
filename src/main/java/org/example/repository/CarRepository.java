package org.example.repository;

import org.example.model.Car;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository{
        List<Car> cars ;

        public CarRepository(){
            cars = new ArrayList<>();
        }


    @Override
    public void add(Car car) {
            if (findByLicensePlate(car.getLicensePlate()) == null){
                car.setId(nextIdAvailable());
                cars.add(car);
            }else System.out.println("The license plate " + car.getLicensePlate() + " is already registered");
    }


    @Override
    public void deleteById(Long id) {
        if (!cars.isEmpty()) {
            for (Car car : cars) {
                if (car.getId().equals(id)) {
                    cars.remove(car);
                    car.getRentalOffice().getCars().remove(car);
                    break;
                }
            }
        }else System.out.println("There are no cars added");
    }
    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Long nextIdAvailable() {
        if (!cars.isEmpty()){
            return cars.get(cars.size()-1).getId() + 1;
        }else return 1L;
    }

    @Override
    public Car findById(Long id) {
            if (!cars.isEmpty()){
                for (Car car: cars) {
                    if (car.getId().equals(id)){
                        return car;
                    }
                }
            }
        return null;
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
            if (!cars.isEmpty()){
                for (Car car: cars) {
                    if (car.getLicensePlate().equalsIgnoreCase(licensePlate)){
                        return car;
                    }
                }
            }
            return null;
    }

    @Override
    public void update(Car car) {
    if (findById(car.getId())!= null){
        Car carToUpdate = findById(car.getId());
        carToUpdate.getRentalOffice().getCars().remove(carToUpdate);
        carToUpdate.setLicensePlate(car.getLicensePlate());
        carToUpdate.setRentalOffice(car.getRentalOffice());
        carToUpdate.getRentalOffice().getCars().add(carToUpdate);

        //findById(car.getId()).setLicensePlate(car.getLicensePlate());
        //findById(car.getId()).setRentalOffice(car.getRentalOffice());
    }
    }
}
