package Service;

import model.Brand;
import model.Product;
import model.Type;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerImpl implements ProductManager, Serializable {
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/product_manager4?useSSL=false";
    private static final String username = "root";
    private static final String pass = "123456789";
    private static final String driver = "com.mysql.jdbc.Driver";
    private final  String GET_ALL_PRODUCT ="select product.id,product.name,product.description,product.price,product.img," +
            "type.type,brand.brand from product " +
            "join type on product.type_id = type.id join brand on product.brand_id = brand.id";
    private  final String ADD_PRODUCT = "insert into product(name,description,price,img,type_id,brand_id)" +
            " values(?,?,?,?,?,?)";

    private  final  String UPDATE_PRODUCT = "update product set name=?,description=?,price=?,img=?,type_id=?,brand_id=? where id=?";
    private final String DELETE_PRODUCT = "delete from product where id =?";
    private Connection getConnection(){
        Connection cn =null ;
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url,username,pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return cn;
    }

    @Override
    public void addProduct(Product product) {
        try (Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(ADD_PRODUCT)){
            stm.setString(1, product.getName());
            stm.setString(2,product.getDescription());
            stm.setInt(3,product.getPrice());
            stm.setString(4,product.getImg());
            stm.setInt(5,product.getType_id());
            stm.setInt(6,product.getBrand_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll(){
        List<Product> productList = new ArrayList<>();
        try(
                Connection cn = getConnection();
                PreparedStatement stm = cn.prepareStatement(GET_ALL_PRODUCT)
        ){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
               int id= rs.getInt("product.id");
                String name = rs.getString("product.name");
                String description = rs.getString("product.description");
                int price = rs.getInt("product.price");
                String img =rs.getString("product.img");
                String type =rs.getString("type.type");
                String brand = rs.getString("brand.brand");
                productList.add(new Product(id,name,description,price,img,type,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
    public List<Type> getType(){
        List<Type> typeList = new ArrayList<>();
        try(
                Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement("select*from type")
                ){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String type = rs.getString("type");
                typeList.add(new Type(id,type));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }

    public List<Brand> getBrand(){
        List<Brand> brandList = new ArrayList<>();
        try(
                Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement("select*from brand")
        ){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String brand = rs.getString("brand");
                brandList.add(new Brand(id,brand));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }

    @Override
    public void updateProduct(Product product) {
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(UPDATE_PRODUCT)){
            stm.setString(1,product.getName());
            stm.setString(2,product.getDescription());
            stm.setInt(3,product.getPrice());
            stm.setString(4,product.getImg());
            stm.setInt(5,product.getType_id());
            stm.setInt(6,product.getBrand_id());
            stm.setInt(7,product.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(DELETE_PRODUCT)){
            stm.setInt(1,id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}
