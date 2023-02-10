package inheritance;

public class Person {
    public String name;
    public int age;
    public String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String showInfo() {
        return "Name: " + name + "| Age: " + age + "| Address: " + address;
    }

    public Person getClone() {
        return this;
    }

    private void showMe() {

    }
}
