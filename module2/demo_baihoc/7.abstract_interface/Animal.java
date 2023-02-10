package abstract_interface;

public abstract class Animal {
    private String name;
    public String getInfoAnimal() {
        return "Name: " + name;
    }

    public abstract String speak();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
