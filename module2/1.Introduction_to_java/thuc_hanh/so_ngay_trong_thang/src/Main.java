import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ban muon tinh ngay cua thang nao?");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("thang "+month+" co 31 ngay.");
                break;
            case 2:
                System.out.println("thang "+ month+ " co 28 hoac 29 ngay.");
                break;
            default:
                System.out.println("thang "+month+" co 30 ngay.");
        }
    }
}