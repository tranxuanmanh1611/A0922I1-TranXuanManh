import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CreateAndSortArray {
    public static ArrayList<Integer> CreateArray(){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc =new Scanner(System.in);
        System.out.println("Bạn muốn nhập mảng bao nhiêu phần tử?");
        int size = sc.nextInt();
        for (int i =0;i<size;i++){
            System.out.println("Nhập phần tử thứ "+(i+1));
            int inputNumber =sc.nextInt();
            list.add(inputNumber);
        }
        System.out.println("tạo xong");
        Collections.sort(list);
        System.out.println("sort xong");
        return list;
    }
}
