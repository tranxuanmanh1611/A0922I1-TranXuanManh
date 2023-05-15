package controller.manager;

import model.BenhAn;
import service.ServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "Servlet", value = "/servlet")
public class Servlet extends HttpServlet {

    ServiceImpl manager = new ServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                showList(request,response);


        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        manager.delete(id);
        request.setAttribute("benh_an_list",manager.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("benh_an",manager.getById(request.getParameter("id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("benh_an_list",manager.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                update(request,response);
                break;


        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("ten_benh_nhan");
        String ngay_nhap = Date.valueOf(request.getParameter("ngay_vao"))+"";
        String ngay_ra = Date.valueOf(request.getParameter("ngay_ra")) + "";
        String ly_do = request.getParameter("ly_do");
        manager.update(id,name,ngay_nhap,ngay_ra,ly_do);
        response.sendRedirect("servlet");
    }
}
