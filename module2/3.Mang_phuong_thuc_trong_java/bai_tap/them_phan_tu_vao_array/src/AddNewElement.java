import java.util.Scanner;

public class AddNewElement {
    public static void main(String[] args) {
        System.out.println("chương trình thêm vao mot phan tư vao mang");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng dài bao nhiêu?");
        int size = scanner.nextInt();
        int[] arrayNumber = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1) + ", nếu chưa muon nhập hãy để giá trị 0");
            arrayNumber[i] = scanner.nextInt();
        }
        System.out.println("đã tao xong");
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i] + "  ");

        }
        boolean check = false;
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] == 0) {
                check = true;
                break;
            }
        }

        System.out.println("Bạn muốn thêm giá trị nào?");
        int inputNum = scanner.nextInt();
        if (check) {
            System.out.println("Bạn muốn thêm nó ở index nào?");
            int index = scanner.nextInt();
            while (index < 0 || index > arrayNumber.length - 1) {
                System.out.println("Nhập lại");
                index = scanner.nextInt();
            }
            if (arrayNumber[index] == 0) {
                arrayNumber[index] = inputNum;
            } else {
                for (int i = index; i < arrayNumber.length; i++) {
                    int temp = arrayNumber[i + 1];
                    arrayNumber[i + 1] = arrayNumber[i];
                }
            }
        } else {
            System.out.println("Mảng không còn chỗ");
        }
        for (int i = 0; i < arrayNumber.length; i++) {
            System.out.print(arrayNumber[i] + "  ");
        }
    }
}
