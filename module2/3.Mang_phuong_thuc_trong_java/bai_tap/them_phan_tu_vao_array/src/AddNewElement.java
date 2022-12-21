import java.util.Scanner;

public class AddNewElement {
    public static void main(String[] args) {
        System.out.println("chương trình thêm vao mot phan tư vao mang");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arrayNumber[i] = scanner.nextInt();
        }
        System.out.println("đã tao xong");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i] + "  ");
        }
        System.out.println("Bạn muốn thêm phần tử nào?");
        int inputNum = scanner.nextInt();
        System.out.println("Bạn muốn thêm ở vị trí nào?");
        int index = scanner.nextInt();

        arrayNumber = AddElement(arrayNumber, inputNum, index);
        System.out.println("Đã thêm, mảng mới: ");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.println(arrayNumber[i] + "  ");
        }
    }

    public static int[] AddElement(int[] arr, int inputNum, int index) {
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = arr[i];
            } else if (i == index) {
                newArray[i] = inputNum;
            } else {
                newArray[i] = arr[i - 1];
            }
        }
        return newArray;
    }
}
