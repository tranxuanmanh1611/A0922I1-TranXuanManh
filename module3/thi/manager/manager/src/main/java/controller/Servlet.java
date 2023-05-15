package controller;

import model.Borrow;
import service.Impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "Servlet", value = "/servlet")
public class Servlet extends HttpServlet {
    Impl manager = new Impl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrowForm(request, response);
                break;
            case "borrowList":
                showBorrowList(request, response);
                break;
            case "backbook":
                updateBorrow(request, response);
                break;

            default:
                showBookList(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String student = request.getParameter("studentName");
        String book = request.getParameter("bookName");
        List<Borrow> searchList = manager.getByStudentOrBook(student, book);
        if (!searchList.isEmpty()) {
            request.setAttribute("borrowList", searchList);
        } else {

            request.setAttribute("error", "Khong tim thay");

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("borrowlist.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBorrow(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String borrowId = request.getParameter("id");
        String bookId = request.getParameter("bookId");
        manager.backBook(borrowId, bookId);
        response.sendRedirect("servlet?action=borrowList");
    }

    private void showBorrowList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("borrowList", manager.getAllBorrow());
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrowlist.jsp");
        dispatcher.forward(request, response);
    }

    private void showBorrowForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = Integer.parseInt(request.getParameter("amount"));
        if (amount > 0) {
            String bookId = request.getParameter("id");
            request.setAttribute("book", manager.getBookById(bookId));
            request.setAttribute("studentList", manager.getAllStudent());
            Date current = Date.valueOf(java.time.LocalDate.now());
            request.setAttribute("currentTime",current);
            RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_form.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Khong con sach de cho muon");
            request.setAttribute("bookList", manager.getAllBook());
            RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void showBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("bookList", manager.getAllBook());
        RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                addBorrow(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    private void addBorrow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String borrowId = request.getParameter("borrowId");
        String bookId = request.getParameter("id");
        String studentId = request.getParameter("studentId");
        Date current = Date.valueOf(java.time.LocalDate.now());
        String borrowDate = current+"";
        String backDate = Date.valueOf(request.getParameter("backDate")) + "";
        Borrow borrow = new Borrow(borrowId, bookId, studentId, borrowDate, backDate);
        manager.addBorrow(borrow);
        request.setAttribute("alertBorrowSuccess", "cho muon thanh cong");
        request.setAttribute("bookList", manager.getAllBook());
        RequestDispatcher dispatcher = request.getRequestDispatcher("booklist.jsp");
        dispatcher.forward(request, response);
    }

}

