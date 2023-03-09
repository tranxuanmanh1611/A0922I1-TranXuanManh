package service;

import models.Contact;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class ContactManage {
    Scanner sc = new Scanner(System.in);
    int choice;
    LinkedList<Contact> contactList;
    Contact newContact;

    public ContactManage() {
        contactList = new LinkedList<>();
    }

    public void display() {
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
    }

    public void addContact() {

        String phoneNumber, group = "", name, gender = "", address, birth, email;
        do {
            System.out.println("Nhap so dien thoai");
            phoneNumber = sc.nextLine();
            if (!Validate.validatePhoneNumber(phoneNumber)) {
                System.out.println("So dien thoai phai tu 10-11 so");
            }
        } while (!Validate.validatePhoneNumber(phoneNumber));

        System.out.println("Nhap ho va ten");
        name = sc.nextLine();

        do {
            System.out.println("Người này thuộc nhóm:\n"
                    + "1. Nguời nhà\n"
                    + "2. Bạn bè\n"
                    + "3. Đồng nghiệp\n"
                    + "4. Đối tác\n");
            choice = sc.nextInt();
            if (choice == 1) {
                group = "nguoiNha";
                break;
            } else if (choice == 2) {
                group = "banBe";
                break;
            } else if (choice == 3) {
                group = "dongNghiep";
                break;
            } else if (choice == 4) {
                group = "doiTac";
                break;
            }
            System.out.println("Không đúng, nhập lại");
        } while (true);

        do {
            System.out.println("Giới tính:\n"
                    + "1. Nam\n" + "2. Nữ\n");
            choice = sc.nextInt();
            if (choice == 1) {
                gender = "Nam";
                break;
            } else if (choice == 2) {
                gender = "Nữ";
                break;
            }
            System.out.println("Không đúng, nhập lại");
        } while (true);
        sc.nextLine();
        System.out.println("Nhập địa chỉ");
        address = sc.nextLine();
        System.out.println("Nhập ngày sinh");
        birth = sc.nextLine();
        do {
            System.out.println("Nhập email");
            email = sc.nextLine();
            if (!Validate.validateEmail(email)) {
                System.out.println("Định dạng email đúng: ki_tu_bat_ki@ten_mien_dung.com");
            }
        } while (!Validate.validateEmail(email));

        newContact = new Contact(phoneNumber, group, name, gender, address, birth, email);
        contactList.add(newContact);
        System.out.println("Thêm danh bạ thành công");
    }

    public void editContact() {
        String phoneNumber, group = "", name, gender = "", address, birth, email;
        Contact contact = findContact();
        if (contact == null) {
            System.out.println("Không tìm thấy");
        } else {
            do {
                System.out.println(contact);
                System.out.println("Bạn muon sửa gì: \n"
                        + "1.Nhóm danh bạ\n"
                        + "2.Họ tên\n"
                        + "3.Giới tính\n"
                        + "4.Địa chỉ\n"
                        + "5.Ngày sinh\n"
                        + "6.Email\n"
                        + "7. Hủy");
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    do {
                        System.out.println("Người này thuộc nhóm:\n"
                                + "1. Nguời nhà\n"
                                + "2. Bạn bè\n"
                                + "3. Đồng nghiệp\n"
                                + "4. Đối tác\n");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            group = "nguoiNha";
                            break;
                        } else if (choice == 2) {
                            group = "banBe";
                            break;
                        } else if (choice == 3) {
                            group = "dongNghiep";
                            break;
                        } else if (choice == 4) {
                            group = "doiTac";
                            break;
                        }
                        System.out.println("Không đúng, nhập lại");
                    } while (true);
                    contact.setGroup(group);
                    System.out.println("Thay doi thành công");
                } else if (choice == 2) {
                    System.out.println("Nhập họ và tên");
                    name = sc.nextLine();
                    contact.setName(name);
                    System.out.println("Thay doi thành công");
                } else if (choice == 3) {
                    do {
                        System.out.println("Giới tính:\n"
                                + "1. Nam\n" + "2. Nữ\n");
                        choice = sc.nextInt();
                        if (choice == 1) {
                            gender = "Nam";
                            break;
                        } else if (choice == 2) {
                            gender = "Nữ";
                            break;
                        }
                        System.out.println("Không đúng, nhập lại");
                    } while (true);
                    contact.setGender(gender);
                    System.out.println("Thay doi thành công");
                } else if (choice == 4) {
                    System.out.println("Nhập địa chỉ");
                    address = sc.nextLine();
                    contact.setAddress(address);
                    System.out.println("Thay doi thành công");


                } else if (choice == 5) {
                    System.out.println("Nhập ngày sinh");
                    birth = sc.nextLine();
                    contact.setBirth(birth);
                    System.out.println("Thay doi thành công");
                } else if (choice == 6) {
                    do {
                        System.out.println("Nhập email");
                        email = sc.nextLine();
                        if (!Validate.validateEmail(email)) {
                            System.out.println("Định dạng email đúng: ki_tu_bat_ki@ten_mien_dung.com");
                        }
                    } while (!Validate.validateEmail(email));
                    contact.setEmail(email);
                    System.out.println("Thay doi thành công");
                }
            } while (choice != 7);

        }

    }

    public void deleteContact() {
        String accept;
        Contact contact = findContact();
        if (contact == null) {
            System.out.println("Không tìm thấy");
            sc.nextLine();
        } else {
            do {
                System.out.println(contact);
                System.out.println("Bạn có muốn xóa không? nhấn 'y' để xác nhận, nhấn phím bất kì đê thoát ");
                accept = sc.nextLine();
                if (accept.equals("y")) {
                    contactList.remove(contact);
                    System.out.println("Xóa thành công");
                    break;
                }
            } while (accept.equals("y"));


        }
    }

    public Contact findContact() {
        Contact needContact = null;
        System.out.println("Nhập số điện thoại hoặc họ tên(in hoa chữ đầu, không dấu) người cần tìm");
        String data = sc.nextLine();
        for (Contact contact : contactList) {
            if (contact.getName().equals(data) || contact.getPhoneNumber().equals(data)) {
                System.out.println("Đã tìm thấy");
                needContact = contact;
            }
        }
        return needContact;
    }

    public void importFile() {
        File file = new File("contact.csv");
        LinkedList<Contact> newList = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line =null;
            while ((line= bufferedReader.readLine())!=null){
                if (line.trim().equals(" ")){
                    continue;
                }
                String[] entry = line.split(",");
                newList.add(new Contact(entry[0],entry[1],entry[2],entry[3],entry[4],entry[5],entry[6]));
            }
            bufferedReader.close();
            fileReader.close();
            System.out.println("Nhap thanh cong");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        contactList= newList;
    }

    public void exportFile() {
       File file = new File("contact.csv");

        String path = file.getAbsolutePath();
        try {
            FileWriter fileWriter = new FileWriter(path,false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contact contact : contactList) {
                bufferedWriter.write(contact.toStringFile());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            System.out.println("Xuất thành công");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}