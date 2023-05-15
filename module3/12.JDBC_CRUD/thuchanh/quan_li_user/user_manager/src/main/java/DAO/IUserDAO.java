package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUsers();
    void deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    void addUserTransaction(User user,int[] permision);
}
