import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String productBrand;
    private int productPrice;
    private String productOtherDiscribe;

    Product() {
    }

    Product(String productCode, String productName, String productBrand, int productPrice, String productOtherDiscribe) {
        this.productCode = productCode;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
        this.productOtherDiscribe = productOtherDiscribe;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductOtherDiscribe() {
        return productOtherDiscribe;
    }

    public void setProductOtherDiscribe(String productOtherDiscribe) {
        this.productOtherDiscribe = productOtherDiscribe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productOtherDiscribe='" + productOtherDiscribe + '\'' +
                '}';
    }
}
