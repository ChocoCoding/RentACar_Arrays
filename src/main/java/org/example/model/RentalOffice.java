package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class RentalOffice {
    private String address;
    private Integer feeForDelivery;
    private List<Car> cars;

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public RentalOffice(String address, Integer feeForDelivery){
        this.address = address;
        this.feeForDelivery = feeForDelivery;
        this.cars = new ArrayList<>();
    }

    public RentalOffice(Integer feeForDelivery){
        this.feeForDelivery = feeForDelivery;
    }

    public List<Car> getCars() {
        return cars;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        sb.append("Address: ").append(address).append("\t");
        sb.append("Fee for delivery: ").append(feeForDelivery).append("\n");
        return sb.toString();
    }
}
