import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        System.out.println("chương trình tìm ra giá trị min trong mảng số nguyên");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhap vao gia tri thu " + (i + 1));
            arrayNumber[i] = scanner.nextInt();
        }
        System.out.println("Gia trị nhỏ nhất trong mảng vừa tạo là " + arrayNumber[findMin(arrayNumber)] + " tại vi tri "
                + findMin(arrayNumber));
    }

    public static int findMin(int[] arr) {
        int index = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                index = i;
            }
        }
        return index;
    }
}
