import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài cạnh 1");
        double a = sc.nextDouble();
        System.out.println("Nhập độ dài cạnh 2");
        double b = sc.nextDouble();
        System.out.println("Nhập độ dài cạnh 3");
        double c = sc.nextDouble();
        try {
            Triangle triangle = new Triangle(a, b, c);
        } catch (TriangleException triangleException) {
            triangleException.printStackTrace();
        }finally {
            System.out.println("DONE");
        }
    }
}
