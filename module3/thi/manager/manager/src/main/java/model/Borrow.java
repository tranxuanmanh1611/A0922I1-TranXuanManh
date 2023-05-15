package model;

import java.sql.Date;

public class Borrow {
    private String id;
    private String bookid;
    private String studentid;
    private boolean status;
    private String borrowDate;
    private String backDate;
    private String book;
    private String author;
    private String student;
    private String classroom;

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Borrow(String id, String borrowDate, String backDate, String book, String author, String student, String classroom,String bookId) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.backDate = backDate;
        this.book = book;
        this.author = author;
        this.student = student;
        this.classroom = classroom;
        this.bookid=bookId;
    }

    public Borrow(String id, String bookid, String studentid, String borrowDate, String backDate) {
        this.id = id;
        this.bookid = bookid;
        this.studentid = studentid;
        this.status = true;
        this.borrowDate = borrowDate;
        this.backDate = backDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBorrowDate() {
        return borrowDate;
    }



    public String getBackDate() {
        return backDate;
    }


}
