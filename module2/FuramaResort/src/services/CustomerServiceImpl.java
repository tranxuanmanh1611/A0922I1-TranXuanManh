package services;

import models.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    Customer newCustomer;
    LinkedList<Customer> customerList;
    int customerId = 0;

    public CustomerServiceImpl() {
        customerList = new LinkedList<>();
    }

    @Override
    public void add() {
        customerId++;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        String birthday = sc.nextLine();
        System.out.println("Nhập giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập số CCCD");
        String citizenId = sc.nextLine();
        System.out.println("Nhập số điện thoại");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        System.out.println("Nhập hạng thành viên(Diamon/Platinum/Gold/Silver/Member)");
        String membership = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc.nextLine();
        newCustomer = new Customer(customerId, name, birthday, gender, citizenId, phoneNumber, email, membership, address);
        customerList.addLast(newCustomer);

    }

    @Override
    public void displayList() {
        if (customerList.isEmpty()) {
            System.out.println("Chưa có dữ liệu");
        }
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Nhập ID khách hàng bạn cần sửa");
        int id = sc.nextInt();
        do {
            System.out.println("Đã tìm thấy khách hàng: ");
            for (Customer customer:customerList){
                if (customer.getCustomerId()==id){
                    System.out.println(customer);
                }
            }
                System.out.println("Bạn muốn sửa thông tin gì:\n" +
                        "1.Name\n" +
                        "2.Birthday\n" +
                        "3.Gender\n" +
                        "4.Citizen ID\n" +
                        "5.Phone number\n" +
                        "6.Email\n" +
                        "7.Hạng thành viên\n " +
                        "8.Địa chỉ\n" + "9.Trở lại\n");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.println("Nhập tên mới:");
                    String name = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setName(name);
                        }
                    }
                } else if (choice == 2) {
                    System.out.println("Nhập ngày sinh mới(dd/mm/yyyy):");
                    String birthday = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setBirthday(birthday);
                        }
                    }
                } else if (choice == 3) {
                    System.out.println("Nhập giới tính mới(male/female):");
                    String gender = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setGender(gender);
                        }
                    }
                } else if (choice == 4) {
                    System.out.println("Nhập căn cước mới:");
                    String citizenId = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setCitizenId(citizenId);
                        }
                    }
                } else if (choice == 5) {
                    System.out.println("Nhập số điện thoại mới:");
                    String phoneNumber = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setPhoneNumber(phoneNumber);
                        }
                    }
                } else if (choice == 6) {
                    System.out.println("Nhập email mới:");
                    String mail = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setEmail(mail);
                        }
                    }
                } else if (choice == 7) {
                    System.out.println("Nhập hạng mới");
                    String membership = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setMembership(membership);
                        }
                    }
                } else if (choice == 8) {
                    System.out.println("Nhập địa chỉ mới");
                    String address = sc.next();
                    for (Customer customer : customerList) {
                        if (customer.getCustomerId() == id) {
                            customer.setAddress(address);
                        }
                    }
                }
            }while (choice != 9);
        }
    }


