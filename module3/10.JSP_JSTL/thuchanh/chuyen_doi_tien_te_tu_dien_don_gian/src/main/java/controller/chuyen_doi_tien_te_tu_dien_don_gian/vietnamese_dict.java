package controller.chuyen_doi_tien_te_tu_dien_don_gian;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "vietnamese_dict", value = "/translate")
public class vietnamese_dict extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Map<String,String> list = new HashMap();
         list.put("music","am nhac");
         list.put("physics","vat li");
         list.put("codecademy","hoc lap trinh");
         String needSearchWord = request.getParameter("needSearchWord");
         String translatedWord = null;
         if (list.get(needSearchWord)!=null){
             translatedWord=list.get(needSearchWord);
         }
         request.setAttribute("translatedWord",translatedWord);
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("translate_result.jsp");
         requestDispatcher.forward(request,response);
    }
}
