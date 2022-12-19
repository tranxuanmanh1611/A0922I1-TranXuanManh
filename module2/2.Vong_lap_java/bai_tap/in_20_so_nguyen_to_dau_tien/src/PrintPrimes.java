import java.util.Scanner;

public class PrintPrimes {
    public static void main(String[] args) {
        System.out.println("chương trình in ra số lượng số nguyên tố được xác định trước");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn hiển thị bao nhiêu số nguyên tố đầu tien?");
        int numbers = scanner.nextInt();
        int count = 0;
        int N = 2;

        while (count != numbers) {
            boolean check = true;
            if (N > 2) {
                for (int i = 2; i < N; i++) {
                    if (N % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                count++;
                System.out.println(N);
            }

            N++;
        }
    }
}
