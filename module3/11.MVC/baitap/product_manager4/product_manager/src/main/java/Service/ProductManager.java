package Service;

import model.Product;

import java.util.List;

public interface ProductManager {
    void addProduct(Product product);
    List<Product> getAll();
    void updateProduct(Product product);
    void deleteProduct(int id);
}
