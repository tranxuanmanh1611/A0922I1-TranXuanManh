import service.ContactManage;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ContactManage contactManage = new ContactManage();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----\n"
                    + "Chọn chức năng theo số (để tiếp tục):\n"
                    + "1. Xem danh sach\n"
                    + "2. Thêm mới\n"
                    + "3. Cập nhật\n"
                    + "4. Xóa\n"
                    + "5. Tìm kiếm\n"
                    + "6. Đọc từ file\n"
                    + "7. Ghi vào file\n"
                    + "8. Thoát\n");
            System.out.println("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                contactManage.display();
            } else if (choice == 2) {
                contactManage.addContact();
            } else if (choice == 3) {
                contactManage.editContact();
            } else if (choice == 4) {
                contactManage.deleteContact();
            } else if (choice == 5) {
                System.out.println(contactManage.findContact());
            } else if (choice == 6) {
                contactManage.importFile();
            } else if (choice == 7) {

                    contactManage.exportFile();


            }
        } while (choice != 8);

    }
}
