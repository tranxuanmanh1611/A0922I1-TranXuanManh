import java.util.*;

public class ProductManagerByArrayList {
    List<Product> productList;
    Stack<Integer> unusedId;
    Product newProduct;
    private int productId = 0;

    ProductManagerByArrayList() {
        productList = new ArrayList<>();
        unusedId = new Stack<>();
    }

    public void add() {
        if (!unusedId.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên sản phẩm");
            String name = sc.nextLine();
            System.out.println("Nhập giá");
            int price = sc.nextInt();
            newProduct = new Product(name, price, unusedId.pop());
            productList.add(newProduct);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên sản phẩm");
            String name = sc.nextLine();
            System.out.println("Nhập giá");
            int price = sc.nextInt();
            productId++;
            newProduct = new Product(name, price, productId);
            productList.add(newProduct);
        }
    }

    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm");
        int productId = sc.nextInt();
        String name;
        int price;
        int choice = 0;
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                System.out.println("tìm thấy sản phẩm: " + product.getName()+"| giá: "+product.getPrice());
                do {
                    System.out.println("Bạn muốn sửa: \n"
                            + "1. Tên\n"
                            + "2. Giá\n"
                            + "3.Thoát\n");
                    choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("nhập tên mới");
                        name = sc.nextLine();
                        product.setName(name);
                        System.out.println("Đã sửa xong");
                    } else if (choice == 2) {
                        System.out.println("nhập giá mới");
                        price = sc.nextInt();
                        product.setPrice(price);
                        System.out.println("Đã sửa xong");
                    }
                } while (choice != 3);
            }
        }
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm");
        int productId = sc.nextInt();
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                productList.remove(product);
                unusedId.add(productId);
            }
        }
        System.out.println("Đã xóa xong");
    }
    public void find(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm");
        String name =sc.nextLine();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                System.out.println("Tìm thấy:");
                System.out.println(product.toString());
            }
        }
    }

    public void display() {
        System.out.println("DANH SÁCH SẢN PHẨM");
        for (Product product : productList) {
            System.out.println(product.toString());
        }
        System.out.println("HẾT\n" +
                "-------------------------------");

    }
    public void increasePriceSort(){
        IncreasePriceComparator priceComparator= new IncreasePriceComparator();
        Collections.sort(productList,priceComparator);
    }
    public void decreasePriceSort(){
        DecreasePriceComparator priceComparator=new DecreasePriceComparator();
        Collections.sort(productList,priceComparator);
    }
}
