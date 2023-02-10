package inheritance;

public class Student extends Person {
    public String className;

    public Student() {
    }

    public Student(String className) {
        this.className = className;
    }

    public Student(String name, int age, String address, String className) {
        super(name, age, address);
        this.className = className;
    }

    public String showInfo() {
        return super.showInfo() + "| Class name: " + className;
    }

    public Student getClone() {
        return this;
    }

    public void showMe(){

    }
}
