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
    private static final String url = "jdbc:mysql://localhost:3306/product_manager2?useSSL=false";
    private static final String username = "root";
    private static final String pass = "123456789";
    private static final String driver = "com.mysql.jdbc.Driver";
    public static final String ADD_PRODUCT ="insert into product(name,description,img,type_id,brand_id) " +
                                            "values(?,?,?,?,?)";
    public static final String UPDATE_PRODUCT = "update product set name=?,description=?,img=?,type_id=?,brand_id=? where id=?";
    public static final String GET_ALL = "select product.id, product.name,product.description,product.img,type.type,brand.brand\n" +
            "from product join type on product.type_id = type.id join brand on product.brand_id = brand.id";
    public static final String GET_ALL_BRAND ="select * from brand";
    public static final String GET_ALL_TYPE = "select * from type";
    public static final String DELETE_PRODUCT = "delete from product where id = ?";
    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void addProduct(Product product) {
        try (Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(ADD_PRODUCT)){
            stm.setString(1,product.getName());
            stm.setString(2,product.getDescription());
            stm.setString(3,product.getImg());
            stm.setInt(4,product.getType_id());
            stm.setInt(5, product.getBrand_id());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(UPDATE_PRODUCT)){
            stm.setString(1,product.getName());
            stm.setString(2,product.getDescription());
            stm.setString(3,product.getImg());
            stm.setInt(4,product.getType_id());
            stm.setInt(5,product.getBrand_id());
            stm.setInt(6,product.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(GET_ALL)){

            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("product.id");
                String name = rs.getString("product.name");
                String description = rs.getString("product.description");
                String img = rs.getString("product.img");
                String type = rs.getString("type.type");
                String brand =rs.getString("brand.brand");
                productList.add(new Product(id,name,description,img,type,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<Brand> getAllBrand() {
        List<Brand> brandList = new ArrayList<>();
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(GET_ALL_BRAND)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String brand =rs.getString("brand");
                brandList.add(new Brand(id,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brandList;
    }

    @Override
    public List<Type> getAllType() {
        List<Type> typeList = new ArrayList<>();
        try(Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(GET_ALL_TYPE)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String type =rs.getString("type");
                typeList.add(new Type(id,type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }

    @Override
    public void deleteProduct(int id) {
        try (Connection cn = getConnection();PreparedStatement stm = cn.prepareStatement(DELETE_PRODUCT)){
            stm.setInt(1,id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getSearch(String typeSearch,String search) {
        List<Product> searchList = new ArrayList<>();
        String sql1 = null;
        String sql2 = "'" + "%"+search+"%"+"'";
        if (typeSearch.equals("name")){
            sql1 = " where product.name like ";
        } else if (typeSearch.equals("description")) {
            sql1 = " where product.description like ";
        } else {
            sql1 = " where brand.brand like ";
        }

        try (Connection cn =getConnection();PreparedStatement stm = cn.prepareStatement(GET_ALL +sql1 +sql2)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                int id = rs.getInt("product.id");
                String name = rs.getString("product.name");
                String description = rs.getString("product.description");
                String img = rs.getString("product.img");
                String type = rs.getString("type.type");
                String brand =rs.getString("brand.brand");
                searchList.add(new Product(id,name,description,img,type,brand));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchList;
    }

}
