import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap nam ban muon kiem tra?");
        int year = scanner.nextInt();
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println("Nam " + year + " la nam nhuan.");
            } else {
                if (year % 400 == 0) {
                    System.out.println("Nam " + year + " la nam nhuan.");
                } else {
                    System.out.println("Nam " + year + " khong phai la nam nhuan.");
                }
            }
        } else {
            System.out.println("Nam " + year + " khong phai la nam nhuan.");
        }
    }
}