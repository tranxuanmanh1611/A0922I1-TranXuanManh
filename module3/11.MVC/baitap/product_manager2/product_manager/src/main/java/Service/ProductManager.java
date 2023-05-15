package Service;

import model.Brand;
import model.Product;
import model.Type;

import java.util.List;

public interface ProductManager {
    List<Product> getAll();

    List<Brand> getAllBrand();

    List<Type> getAllType();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    List<Product> getSearch(String type,String search);
}
