package service;

import model.Note;
import model.NoteType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class iNoteServiceManager implements iNoteService {
    public static final String INSERT_NOTE = "INSERT INTO note(title,content,type_id) VALUES (?,?,?)";
    public static final String GET_ALL_NOTES_DESC = "SELECT note.id,note.title,note.content,note_type.name FROM note LEFT JOIN note_type ON note.type_id=note_type.id ORDER BY note.id DESC";
    public static final String EDIT_NOTE = "UPDATE note SET title=?, content=?,type_id=? WHERE id =?";

    public static final String GET_NOTE_BY_ID = "SELECT note.id,note.title,note.content,note_type.name FROM note LEFT JOIN note_type ON note.type_id=note_type.id WHERE note.id=?";
    public static final String DELETE_NOTE = "DELETE FROM note WHERE id = ?";
    public static final String SEARCH_NOTES = "SELECT id FROM note WHERE title LIKE ? OR content LIKE ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/inote?useSSL=false";
    private String jdbcUserName = "root";


    private String jdbcPassword = "123456789";

    public iNoteServiceManager() {
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public List<Note> getAllNote() {
        List<Note> noteList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_NOTES_DESC)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("note.id");
                String title = rs.getString("note.title");
                String content = rs.getString("note.content");
                String type = rs.getString("note_type.name");
                noteList.add(new Note(id, title, content, type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return noteList;
    }


    public Note getNoteById(int id) {
        Note note = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(GET_NOTE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("note.title");
                String content = rs.getString("note.content");
                String type = rs.getString("note_type.name");
                note = new Note(id, title, content, type);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return note;
    }

    @Override
    public void addNote(String title, String content, int idType) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTE)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, idType);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editNote(int id, String title, String content, int idType) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(EDIT_NOTE)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, idType);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeNote(int id) {
        boolean isRemoved = false;
        try(Connection connection =getConnection();PreparedStatement preparedStatement=connection.prepareStatement(DELETE_NOTE)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Note> searchNote(String keyword) {
        List<Note> listNote = new ArrayList<>();
        String keyword1 = keyword;
        String keyword2 = keyword;
       try(Connection connection = getConnection();PreparedStatement preparedStatement =connection.prepareStatement(SEARCH_NOTES)){
           preparedStatement.setString(1,"%" + keyword1 + "%");
           preparedStatement.setString(2,"%" + keyword2 + "%");
           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()){
               listNote.add(getNoteById(rs.getInt("id")));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return listNote;
    }

    public List<NoteType> getAllType() {
        List<NoteType> typeList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("select id,name from note_type group by 1")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("name");
                typeList.add(new NoteType(id, type));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeList;
    }
}
