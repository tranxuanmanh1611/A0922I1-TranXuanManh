import java.util.Scanner;

public class FindMax {
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
        int max = array[0][0];
        int row = 0;
        int col = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        System.out.println("Giá trị max: " + max + " tại hàng " + row + " cột " + col);

    }
}

