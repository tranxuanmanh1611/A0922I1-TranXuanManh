import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CreateRandomArray example = new CreateRandomArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào index bất kì");

        try {
            int index = sc.nextInt();


            int[] array = example.createRandomArray();


            System.out.println("Giá trị tại index " + index + " là " + array[index]);

        } catch (ArrayIndexOutOfBoundsException exception) {
            System.err.println("Giới hạn index từ 0-100");
        } catch (InputMismatchException inputMismatchException) {
            System.err.println("Phải là so nguyên");
        }
    }

}
