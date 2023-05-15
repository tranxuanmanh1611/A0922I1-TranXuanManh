package controller;

import Service.ProductManagerImpl;
import model.Brand;
import model.Product;
import model.Type;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductManagerImpl manager =  new ProductManagerImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;

            default:
                showList(request,response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = manager.getAll();
        List<Type> typeList = manager.getType();
        List<Brand> brandList = manager.getBrand();
        request.setAttribute("list",productList);
        request.setAttribute("typeList",typeList);
        request.setAttribute("brandList",brandList);
        request.setAttribute("edit",Integer.parseInt(request.getParameter("id")));
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = manager.getAll();
        List<Type> typeList = manager.getType();
        List<Brand> brandList = manager.getBrand();
        request.setAttribute("list",productList);
        request.setAttribute("typeList",typeList);
        request.setAttribute("brandList",brandList);
        request.setAttribute("create","...");
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = manager.getAll();
        request.setAttribute("list",productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                addProduct(request,response);
                break;
            case "showEdit":
                showEditForm(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        manager.deleteProduct(id);
        response.sendRedirect("products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        String img = request.getParameter("img");
        int type_id = Integer.parseInt(request.getParameter("type"));
        int brand_id = Integer.parseInt(request.getParameter("brand"));
        manager.updateProduct(new Product(id,name,description,price,img,type_id,brand_id));
        response.sendRedirect("products");
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String name =   request.getParameter("name");
     String description = request.getParameter("description");
     int price = Integer.parseInt(request.getParameter("price"));
     String img = request.getParameter("img");
     int type_id = Integer.parseInt(request.getParameter("type"));
     int brand_id = Integer.parseInt(request.getParameter("brand"));
     manager.addProduct(new Product(name,description,price,img,type_id,brand_id));
     response.sendRedirect("products");
    }
}
