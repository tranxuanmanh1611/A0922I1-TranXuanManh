import java.util.Scanner;

public class InsertionSortTest {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Bạn muốn tạo mảng bao nhiêu phần tử");
        int size = sc.nextInt();
        int[] array= new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử");
            array[i]=sc.nextInt();
        }
        System.out.println("Đã tạo xong mảng:");
        for (Integer element:array){
            System.out.print(element+" ");
        }
        System.out.println("Đang sort...");
        array=InsertionSort.InsertionSort(array);
        System.out.println("Đã sort xong mảng:");
        for (Integer element:array){
            System.out.print(element+" ");
        }
    }
}
