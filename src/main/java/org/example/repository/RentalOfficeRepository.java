package org.example.repository;

import org.example.model.Car;
import org.example.model.RentalOffice;

import java.util.ArrayList;
import java.util.List;

public class RentalOfficeRepository implements IRentalOfficeRepository{
    List<RentalOffice> rentalOffices;

    public RentalOfficeRepository(){
        rentalOffices = new ArrayList<>();
    }

    @Override
    public void add(RentalOffice rentalOffice) {
           if (findByAddress(rentalOffice.getAddress()) != null){
               rentalOffice.setId(nextIdAvailable());
               rentalOffices.add(rentalOffice);
        }else {
               rentalOffice.setId(nextIdAvailable());
               rentalOffices.add(rentalOffice);
           }
    }

    @Override
    public void deleteById(Long id) {
        if (!rentalOffices.isEmpty()){
            if (findById(id) != null){
                rentalOffices.remove(findById(id));
            }
        }else System.out.println("The id " + id +" + isn´t assigned to any office");
    }

    @Override
    public void update(RentalOffice rentalOffice) {
        if (findById(rentalOffice.getId()) != null){
            RentalOffice rentalOfficeToUpdate = findById(rentalOffice.getId());
            rentalOfficeToUpdate.setAddress(rentalOffice.getAddress());
            rentalOfficeToUpdate.setFeeForDelivery(rentalOffice.getFeeForDelivery());
        }
    }

    @Override
    public RentalOffice findById(Long id){
            if (!rentalOffices.isEmpty()){
                for (RentalOffice rentalOffice: rentalOffices) {
                    if (rentalOffice.getId().equals(id)){
                        return rentalOffice;
                    }
                }
            }
        return null;
    }

    @Override
    public List<RentalOffice> findAll() {
        return rentalOffices;
    }

    @Override
    public List<Car> findCars(Long id) {
        if (findById(id) !=null){
            return findById(id).getCars();
        }
        return null;
    }



    public Long nextIdAvailable() {
        if (!rentalOffices.isEmpty()){
            return rentalOffices.get(rentalOffices.size()-1).getId() + 1;
        }else return 1L;
    }

    public RentalOffice findByAddress(String address) {
        if (!rentalOffices.isEmpty()){
            for (RentalOffice rentalOffice: rentalOffices) {
                if (rentalOffice.getAddress().equals(address)){
                    return rentalOffice;
                }
            }
        }
        return null;
    }

}
