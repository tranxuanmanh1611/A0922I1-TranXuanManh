package abstract_interface;

public class A {
    public String s1 = "A.s1";
    public String s2 = "A.s2";

    public String getS1() {
        return s1;
    }
}
class B extends A {
    public String s1 = "B.s1";
    public String getS1() {
        return s1;
    }
}
