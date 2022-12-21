import java.util.Scanner;

public class CombineArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber1 = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arrayNumber1[i] = scanner.nextInt();
        }
        System.out.println("tạo xong mảng 1");
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size2 = scanner.nextInt();
        int[] arrayNumber2 = new int[size];
        for (int i = 0; i < size2; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arrayNumber2[i] = scanner.nextInt();
        }
        System.out.println("tạo xong mảng 2");
        int[] arrayNumber3 = new int[arrayNumber1.length + arrayNumber2.length];
        for (int i = 0; i < arrayNumber3.length; i++) {
            if (i <= arrayNumber1.length - 1) {
                arrayNumber3[i] = arrayNumber1[i];
            } else {
                arrayNumber3[i] = arrayNumber2[i - arrayNumber1.length];
            }
        }
        for (int i=0;i<arrayNumber3.length;i++){
            System.out.print(arrayNumber3[i]+"  ");
        }
    }
}
