import java.util.Scanner;

public class CheckNumber {
    public static void main(String[] args) {
        System.out.println("Chương trình này kiểm tra số nhập vao có phai là một số nguyên to hay không");
        System.out.println("Nhập vào một số?");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean check = true;
        if (number < 2) {
            check = false;
        }
        if (number > 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println(number + " là số nguyên tố");
        } else {
            System.out.println(number + " không phải là số nguyên tố");
        }
    }
}
