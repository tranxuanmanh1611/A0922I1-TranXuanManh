package model;

public class Note {
    private int id;
    private String title;
    private String content;
    private int idType;
    private String type;

    public Note() {
    }

    public Note(String title) {
        this.title = title;
    }

    public Note(int id, String title, String content, int idType) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note(int id, String title, String content, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
