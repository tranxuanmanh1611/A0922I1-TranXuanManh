import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Trình quản lí thẻ:\n 1.Mở thẻ\n 2.Xuất dữ liệu\n 3.Nhập dữ liệu\n 4.thanh toán\n"
                    + " 5.Thoát\n");
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
            }
            if (choice == 5) {
                System.out.println("Đóng ứng dụng");
            }
        } while (choice != 5);
    }
}
