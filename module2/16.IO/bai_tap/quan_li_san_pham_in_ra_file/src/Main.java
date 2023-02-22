import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        Scanner sc = new Scanner(System.in);
        String path = "D:\\codegym\\codegym\\module2\\16.IO\\bai_tap\\quan_li_san_pham_in_ra_file\\productList";
        int choice;
        do {
            System.out.println("Chọn tác vụ:\n"
                    + "1.Thêm sp\n"
                    + "2.Tìm sp\n"
                    + "3.Hiển thị danh sách ra màn hình\n"
                    + "4.Xuất file\n"
                    + "5.Nhập file\n"
                    + "6.exit\n");
            choice = sc.nextInt();
            if (choice == 1) {
                productManagement.addProduct();
            } else if (choice == 2) {
                productManagement.findProduct();
            } else if (choice == 3) {
                productManagement.displayData();
            } else if (choice == 4) {
                productManagement.exportData(path);
            } else if (choice == 5) {
                productManagement.importData(path);
            }
        } while (choice != 6);
    }
}
