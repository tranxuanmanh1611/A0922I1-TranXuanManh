import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        System.out.println("chương trình tìm ra và xóa một phần tử (thực chất là ghi đè số 0) neu có trong mảng số nguyên");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arrayNumber[i] = scanner.nextInt();
        }
        System.out.println("Bạn muốn xóa phần tử nào?");

        int inputNum = scanner.nextInt();
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] == inputNum) {
                arrayNumber[i] = 0;

            }
        }
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] == 0) {
                for (int j = i; j < arrayNumber.length - 1; j++) {
                    int temp = 0;
                    temp = arrayNumber[j];
                    arrayNumber[j] = arrayNumber[j + 1];
                    arrayNumber[j + 1] = temp;
                }
            }

        }
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.println(arrayNumber[i]);
        }


    }
}
