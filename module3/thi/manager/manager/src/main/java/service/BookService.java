package service;

import model.Book;
import model.Borrow;
import model.Student;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    List<Student> getAllStudent();
    List<Borrow> getAllBorrow ();
    void addBorrow(Borrow borrow);
    void backBook(String borrowId,String bookId);

    void updateAmount(boolean isIncreased,String id);
List<Borrow> getByStudentOrBook(String studentName,String bookName);
}
