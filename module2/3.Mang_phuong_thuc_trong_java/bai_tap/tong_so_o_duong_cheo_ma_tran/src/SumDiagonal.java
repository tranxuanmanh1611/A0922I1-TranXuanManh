import java.util.Scanner;

public class SumDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ứng dụng tính tổng các số nam trên đường chéo của ma trận vuông");
        System.out.println("Ma tran bao nhiêu hàng/cột?");
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập giá trị ở hàng " + (i + 1) + " cột " + (j + 1));
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Đã tạo xong");
        for (int i = 0; i < array.length; i++) {
            System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "    ");
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i == (array.length - 1 - j)) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Đã tính xong, tổng là: " + sum);
    }
}
