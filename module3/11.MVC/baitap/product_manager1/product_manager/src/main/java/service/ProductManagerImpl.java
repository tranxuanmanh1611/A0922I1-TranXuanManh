package service;

import model.Brand;
import model.Product;
import model.Type;
import repo.ProductDB;

import java.sql.SQLException;
import java.util.List;

public class ProductManagerImpl implements productManager{
    @Override
    public void addNewProduct(String name,String description,String img, String type,String brand) {
        ProductDB.addProduct(name,description,img,type,brand);
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList = ProductDB.showProductList();
        return productList;
    }

    @Override
    public Product getProduct(int id) {
        Product product = ProductDB.getProduct(id);
        return product;
    }

    public List<Type> getTypeList(){
        List<Type> typeList = null;
        try {
            typeList = ProductDB.getAllType();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }

    public List<Brand> getBrandList(){
        List<Brand> brandList = null;
        try {
            brandList = ProductDB.getAllBrand();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }
    @Override
    public void editProduct(int id,String name, String description,String img,String type,String brand) {
        ProductDB.updateProduct(id,name,description,img,type,brand);
    }

    @Override
    public void deleteProduct(int id) {
        ProductDB.deleteProduct(id);
    }
}
