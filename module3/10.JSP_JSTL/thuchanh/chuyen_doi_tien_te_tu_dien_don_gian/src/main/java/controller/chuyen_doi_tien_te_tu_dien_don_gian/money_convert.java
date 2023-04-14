package controller.chuyen_doi_tien_te_tu_dien_don_gian;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "usdToVndServlet", value ="/converted")
public class money_convert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = rate * usd;
        request.setAttribute("vnd", vnd);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("convertresult.jsp");
        requestDispatcher.forward(request, response);
    }}
