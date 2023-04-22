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
            //Comprobamos si la matricula existe en el array de coches
            if (findByLicensePlate(car.getLicensePlate()) == null){
                car.setId(nextIdAvailable());
                cars.add(car);
            }else System.out.println("La matricula " + car.getLicensePlate() + " ya está registrada");
    }


    @Override
    public void deleteById(Long id) {
        if (findById(id).getId().equals(id)){
            cars.remove(findById(id));
        }
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
                    }else System.out.println("No se ha podido encontrar la id: " + id);
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
        findById(car.getId()).setLicensePlate(car.getLicensePlate());
        findById(car.getId()).setRentalOffice(car.getRentalOffice());
    }
    }
}
