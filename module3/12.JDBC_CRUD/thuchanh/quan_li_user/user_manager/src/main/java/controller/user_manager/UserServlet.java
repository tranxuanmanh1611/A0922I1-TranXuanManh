package controller.user_manager;

import DAO.UserDAO;
import model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/users")
public class UserServlet extends HttpServlet implements Serializable{
public static final long serialVersionUID = 1L;
private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO=new UserDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action=  request.getParameter("action");
        if (action==null){
            action=" ";
        }
        switch (action){
            case "create":
                displayCreateForm(request, response);
                break;
            case "delete":
                showComfirm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "permision":
                addUserPermision(request,response);
                break;
            default:
            showList(request, response);
               break;

        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        userDAO.addUserTransaction(user, permision);
    }


    private void showComfirm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userDAO.selectUser(id);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher =request.getRequestDispatcher("user/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userDAO.selectUser(id);
        request.setAttribute("user",user);
        RequestDispatcher dispatcher =request.getRequestDispatcher("user/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<User> list = userDAO.selectAllUsers();
        List<String> countries = userDAO.selectCountries();
        request.setAttribute("list",list);
        request.setAttribute("countries",countries);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                creatUser(request, response);
                break;
            case "edit":
                updateUser(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "countryFilter":
                filterByCountry(request,response);
                break;
        }
    }

    private void filterByCountry(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        String order = request.getParameter("order");
        List<User> listByCountry = this.userDAO.getUserByCountry(country,order);
        request.setAttribute("listByCountry",listByCountry);
        List<String> countries = userDAO.selectCountries();
        request.setAttribute("countries",countries);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
       this.userDAO.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        try {
            if (this.userDAO.updateUser(new User(id,name,email,country))){
                String alert = "Cập nhật thành công";
                request.setAttribute("alert",alert);
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void creatUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        try {
            this.userDAO.insertUser(new User(name,email,country));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String alert = "Thêm mới thành công";
        request.setAttribute("alert",alert);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}