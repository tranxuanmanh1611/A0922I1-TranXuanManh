import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài:");
        double w = scanner.nextDouble();
        System.out.println("Nhập chiều rộng:");
        double h = scanner.nextDouble();
        Rectangle rec1 = new Rectangle(w, h);
        System.out.println(rec1.display());
        System.out.println("Diện tích: " + rec1.getArea() + " | chu vi: " + rec1.getPerimeter());

    }
}
