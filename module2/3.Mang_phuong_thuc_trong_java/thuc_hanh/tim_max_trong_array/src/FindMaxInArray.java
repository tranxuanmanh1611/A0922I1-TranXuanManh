import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        System.out.println("Ứng dụng cho phép nhập vào và xep hang tài sản các tỉ phú");
        Scanner scanner = new Scanner(System.in);
        String[] nameList;
        int[] money;
        int size;
        do {
            System.out.println("Bạn muốn xếp hạng bao nhiêu tỉ phú?");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Không được quá 20 người");
            }
        } while (size > 20);

        nameList = new String[size];
        money = new int[size];

        for (int i = 0; i < nameList.length; i++) {
            System.out.println("Nhập tên người thứ "+(i+1));
            nameList[i] = scanner.nextLine();
        }
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập tổng tài sản của " + nameList[i]);
            money[i] = scanner.nextInt();
        }
        System.out.println("Đã thu tập xong, bắt đầu so sánh...");
        int index = 0;
        int max = money[0];
        for (int i = 1; i < size; i++) {

            if (money[i] > max) {
                max = money[i];
                index = i;
            }
        }
        System.out.println("Người giàu nhất trong danh sách là: " + nameList[index] + " với tổng tài sản là: " + max);

    }
}
