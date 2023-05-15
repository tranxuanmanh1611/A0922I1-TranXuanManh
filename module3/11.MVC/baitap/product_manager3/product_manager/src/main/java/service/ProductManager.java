package service;

import model.Brand;
import model.Product;
import model.Type;

import java.util.List;

public interface ProductManager {
    List<Product> getAll();
    List<Type> getAllType();
    List<Brand> getAllBrand();
}
