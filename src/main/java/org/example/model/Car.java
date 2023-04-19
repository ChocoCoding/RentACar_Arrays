package org.example.model;

public class Car {
    private Long id;
    private String licensePlate;
    private RentalOffice rentalOfficeAssigned;


//TODO añadir rentalOffice a todos los constructores
// TODO Cada vez que se cree un coche, se tiene que añadir al array

    public Car(Long id, String licensePlate) {
        this.id = id;
        this.licensePlate = licensePlate;
    }

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Car(Long id){
        this.id = id;
    }

    public RentalOffice getRentalOfficeAssigned() {
        return rentalOfficeAssigned;
    }

    public void setRentalOfficeAssigned(RentalOffice rentalOfficeAssigned) {
        this.rentalOfficeAssigned = rentalOfficeAssigned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ID Car: ").append(id).append("\t");
        sb.append("License Plate: ").append(licensePlate).append("\n");
        return sb.toString();
    }
}
