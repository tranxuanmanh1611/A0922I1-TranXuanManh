package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private String img;
    private int type_id;
    private int brand_id;
    private String type;
    private String brand;

    public Product(int id, String name, String description, String img, int type_id, int brand_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.type_id = type_id;
        this.brand_id = brand_id;
    }

    public Product(String name, String description, String img, int type_id, int brand_id) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.type_id = type_id;
        this.brand_id = brand_id;
    }

    public Product(int id, String name, String description, String img, String type, String brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.type = type;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

