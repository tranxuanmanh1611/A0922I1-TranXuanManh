package model;

public class Book {
    private String id;
    private String name;
    private String author;
    private String descript;
    private int amount;

    public Book(String id, String name, String author, String descript, int amount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.descript = descript;
        this.amount = amount;
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
