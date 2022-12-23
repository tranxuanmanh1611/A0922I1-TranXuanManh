import java.util.Scanner;

public class PassStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhập vào số lượng sinh viên?");
            size = scanner.nextInt();
            if (size > 30) {
                System.out.println("Quá 30, nhập lại");
            }
        } while (size > 30);
        int[] score = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập điểm của sinh viên thứ " + (i + 1));
            score[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] >= 5 && score[i] <= 10) {
                count++;
            }
        }
        System.out.println("Lớp có " + count + " sinh viên thi pass");

    }
}
