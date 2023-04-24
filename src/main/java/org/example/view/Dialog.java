package org.example.view;

import org.example.controller.CarController;
import org.example.controller.ClientController;
import org.example.controller.RentalOfficeController;
import org.example.model.RentalOffice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {

    private ClientController clientController;
    private CarController carController;
    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;
    public Dialog() {
        clientController = new ClientController();
        carController = new CarController();
        rentalOfficeController = new RentalOfficeController();
    }


    public void getStarted(){
        do {
            System.out.println("\n********************** Welcome to Rent A Car *****************************");
            System.out.println("\n\t1. Manage Clients.\t\t\t\t\t4. Manage Models.");
            System.out.println("\n\t2. Manage Cars.\t\t\t\t\t\t5. Manage Rents.");
            System.out.println("\n\t3. Manage Offices.\t\t\t\t\t0. Exit.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    clientManager();
                } else if (choice == 2) {
                    carManager();
                } else if (choice == 3) {
                    rentalOfficeManager();
                } else if (choice == 4) {
                    //TODO
                } else if (choice == 5) {
                    //TODO
                }else if(choice==0) {
                    System.out.println("Bye!!");
                    System.exit(0);
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (
            InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    private void rentalOfficeManager() {
        do {
            System.out.println("\n************************** Client Manager ********************************");
            System.out.println("\n\t1. Add Rental Office.\t\t\t\t4. Listar oficinas.");
            System.out.println("\n\t2. Remove Rental Office.\t\t\t5. Listar coches en una oficina.");
            System.out.println("\n\t3. Update Rental Office.\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Rental Office Address: ");
                    String address = scanner.nextLine();
                    System.out.println("Fee for delivery: ");
                    Integer feeForDelivery = scanner.nextInt();
                    RentalOffice rentalOffice = new RentalOffice(address,feeForDelivery);
                    rentalOfficeController.add(rentalOffice);
                } else if (choice == 2) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("ID of the office you want to remove: ");
                    int id = scanner.nextInt();
                    rentalOfficeController.deleteById((long)id);
                } else if (choice == 3) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("ID of the office you want to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("New Address: ");
                    String address = scanner.nextLine();
                    System.out.println("New Fee for delivery: ");
                    Integer feeForDelivery = scanner.nextInt();
                    rentalOfficeController.update((long)id,address,feeForDelivery);
                } else if (choice == 4) {
                    System.out.println(rentalOfficeController.findAll());
                } else if (choice == 5) {
                    System.out.println("ID of the office from which you want to list their cars: ");
                    int id = scanner.nextInt();
                    System.out.println(rentalOfficeController.findCars((long)id));
                } else if(choice==0) {
                    getStarted();
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

    }

    private void carManager() {
        do {
            System.out.println("\n************************** Car Manager ***********************************");
            System.out.println("\n\t1. Add car.\t\t\t\t4. Search Car.");
            System.out.println("\n\t2. Remove Car.\t\t\t5. See All Cars.");
            System.out.println("\n\t3. Update Car.\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("License plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Rental Office ID: ");
                    int id = scanner.nextInt();
                    carController.add(licensePlate,rentalOfficeController.findById((long)id));
                } else if (choice == 2) {
                    System.out.println("Car ID: ");
                    int id = scanner.nextInt();
                    carController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(carController.findAll());
                    System.out.println("Car ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("New License Plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("New Rental Office ID: ");
                    int idOffice = scanner.nextInt();
                    carController.update((long)id,licensePlate,rentalOfficeController.findById((long)idOffice));
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("License Plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println(carController.findByLicensePlate(licensePlate));
                } else if (choice == 5) {
                    System.out.println(carController.findAll());
                } else if(choice==0) {
                    getStarted();
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

    }

    public void clientManager(){
        do {
            System.out.println("\n************************** Renta Office Manager **************************");
            System.out.println("\n\t1. Create Client.\t\t\t\t4. Search Client.");
            System.out.println("\n\t2. Remove Client.\t\t\t\t5. See All Clients.");
            System.out.println("\n\t3. Update Client.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Surname: ");
                    String surname = scanner.nextLine();
                    clientController.add(dni, name, surname);
                } else if (choice == 2) {
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    clientController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(clientController.findAll());
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Surname: ");
                    String surname = scanner.nextLine();
                    clientController.update((long) id, dni, name, surname);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println(clientController.findByDni(dni));
                } else if (choice == 5) {
                    System.out.println(clientController.findAll());
                } else if(choice==0) {
                    getStarted();
            } else {
                System.err.println("[ERROR] Your option is incorrect!! Try again!!");
            }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

}
