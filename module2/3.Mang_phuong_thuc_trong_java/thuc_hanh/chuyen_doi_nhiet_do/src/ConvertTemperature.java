import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        System.out.println("chương trình chuyển đổi độ C sang F hoặc ngược lại");
        Scanner scanner = new Scanner(System.in);
        int choice = 3;
        System.out.println("nhập 1: Chuyển độ F sang C");
        System.out.println("nhập 2: Chuyển độ C sang F");
        System.out.println("nhập 0: Thoát");
        while (choice != 0) {
            System.out.println("Bạn muốn làm gì?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào độ F");
                    double f = scanner.nextDouble();
                    System.out.println(f + " độ F tương ứng với " + faraheitToCelcius(f) + " độ C");
                    break;
                case 2:
                    System.out.println("Nhập vào độ C");
                    double c = scanner.nextDouble();
                    System.out.println(c + " độ C tương ứng với " + celciusToFaraheit(c) + " độ F");
                    break;
            }
        }
    }

    public static double faraheitToCelcius(double faraheit) {
        double celcius = (5.0 / 9) * (faraheit - 32);
        return celcius;
    }

    public static double celciusToFaraheit(double celcius) {
        double faraheit = (9.0 / 5) * celcius + 32;
        return faraheit;
    }
}
