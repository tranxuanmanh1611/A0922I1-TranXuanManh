import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    Scanner sc = new Scanner(System.in);
    List<Product> productList=new ArrayList<>();
    Product product;

    public void addProduct() {
        System.out.println("Nhập mã sp");
        String productCode = sc.nextLine();
        System.out.println("Nhập tên sp");
        String productName = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String productBrand = sc.nextLine();
        System.out.println("Nhập giá sp");
        int productPrice = sc.nextInt();
        System.out.println("Nhập chú thích khác");
        String productOtherDiscribe = sc.nextLine();
        product = new Product(productCode, productName, productBrand, productPrice, productOtherDiscribe);
        productList.add(product);
    }

    public void findProduct() {
        System.out.println("Nhập hãng sản xuất");
        String productBrand = sc.next();
        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductBrand().equals(productBrand)) {
                filteredList.add(product);
            }
        }

        System.out.println("Đã chọn ra các sản phẩm cùng hãng");
        for (Product product : filteredList) {
            System.out.println(product);
        }
        int choice = -1;
        do {
            System.out.println("chọn mức giá:\n"
                    + "1.<100$\n"
                    + "2.>100$\n"
                    + "3.kết thúc\n");
            System.out.println("Nhập lựa chọn");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Các sp phù hợp: ");
                for (Product product : filteredList) {
                    if (product.getProductPrice() < 100) {
                        System.out.println(product);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Các sp phù hợp: ");
                for (Product product : filteredList) {
                    if (product.getProductPrice() >= 100) {
                        System.out.println(product);
                    }
                }
            }
        } while (choice != 3);


    }

    public void displayData() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void exportData(String path) {
        ImportExport.exportData(path, productList);
    }

    public void importData(String path) {
       productList= ImportExport.importData(path);
    }
}
