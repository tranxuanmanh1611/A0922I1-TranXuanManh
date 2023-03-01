package controllers;


import services.Impl.CustomerServiceImpl;
import services.Impl.EmployeeServiceImpl;
import services.Impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaControllers {
    public static void displayMainMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management\n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. Exit");
            choice = scanner.nextInt();
            if (choice == 1) {
                do {
                    System.out.println("Employee Management\n" + "1 Display list employees\n" +
                            "2 Add new employee\n" +
                            "3 Edit employee\n" +
                            "4 Return main menu");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        employeeService.displayList();
                    } else if (choice == 2) {
                        employeeService.add();
                    } else if (choice == 3) {
                        employeeService.edit();
                    }
                } while (choice != 4);

            } else if (choice == 2) {
                do {
                    System.out.println("Customer Management\n" + "1. Display list customers\n" +
                            "2. Add new customer\n" +
                            "3. Edit customer\n" +
                            "4. Return main menu");
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        customerService.displayList();
                    } else if (choice == 2) {
                        customerService.add();
                    } else if (choice == 3) {
                        customerService.edit();
                    }
                } while (choice != 4);
            } else if (choice == 3) {
                do {
                    System.out.println("Facility Management\n" + "1 Display list facility\n" +
                            "2 Add new facility\n" +
                            "3 Display list facility maintenance\n" +
                            "4 Return main menu");
                    choice = scanner.nextInt();
                    if (choice == 2) {
                        facilityService.add();
                    } else if (choice == 1) {
                        facilityService.displayList();
                    }
                } while (choice != 4);

            } else if (choice == 4) {
                do {
                    System.out.println("Booking Management\n" + "1. Add new booking\n" +
                            "2. Display list booking\n" +
                            "3. Create new constracts\n" +
                            "4. Display list contracts\n" +
                            "5. Edit contracts\n" +
                            "6. Return main menu");
                    choice = scanner.nextInt();
                } while (choice != 6);
            } else if (choice == 5) {
                do {
                    System.out.println("Promotion Management\n" + "1. Display list customers use service\n" +
                            "2. Display list customers get voucher\n" +
                            "3. Return main menu");
                    choice = scanner.nextInt();
                } while (choice != 3);
            }
        } while (choice != 6);
    }

}
