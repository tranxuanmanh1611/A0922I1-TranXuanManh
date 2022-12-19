import java.util.Scanner;

public class PrintLower100Primes {

        public static void main(String[] args) {
            System.out.println("chương trình in ra số lượng số nguyên tố được xác định trước");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bạn muốn hiển thị các số nguyên tố đến giới hạn bao nhiêu?");
            int max = scanner.nextInt();
            int N = 2;

            while (N != max) {
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
                    System.out.println(N);
                }

                N++;
            }
        }
    }


