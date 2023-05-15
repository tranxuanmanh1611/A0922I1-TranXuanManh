package controller.inotes;

import model.Note;
import model.NoteType;
import service.iNoteServiceManager;
import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "noteServlet", value = "/notes")
public class NoteServlet extends HttpServlet {

    public static final String alert_success = "Thao tác thành công";
    iNoteServiceManager iNoteServiceManager = new iNoteServiceManager();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     String action =  request.getParameter("action");
      if (action==null){
          action = " ";
      }
      switch (action){
          case "create":
              showCreateForm(request,response);
              break;
          case "edit":
              showEditForm(request,response);
              break;
          case "delete":
             showComfirmation(request,response);
              break;
          default:
              showNotes(request,response);
              break;
      }
    }

    private void showComfirmation(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Note note = this.iNoteServiceManager.getNoteById(id);
        request.setAttribute("note",note);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> typeList = this.iNoteServiceManager.getAllType();
        request.setAttribute("typeList",typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<NoteType> typeList = this.iNoteServiceManager.getAllType();
        request.setAttribute("typeList",typeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNotes(HttpServletRequest request, HttpServletResponse response) {
        List<Note> noteList = iNoteServiceManager.getAllNote();
        request.setAttribute("noteList",noteList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action=" ";
        }
        switch (action){
            case "create":
                createNote(req,resp);
                break;
            case "edit":
                editNote(req,resp);
                break;
            case "delete":
                deleteNote(req,resp);
                break;
            case "search":
                showSearchList(req,resp);
                break;
        }
    }

    private void showSearchList(HttpServletRequest req, HttpServletResponse resp) {
       String search = req.getParameter("search");
       List<Note> listSearch = this.iNoteServiceManager.searchNote(search);
       req.setAttribute("searchResult","...");
       if (listSearch.size()>1){
           req.setAttribute("many",listSearch);
       }else if(listSearch.size()==1){
           req.setAttribute("one",listSearch);
       }else {
           req.setAttribute("alert","Không tìm thấy");
       }
       RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteNote(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.iNoteServiceManager.removeNote(id);
        resp.sendRedirect("notes");
    }

    private void editNote(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int idType = Integer.parseInt(req.getParameter("idType"));
        this.iNoteServiceManager.editNote(id,title,content,idType);
        req.setAttribute("alert",alert_success);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createNote(HttpServletRequest req, HttpServletResponse resp) {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int idType = Integer.parseInt(req.getParameter("idType"));

        this.iNoteServiceManager.addNote(title,content,idType);
        req.setAttribute("alert",alert_success);

        List<NoteType> typeList = this.iNoteServiceManager.getAllType();
        req.setAttribute("typeList",typeList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}