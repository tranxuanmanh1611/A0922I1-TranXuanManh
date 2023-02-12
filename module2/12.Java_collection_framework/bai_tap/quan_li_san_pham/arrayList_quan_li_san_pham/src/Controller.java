import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        ProductManagerByArrayList productManagerByArrayList = new ProductManagerByArrayList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Trình quản lí sản phẩm\n"
                    + "1. Thêm sản phẩm\n"
                    + "2. Sửa thông tin\n"
                    + "3. Xóa sản phẩm\n"
                    + "4. Hiển thị danh sách sản phẩm\n"
                    + "5. Tìm kiếm theo tên\n"
                    + "6. Sắp xếp\n"
                    + "7. Exit\n");
            choice = sc.nextInt();
            if (choice == 1) {
                productManagerByArrayList.add();
            } else if (choice == 2) {
                productManagerByArrayList.edit();
            } else if (choice == 3) {
                productManagerByArrayList.delete();
            } else if (choice == 4) {
                productManagerByArrayList.display();
            } else if (choice == 5) {
                productManagerByArrayList.find();
            } else if (choice == 6) {
                do {
                    System.out.println("6. Sắp xếp:\n"
                            + "6.1. Giá tăng dần\n"
                            + "6.2. Giá giảm dần\n"
                            + "6.3. Return\n");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        productManagerByArrayList.increasePriceSort();
                    } else if (choice == 2) {
                        productManagerByArrayList.decreasePriceSort();
                    }
                } while (choice != 3);

            }
        } while (choice != 7);
    }
}

