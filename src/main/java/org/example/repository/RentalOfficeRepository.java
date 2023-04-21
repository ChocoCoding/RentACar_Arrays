package org.example.repository;

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
            //Checking if the office ID exists
           if (findByAddress(rentalOffice.getAddress()) != null){
               rentalOffice.setId(nextIdAvailable());
               //Setting id for the office and adding it to the array
               //rentalOffice.setId(nextIdAvailable());
               rentalOffices.add(rentalOffice);
        }else {
               rentalOffice.setId(nextIdAvailable());
               rentalOffices.add(rentalOffice);
           }
    }

    public RentalOffice findById(Long id){
        for (RentalOffice rentalOffice: rentalOffices) {
            if (rentalOffice.getId().equals(id)){
                return rentalOffice;
            }else return null;
        }
        return null;
    }

    @Override
    public RentalOffice findByAddress(String address) {
        for (RentalOffice rentalOffice: rentalOffices) {
            if (rentalOffice.getAddress().equals(address)){
                return rentalOffice;
            }else return null;
        }
        return null;
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
    public List<RentalOffice> findAll() {
        return rentalOffices;
    }

    @Override
    public Long nextIdAvailable() {
        if (!rentalOffices.isEmpty()){
            return rentalOffices.get(rentalOffices.size()-1).getId() + 1;
        }else return 1L;
    }


}
