package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    public static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country)" + "VALUES (?,?,?)";
    public static final String SELECT_ALL_USER = "SELECT*FROM users";
    public static final String DELETE_USER = "DELETE FROM users WHERE id=?;";
    public static final String UPDATE_USER = "UPDATE users SET name=?,email=?,country=? WHERE id = ?;";
    public static final String SELECT_USER = "SELECT * FROM users WHERE id=?";
    public static final String SELECT_COUNTRIES = "SELECT country FROM users GROUP BY 1";
    public static final String SELECT_USER_BY_COUNTRY_ASC = "SELECT * FROM users WHERE country=? ORDER BY name ASC";
    public static final String SELECT_USER_BY_COUNTRY_DESC = "SELECT * FROM users WHERE country=? ORDER BY name DESC";
    public static final String  INSERT_PERMISION="INSERT INTO user_permision(user_id,permision_id) values(?,?)";
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456789";

    public UserDAO() {
    }

    //Tạo kết nối
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection();CallableStatement cstm = connection.prepareCall("{call insert_user(?,?,?)}")){
            cstm.setString(1,user.getName());
            cstm.setString(2,user.getEmail());
            cstm.setString(3,user.getCountry());
            cstm.executeUpdate();
        }
        /*
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } */
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try(Connection connection = getConnection();CallableStatement cstm = connection.prepareCall("{call get_user_by_id(?)}")){
            cstm.setInt(1,id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(name,email,country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       /* User user = null;
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)){
         preparedStatement.setInt(1,id);
         ResultSet rs = preparedStatement.executeQuery();
         while (rs.next()){
           String name = rs.getString("name");
           String email = rs.getString("email");
           String country  = rs.getString("country");
            user = new User(id,name,email,country);
         }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                userList.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userList;
    }
    public List<User> getUserByCountry(String countryFilter,String order){
        List<User> users = new ArrayList<>();
        String statement = null;
        if (order.equals("ASC")){
            statement = SELECT_USER_BY_COUNTRY_ASC;
        }else {
            statement=SELECT_USER_BY_COUNTRY_DESC;
        }
        try (Connection connection = getConnection();PreparedStatement preparedStatement= connection.prepareStatement(statement)){
            preparedStatement.setString(1,countryFilter);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean userUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            userUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userUpdated;
    }

    public List<String> selectCountries(){
        List<String> countries = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRIES)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                countries.add(rs.getString("country"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        ResultSet rs = null;
        try (Connection connection =getConnection();PreparedStatement pstm = connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS);
        PreparedStatement pstmAddPermision = connection.prepareStatement(INSERT_PERMISION)){
            connection.setAutoCommit(false);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getEmail());
            pstm.setString(3,user.getCountry());
            int rowAffected = pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            int userId =0;
            if (rs.next()){
                userId = rs.getInt(1);
            }
            if (rowAffected==1){
                for(int permisionId: permision){
                    pstmAddPermision.setInt(1,userId);
                    pstmAddPermision.setInt(2,permisionId);
                    pstmAddPermision.executeUpdate();
                }
                connection.commit();
            }else {
                connection.rollback();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
