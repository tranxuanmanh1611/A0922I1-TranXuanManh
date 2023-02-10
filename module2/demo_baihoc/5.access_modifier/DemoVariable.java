package access_modifier;

public class DemoVariable {
    int i = 0;
    static int a;

    public static void main(String[] args) {
        int i = 2;
        System.out.println(i);
        int m = 0;
//        for (int j = 0; j < 10; j++) {
////            int m = 1;
//            System.out.println(m);
//        }
        float b;
        System.out.println(a);
//        System.out.println(b);
    }

    public void method() {
        int i = 3;
        System.out.println(this.i);
    }
}
