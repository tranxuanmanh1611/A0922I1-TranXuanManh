package controller.product_manager;

import model.Product;
import repo.ProductDB;
import service.ProductManagerImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "productServlet", value = "/products")
public class ProductServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    ProductManagerImpl manager = new ProductManagerImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action = req.getParameter("action");
       if (action==null){
           action="";
       }
       switch (action){
           case "create":
               showCreateForm(req,resp);
               break;
           case "editOption":
               showEditOption(req,resp);
               break;
           case "edit":
               showEditForm(req,resp);
               break;
           case "deleteOption":
               showDeleteOption(req,resp);
               break;
           case "confirm":
               showConfirm(req,resp);
               break;
           default:
               showList(req,resp);
       }
    }

    private void showConfirm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"))   ;
        req.setAttribute("id",id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("delete.jsp");
        dispatcher.forward(req,resp);
    }

    private void showDeleteOption(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("delete","...");
        req.setAttribute("productList",manager.getProductList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = manager.getProduct(id);
        req.setAttribute("product",product);
        req.setAttribute("typeList",manager.getTypeList());
        req.setAttribute("brandList",manager.getBrandList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req,resp);
    }

    private void showEditOption(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("editOption","...");
        req.setAttribute("productList",manager.getProductList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "create":
                addProduct(req,resp);
                break;
            case "edit":
                updateProduct(req,resp);
            case "delete":
                deleteProduct(req,resp);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        manager.deleteProduct(id);
        resp.sendRedirect("products");
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String name= req.getParameter("name");
        String description = req.getParameter("description");
        String img =req.getParameter("img");
        String type=req.getParameter("type");
        String brand=req.getParameter("brand");
        manager.editProduct(id,name,description,img,type,brand);
        resp.sendRedirect("products");
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name =req.getParameter("name");
        String description = req.getParameter("description");
        String img = req.getParameter("img");
        String type = req.getParameter("type");
        String brand = req.getParameter("brand");
        manager.addNewProduct(name,description, img,type,brand);
        resp.sendRedirect("products");
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("create","...");
        req.setAttribute("typeList",manager.getTypeList());
        req.setAttribute("brandList",manager.getBrandList());
        req.setAttribute("productList",manager.getProductList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList",manager.getProductList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req,resp);
    }
}
