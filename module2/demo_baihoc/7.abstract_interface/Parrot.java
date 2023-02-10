package abstract_interface;

public class Parrot extends Bird {
    @Override
    public String speak() {
        return null;
    }

    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
