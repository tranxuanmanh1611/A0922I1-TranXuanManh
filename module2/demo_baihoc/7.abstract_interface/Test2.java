package abstract_interface;

public class Test2 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        System.out.println(a.s1 + "|" + a.s2);
        System.out.println(b.s1 + "|" + b.s2);
        System.out.println(a.getS1() + "|" + b.getS1());
    }
}
