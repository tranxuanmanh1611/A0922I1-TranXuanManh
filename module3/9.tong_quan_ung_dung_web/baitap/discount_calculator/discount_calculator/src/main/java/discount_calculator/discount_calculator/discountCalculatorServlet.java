package discount_calculator.discount_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "discountCalculatorServlet", value = "/discountCalculatorServlet")
public class discountCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float rate =Float.parseFloat(request.getParameter("rate"));
        float total = price * (1+rate/100);
        request.setAttribute("total",total);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index2.jsp");
        requestDispatcher.forward(request,response);

    }
}
