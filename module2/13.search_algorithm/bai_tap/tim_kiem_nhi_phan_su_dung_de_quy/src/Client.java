import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList<Integer> list =CreateAndSortArray.CreateArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn tìm giá tri nào?");
        int needValue = sc.nextInt();
        BinarySearch.binarySearch(list,0,list.size()-1,needValue);
    }
}
