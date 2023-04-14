package controller.calculator;

import model.Calculator;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    double firstOperand = Double.parseDouble(request.getParameter("firstOperand"));
    double secondOperand = Double.parseDouble(request.getParameter("secondOperand"));
    String math = request.getParameter("math");
    Double result = null;
    try {
        result = Calculator.calculate(firstOperand, secondOperand, math);
    } catch (ArithmeticException e) {
        result=null;
    }

    request.setAttribute("result", result);
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
}


}