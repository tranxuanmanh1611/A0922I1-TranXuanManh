package repo;

import model.Brand;
import model.Product;
import model.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    public static final String SELECT_ALL_PRODUCT = "select product.id, product.product_name, product.product_description, product.product_img_url, \n" +
            "\t   product_type.type_name, brand.brand\n" +
            "from product \n" +
            "join product_type on product.type_id = product_type.id\n" +
            "join brand on product.brand_id = brand.id";
    private static String dbURL ="jdbc:mysql://localhost:3306/product_manager?useSSL=false";
    private static String username="root";
    private static String pass = "123456789";

    private static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL,username,pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static List<Product> showProductList(){
        List<Product> productList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT)){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("product.id");
                String name = rs.getString("product.product_name");
                String description = rs.getString("product.product_description");
                String img =rs.getString("product.product_img_url");
                String type = rs.getString("product_type.type_name");
                String brand =rs.getString("brand.brand");
                productList.add(new Product(id,name,description,img,type,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
    public static Product getProduct(int id){
        Product product = null;
        try(Connection connection = getConnection();PreparedStatement stm = connection.prepareStatement(SELECT_ALL_PRODUCT + " where product.id =?")){
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                String name = rs.getString("product.product_name");
                String description = rs.getString("product.product_description");
                String img = rs.getString("product.product_img_url");
                String type = rs.getString("product_type.type_name");
                String brand = rs.getString("brand.brand");
                product=new Product(id,name,description,img,type,brand);
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Type> getAllType() throws SQLException {
        List<Type> typeList = new ArrayList<>();
        try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement("Select* from product_type")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String type = rs.getString("type_name");
                typeList.add(new Type(id,type));
            }
        }
        return typeList;
    }

    public static List<Brand> getAllBrand() throws SQLException {
        List<Brand> brandList = new ArrayList<>();
        try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement("Select * from brand")){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id =rs.getInt("id");
                String brand = rs.getString("brand");
                brandList.add(new Brand(id,brand));
            }
        }
        return brandList;
    }

    public static void addProduct(String name, String description,String img,String type,String brand){
        try (Connection connection = getConnection();PreparedStatement statement = connection.prepareStatement("insert into product (product_name,product_description,product_img_url,type_id,brand_id) values (?,?,?,?,?)")){
            statement.setString(1,name);
            statement.setString(2,description);
            statement.setString(3,img);
            int type_id = getTypeId(type);
            if (type_id==0){
                addType(type);
            }
            type_id = getTypeId(type);
            statement.setInt(4,type_id);
            int brand_id = getBrandId(brand);
            if(brand_id==0){
                addBrand(brand);
            }
            brand_id = getBrandId(brand);
            statement.setInt(5,brand_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addType(String type){
        try(Connection connection=getConnection();PreparedStatement stm=connection.prepareStatement("insert into product_type(type_name) values (?)")){
            stm.setString(1,type);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static int getTypeId(String type) throws SQLException {
        int id=0;
        try(Connection connection = getConnection();PreparedStatement stm = connection.prepareStatement("select id from product_type where type_name=?")){
            stm.setString(1,type);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
               id= rs.getInt("id");
            }
        }
        return id;
    }
    private static void addBrand(String brand){
        try(Connection connection=getConnection();PreparedStatement stm=connection.prepareStatement("insert into brand(brand) values (?)")){
            stm.setString(1,brand);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static int getBrandId(String brand) throws SQLException {
        int id=0;
        try(Connection connection = getConnection();PreparedStatement stm = connection.prepareStatement("select id from brand where brand=?")){
            stm.setString(1,brand);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                id= rs.getInt("id");
            }
        }
        return id;
    }
    public static void updateProduct(int id,String name, String description,String img,String type,String brand){
        try(Connection connection=getConnection();PreparedStatement stm = connection.prepareStatement("update product set product_name=?,product_description=?, product_img_url=?,type_id=?,brand_id=? where id=?")){
            stm.setString(1,name);
            stm.setString(2,description);
            stm.setString(3,img);
            int type_id = getTypeId(type);
            if (type_id==0){
                addType(type);
            }
            type_id = getTypeId(type);
            stm.setInt(4,type_id);
            int brand_id = getBrandId(brand);
            if(brand_id==0){
                addBrand(brand);
            }
            brand_id = getBrandId(brand);
            stm.setInt(5,brand_id);
            stm.setInt(6,id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteProduct(int id){
        try(Connection connection = getConnection();PreparedStatement stm = connection.prepareStatement("delete from product where id =?")){
            stm.setInt(1,id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
