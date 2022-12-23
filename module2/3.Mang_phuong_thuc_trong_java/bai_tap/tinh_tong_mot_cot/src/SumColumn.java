import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ma trận bao nhiêu hàng?");
        int r = scanner.nextInt();
        System.out.println("Ma trận bao nhiêu cột?");
        int c = scanner.nextInt();
        int[][] array = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("Nhập giá trị tại hàng " + (i + 1) + " cột " + (j + 1));
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Đã tạo xong");
        for (int i = 0; i < array.length; i++) {
            System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "   ");
            }
        }
        System.out.println("Bạn muốn tính tổng cột nào?");
        int choice = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == choice - 1) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("Đã tính xong, tổng cột " + choice + " bằng " + sum);
    }
}
