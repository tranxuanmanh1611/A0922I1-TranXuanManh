package service;

import model.Book;
import model.Borrow;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Impl implements BookService {
    private static final String url = "jdbc:mysql://localhost:3306/book_manager?useSSL=false";
    private static final String username = "root";
    private static final String pass = "123456789";
    private static final String driver = "com.mysql.jdbc.Driver";

    private Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            cn = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cn;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<>();
        String sql_get_all_book = "select * from book";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_get_all_book); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                String descript = rs.getString(4);
                int amount = rs.getInt(5);
                Book newBook = new Book(id, name, author, descript, amount);
                bookList.add(newBook);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    public Book getBookById(String id) {
        Book newBook = null;
        String sql_get_all_book = "select * from book where id =?";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_get_all_book)) {
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                String name = rs.getString(2);
                newBook = new Book(id, name);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newBook;
    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        String sql_get_all_student = "select * from student";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_get_all_student); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String classroom = rs.getString(3);
                studentList.add(new Student(id, name, classroom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public void addBorrow(Borrow borrow) {
        String sql_add_borrow = "insert into borrow values(?,?,?,?,?,?)";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_add_borrow)) {
            stm.setString(1, borrow.getId());
            stm.setString(2, borrow.getBookid());
            stm.setString(3, borrow.getStudentid());
            stm.setString(4, Boolean.toString(borrow.isStatus()));
            stm.setString(5, borrow.getBorrowDate());
            stm.setString(6, borrow.getBackDate());
            boolean isUpdated = stm.executeUpdate() > 0;
            if (isUpdated) {
                updateAmount(true, borrow.getBookid());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Borrow> getAllBorrow() {
        List<Borrow> borrowList = new ArrayList<>();
        String sql_get_borrow = "select borrow.id, book.name, book.author, student.name,student.class,borrow.borrowdate,borrow.backdate,book.id" +
                " from borrow join book on borrow.bookid=book.id join student on borrow.studentid = student.id" +
                " where borrow.status = 'true'";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_get_borrow); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString(1);
                String book = rs.getString(2);
                String author = rs.getString(3);
                String student = rs.getString(4);
                String classroom = rs.getString(5);
                String borrowDate = rs.getString(6);
                String backDate = rs.getString(7);
                String bookid = rs.getString(8);
                borrowList.add(new Borrow(id, borrowDate, backDate, book, author, student, classroom, bookid));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return borrowList;
    }

    @Override
    public void updateAmount(boolean isDecreased, String id) {
        String sql_increase = "update book set amount = (amount+1) where id=" + "'" + id + "'";
        String sql_decrease = "update book set amount = (amount-1) where id=" + "'" + id + "'";
        if (isDecreased) {
            try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_decrease)) {
                stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_increase)) {
                stm.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void backBook(String borrowId, String bookId) {
        String sql_update_status_borrow = "update borrow set status='false' where id=" + "'" + borrowId + "'";
        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_update_status_borrow)) {
            boolean isUpdate = stm.executeUpdate() > 0;
            if (isUpdate) {
                updateAmount(false, bookId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Borrow> getByStudentOrBook(String studentName, String bookName) {
        List<Borrow> searchList = new ArrayList<>();
        if (studentName.equals("")){studentName="aojfoiawejfoijwaef";}
        if (bookName.equals("")){bookName="ahfiowjefiow";}

            String sql_get_by_student_or_book = "select borrow.id, book.name, book.author, student.name,student.class,borrow.borrowdate,borrow.backdate,book.id" +
                        " from borrow join book on borrow.bookid=book.id join student on borrow.studentid = student.id "
                        + "where (student.name like " + "concat('%',?,'%')" + " or book.name like " + "concat('%',?,'%')) and borrow.status='true'";



        try (Connection cn = getConnection(); PreparedStatement stm = cn.prepareStatement(sql_get_by_student_or_book)) {
            stm.setString(1, studentName);
            stm.setString(2, bookName);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String book = rs.getString(2);
                String author = rs.getString(3);
                String student = rs.getString(4);
                String classroom = rs.getString(5);
                String borrowDate = rs.getString(6);
                String backDate = rs.getString(7);
                String bookid = rs.getString(8);
                searchList.add(new Borrow(id, borrowDate, backDate, book, author, student, classroom, bookid));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchList;
    }
}