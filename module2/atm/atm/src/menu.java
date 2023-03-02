import input.Card;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Trình quản lí thẻ:\n 1.Mở thẻ\n 2.Xuất dữ liệu\n 3.Nhập dữ liệu\n 4.thanh toán\n"
                    + " 5.Tìm kiem\n 6.thoát\n");
            choice = sc.nextInt();
            if (choice == 1) {
                service.register();
            } else if (choice == 2) {
                service.exportData();
            } else if (choice == 3) {
                service.importData();
            } else if (choice == 4) {
                service.transaction();
                sc.nextLine();
            } else if (choice == 5) {
                Card output =service.find();
                if (output == null) {
                    System.out.println("không tìm thấy");
                } else {
                    System.out.println(output.toString());
                }
            } else if (choice == 6) {
                System.out.println("Đóng ứng dụng");
            }
        } while (choice != 6);
    }
}
