package abstract_interface;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Cat();
        animals[3] = new Dog();

        for(Animal a: animals) {
            System.out.println(a.speak());
        }

        Parrot p = new Parrot();
        System.out.println(Parrot.SPEED);
    }
}
