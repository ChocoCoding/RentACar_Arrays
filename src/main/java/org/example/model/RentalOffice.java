package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class RentalOffice {
    private Long id;
    private String address;
    private Integer feeForDelivery;
    private List<Car> cars;

    public RentalOffice(Long id,String address, Integer feeForDelivery){
        this.id = id;
        this.address = address;
        this.feeForDelivery = feeForDelivery;
    }


    public RentalOffice(String address, Integer feeForDelivery){
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.cars = new ArrayList<>();
        this.id = nextIdAvailable();
    }


    public Long nextIdAvailable() {
        if (!cars.isEmpty()){
            return cars.get(cars.size()-1).getId() + 1;
        }else return 1L;
    }

    public RentalOffice(Integer feeForDelivery){
        this.feeForDelivery = feeForDelivery;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getFeeForDelivery() {
        return feeForDelivery;
    }

    public void setFeeForDelivery(Integer feeForDelivery) {
        this.feeForDelivery = feeForDelivery;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ID Rental Office: ").append(id).append("\t");
        sb.append("Address: ").append(address).append("\t");
        sb.append("Fee for delivery: ").append(feeForDelivery).append("\n");
        return sb.toString();
    }
}
