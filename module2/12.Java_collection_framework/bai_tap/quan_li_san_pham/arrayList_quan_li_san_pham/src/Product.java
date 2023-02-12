public class Product {
    private String name;
    private int price;
    private int productId;
    Product(){}
    Product(String name,int price,int productId){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{"+"id= "+productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
