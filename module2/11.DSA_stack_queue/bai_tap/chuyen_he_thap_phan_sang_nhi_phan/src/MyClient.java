import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số");
        int number = sc.nextInt();
        Decimal.toBinary(number);
    }
}
