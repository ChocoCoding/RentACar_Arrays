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
            //Si no existe añadimos el coche al array de coches y al de la oficina¡
            if (findByLicensePlate(car.getLicensePlate()) == null){
                car.setId(nextIdAvailable());
                cars.add(car);
                addCarToOffice(car);
            }else System.out.println("La matricula " + car.getLicensePlate() + " ya está registrada");
    }

    public void addCarToOffice(Car car) {
            car.getRentalOffice().getCars().add(car);
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
                    }else return null;
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
                    }else return null;
                }
            }
            return null;
    }

    @Override
    public void update(Car car) {
    if (findById(car.getId())!= null){
        findById(car.getId()).setLicensePlate(car.getLicensePlate());
        findById(car.getId()).setRentalOffice(car.getRentalOffice());
    }
    }
}
