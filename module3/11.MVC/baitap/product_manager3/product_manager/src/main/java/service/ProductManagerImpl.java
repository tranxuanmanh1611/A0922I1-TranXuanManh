package service;

import model.Brand;
import model.Product;
import model.Type;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl implements ProductManager, Serializable  {
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/product_manager3?useSSL=false";
    private static final String username = "root";
    private static final String pass = "123456789";
    private static final String driver = "com.mysql.jdbc.Driver";

    private static final String GET_ALL="select product.id,product.name,product.description,product.price,product.img," +
            "type.type,brand.brand from product " +
            "join type on product.type_id = type.id " +
            "join brand on product.brand_id=brand.id";
    private static final String GET_ALL_TYPE = "select * from type";
    private static final String GET_ALL_BRAND="select*from brand";
private Connection getConnection(){
    Connection cn = null;
    try {
        Class.forName(driver);
        cn = DriverManager.getConnection(url,username,pass);
    } catch (SQLException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    }
    return cn;
}
    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try(Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(GET_ALL)){
           ResultSet rs = stm.executeQuery();

           while (rs.next()){
               int id = rs.getInt("product.id");
               String name =rs.getString("product.name");
               String description = rs.getString("product.description");
               int price = rs.getInt("product.price");
               String img =rs.getString("product.img");
               String type = rs.getString("type.type");
               String brand = rs.getString("brand.brand");
               productList.add(new Product(id,name,description,price,img,type,brand));
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<Type> getAllType() {
        List<Type> typeList = new ArrayList<>();
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(GET_ALL_TYPE)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String type =rs.getString("type");
                typeList.add(new Type(id,type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }

    @Override
    public List<Brand> getAllBrand() {
        List<Brand> brandList = new ArrayList<>();
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(GET_ALL_BRAND)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String brand =rs.getString("brand");
                brandList.add(new Brand(id,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }
}
