import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu rong: ");
        width = scanner.nextFloat();
        System.out.println("Nhap chieu dai: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("dien tich hinh chu nhat la: " + area);
    }
}