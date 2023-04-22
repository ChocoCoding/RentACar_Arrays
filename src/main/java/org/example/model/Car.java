package org.example.model;

public class Car {
    private Long id;
    private String licensePlate;
    private RentalOffice rentalOffice;

        public Car(Long id, String licensePlate, RentalOffice rentalOffice) {
            this.id = id;
            this.licensePlate = licensePlate;
            this.rentalOffice = rentalOffice;
        }

        private Car(String licensePlate, RentalOffice rentalOffice) {
        this.licensePlate = licensePlate;
        this.rentalOffice = rentalOffice;

    }

    public static Car newCar(String licensePlate, RentalOffice rentalOffice){
        Car car = new Car(licensePlate,rentalOffice);
        rentalOffice.getCars().add(car);
        return car;
    }


    public Car(Long id){
        this.id = id;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(RentalOffice rentalOffice) {
        this.rentalOffice = rentalOffice;
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
        sb.append("Rental Office: ").append(rentalOffice).append("\n");
        return sb.toString();
    }
}
