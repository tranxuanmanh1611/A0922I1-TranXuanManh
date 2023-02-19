import java.util.LinkedList;
import java.util.Scanner;

public class Test {
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
        array=InsertionSort(array);
        System.out.println("Đã sort xong mảng:");
        for (Integer element:array){
            System.out.print(element+" ");
        }
    }
    public static int[] InsertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i]; //biến temp để đổi chỗ
            int position = i;

            while (position > 0) {
                if (list[position] < list[position - 1]) {
                    list[position] = list[position - 1];
                    list[position - 1] = temp;
                }
                position--; //tiếp tục lùi position về trước để so snh với giá trị list[i]
            }
        }
        return list;
    }
}


