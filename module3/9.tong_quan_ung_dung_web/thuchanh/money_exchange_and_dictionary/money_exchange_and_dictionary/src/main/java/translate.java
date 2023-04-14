import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "translate", value = "/translate")
public class translate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String needTranslateWord = request.getParameter("needTranslateWord");
        Map<String,String> EnglishVietnamesdictionary = new HashMap<>();
        EnglishVietnamesdictionary.put("music","âm nhạc");
        EnglishVietnamesdictionary.put("singer","ca sĩ");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        String result = EnglishVietnamesdictionary.get(needTranslateWord);
        if (result!=null){
            writer.println("word: "+needTranslateWord+",<br>meaning: "+result);
        }else {
            writer.println("Không tìm thấy");
        }
        writer.println("</html>");
    }
}
