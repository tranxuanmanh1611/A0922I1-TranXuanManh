import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        System.out.println("chương trình tìm ra và xóa một phần tử neu có trong mảng số nguyên");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arrayNumber[i] = scanner.nextInt();
        }
        System.out.println("Bạn muon xóa phần tử nào?");
        int inputNum = scanner.nextInt();
        while (FindIndex(arrayNumber, inputNum) == -1) {
            System.out.println("Khong tim thay, nhap lại");
            inputNum = scanner.nextInt();
        }
        arrayNumber = DeleteNumber(arrayNumber, FindIndex(arrayNumber, inputNum));
        System.out.println("Dã xóa xong, mảng mới: ");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i] + "  ");
        }

    }

    public static int FindIndex(int[] arr, int inputNum) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == inputNum) {
                index = i;
            }
        }
        return index;
    }

    public static int[] DeleteNumber(int[] arr, int index) {
        int[] array = new int[arr.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i < index) {
                array[i] = arr[i];
            } else {
                array[i] = arr[i + 1];
            }
        }
        return array;
    }
}
