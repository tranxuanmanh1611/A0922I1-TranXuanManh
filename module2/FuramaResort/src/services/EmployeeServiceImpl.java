package services;


import models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    Employee newEmployee;
    static List<Employee> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
    }

    @Override
    public void add() {
        //Thu thông tin cua đối tượng employee
        newEmployee = new Employee();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên");
        int employeeId = sc.nextInt();
        System.out.println("Nhập tên nhân viên");
        String name = sc.next();
        System.out.println("Nhập ngày sinh");
        String birthday = sc.next();
        System.out.println("Nhập giới tính");
        String gender = sc.next();
        System.out.println("Nhập CCCD");
        String citizenId = sc.next();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = sc.next();
        System.out.println("Nhập email");
        String email = sc.next();
        System.out.println("Nhập trình độ học vấn");
        String education = sc.next();
        System.out.println("Nhập chức vụ");
        String position = sc.next();
        System.out.println("Nhập mức lương");
        int salary = sc.nextInt();
        newEmployee = new Employee(employeeId, name, birthday, gender, citizenId, phoneNumber, email, education, position, salary);
        employeeList.add(newEmployee);

    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Nhập ID nhân viên bạn cần sửa");
        int id = sc.nextInt();
        do {
            System.out.println("Bạn muốn sửa thông tin gì:" +
                    "1.Name" +
                    "2.Birthday" +
                    "3.Gender" +
                    "4.Citizen ID" +
                    "5.Phone number" +
                    "6.Email" +
                    "7.Education" +
                    "8.Position" +
                    "9.Salary" + "10.Exit");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Nhập tên mới:");
                String name = sc.next();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setName(name);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Nhập ngày sinh mới(dd/mm/yyyy):");
                String birthday = sc.next();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setBirthday(birthday);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Nhập giới tính mới(male/female):");
                String gender = sc.nextLine();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setGender(gender);
                    }
                }
            } else if (choice == 4) {
                System.out.println("Nhập căn cước mới:");
                String citizenId = sc.nextLine();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setCitizenId(citizenId);
                    }
                }
            } else if (choice == 5) {
                System.out.println("Nhập số điện thoại mới:");
                String phoneNumber = sc.nextLine();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setPhoneNumber(phoneNumber);
                    }
                }
            } else if (choice == 6) {
                System.out.println("Nhập email mới:");
                String mail = sc.nextLine();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setEmail(mail);
                    }
                }
            } else if (choice == 7) {
                String education = "";
                boolean check = false;

                while (!check) {
                    System.out.println("Nhập trình độ học vấn mới(intermediate|college|universityAndUpper):");
                    education = sc.nextLine();
                    if (education.equals("intermediate") || education.equals("college") || education.equals("universityAndUpper")) {
                        check = true;
                    }
                    if (!check) {
                        System.out.println("Chưa đúng định dạng, nhập lại");
                    }
                }
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setEducation(education);
                        return;
                    }
                }
            } else if (choice == 8) {
                String positon = "";
                boolean check = false;

                while (!check) {
                    System.out.println("Nhập vị trí làm việc(receptionist|staff|executive|supervisor|manager|director):");
                    positon = sc.nextLine();
                    if (positon.equals("receptionist") || positon.equals("staff") || positon.equals("executive")
                            || positon.equals("supervisor") || positon.equals("manager") || positon.equals("director")) {
                        check = true;
                    }
                    if (!check) {
                        System.out.println("Chưa đúng định dạng, nhập lại");
                    }
                }
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setPosition(positon);
                        return;
                    }
                }
            } else if (choice == 9) {
                System.out.println("Nhập mức lương mới:");
                int salary = sc.nextInt();
                for (Employee employee : employeeList) {
                    if (employee.getEmployeeId() == id) {
                        employee.setSalary(salary);
                    }
                }
            }


        } while (choice != 10);
    }

    @Override
    public void displayList() {
        if (employeeList.size()==0){
            System.out.println("Không có dữ liệu");
        }
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}
