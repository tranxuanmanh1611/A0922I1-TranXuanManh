package inheritance;

public class Test {
    public static void main(String[] args) {
        Person st1 = new Student();
        Person st2 = new Student("A0922I1");
        Person st3 = new Student("Hoài Nam", 20, "Đà Nẵng", "A0922I1");

        System.out.println(st1.showInfo());
        System.out.println(st2.showInfo());
        System.out.println(st3.showInfo());

        MathUtils mathUtils = new MathUtils();
        mathUtils.cong(2, 5);
        mathUtils.cong(5f, 8.9f);
        mathUtils.cong(4,6,7);

    }
}
