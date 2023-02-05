import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Bạn muốn làm gì?\n"
                    + "1.Tạo mảng số nguyên và đảo ngược\n"
                    + "2. Tạo chuỗi và đảo ngược\n"
                    + "3. exit\n");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Ban muốn tạo mảng bao nhiêu phần tử: ");
                int size = sc.nextInt();
                IntegerArray newArray = new IntegerArray(size);
                newArray.inputElement();
                newArray.reverseArray();
                newArray.display();
            }
            if (choice == 2){
                System.out.println("Vui lòng nhập chuỗi");
                String inputString = sc.next();
                StringArray newStringArray = new StringArray(inputString);
                newStringArray.reverseString();
            }
        } while (choice != 3);
    }
}
