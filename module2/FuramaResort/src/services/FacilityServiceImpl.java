package services;

import models.House;
import models.Room;
import models.Villa;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    LinkedHashMap<String, Integer> facilityList;
    House newHouse;
    Villa newVilla;
    Room newRoom;

    FacilityServiceImpl() {
        facilityList = new LinkedHashMap<>();
    }

    @Override
    public void add() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Chọn loại dịch vụ muốn thêm:\n"
                    + "1.Add New Villa\n"
                    + "2.Add New House\n"
                    + "3.Add New Room\n"
                    + "4.Exit\n");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Nhập tên dịch vụ");
                String serviceName = sc.nextLine();
                System.out.println("Nhập diện tích sử dụng");
                int usableArea = sc.nextInt();
                System.out.println("Nhập giá thuê");
                int cost =sc.nextInt();
                System.out.println("Nhập sức chứa tối đa");
                int maxCapacity = sc.nextInt();
                System.out.println("Nhập kiểu thuê");
                String rentType = sc.nextLine();
                System.out.println("Nhập tiêu chuẩn phòng");
                String roomStandard = sc.nextLine();
                System.out.println("Nhập diện tích hồ bơi");
                int poolArea = sc.nextInt();
                newVilla=new Villa(serviceName,usableArea,cost,maxCapacity,rentType,roomStandard,poolArea);
                facilityList.put(newVilla.getServiceName(),newVilla.getUsedTime());
            } else if (choice == 2) {
                System.out.println("Nhập tên dịch vụ");
                String serviceName = sc.nextLine();
                System.out.println("Nhập diện tích sử dụng");
                int usableArea = sc.nextInt();
                System.out.println("Nhập giá thuê");
                int cost =sc.nextInt();
                System.out.println("Nhập sức chứa tối đa");
                int maxCapacity = sc.nextInt();
                System.out.println("Nhập kiểu thuê");
                String rentType = sc.nextLine();
                System.out.println("Nhập tiêu chuẩn phòng");
                String roomStandard=sc.nextLine();
                System.out.println("Nhập số tầng");
                int floor = sc.nextInt();
                newHouse=new House(serviceName,usableArea,cost,maxCapacity,rentType,roomStandard,floor);
                facilityList.put(newHouse.getServiceName(),newHouse.getUsedTime());
            } else if (choice == 3) {
                System.out.println("Nhập tên dịch vụ");
                String serviceName = sc.nextLine();
                System.out.println("Nhập diện tích sử dụng");
                int usableArea = sc.nextInt();
                System.out.println("Nhập giá thuê");
                int cost =sc.nextInt();
                System.out.println("Nhập sức chứa tối đa");
                int maxCapacity = sc.nextInt();
                System.out.println("Nhập kiểu thuê");
                String rentType = sc.nextLine();
                System.out.println("Dịch vụ miễn phí đi kèm: ");
                String freeService = sc.nextLine();
                newRoom=new Room(serviceName,usableArea,cost,maxCapacity,rentType,freeService);
                facilityList.put(newRoom.getServiceName(),newRoom.getUsedTime());
            }
        } while (choice != 4);
    }

    @Override
    public void edit() {

    }

    @Override
    public void displayList() {

    }
}
