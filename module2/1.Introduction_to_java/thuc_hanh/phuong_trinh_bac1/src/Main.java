import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ung dung giai phuong trinh bac 1");
        System.out.println("Phuong trinh co dang aX + b = c, hay nhap cac he so");
        double a;
        double b;
        double c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap so a: ");
        a = scanner.nextDouble();
        System.out.println("nhap so b: ");
        b = scanner.nextDouble();
        System.out.println("nhap so c: ");
        c = scanner.nextDouble();
        if (a != 0) {
            double x = (c - b) / a;
            System.out.println("nghiem cua phuong trinh nay la: " + x);
        } else  {
            if (b != c) {
                System.out.println("phuong trinh vo nghiem");
            } else {
                System.out.println("phuong trinh co vo so nghiem");
            }
        }
    }
}