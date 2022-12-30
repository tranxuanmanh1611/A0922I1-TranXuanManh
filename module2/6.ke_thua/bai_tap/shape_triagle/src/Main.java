import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1, side3, side2;
        boolean check;
        do {
            check = false;
            System.out.println("Nhập độ dài cạnh a");
            side1 = scanner.nextDouble();
            System.out.println("Nhập độ dài cạnh b");
            side2 = scanner.nextDouble();
            System.out.println("Nhập độ dài cạnh c");
            side3 = scanner.nextDouble();
            if (side3 + side1 > side2 && side3 + side2 > side1 && side1 + side2 > side3) {
                check = true;
            } else {
                System.out.println("Không thể tạo tam giác, nhập lại");
            }
        } while (!check);
        Triangle tri1 = new Triangle(side1,side2,side3);
        System.out.println(tri1.toString());

    }
    }




