package service;

import model.Product;

import java.util.List;

public interface productManager {
void addNewProduct(String name,String description,String img, String type_id,String brand_id);
List<Product> getProductList();
Product getProduct(int id);
void editProduct(int id,String name, String description,String img,String type,String brand);
void deleteProduct(int id);
}
