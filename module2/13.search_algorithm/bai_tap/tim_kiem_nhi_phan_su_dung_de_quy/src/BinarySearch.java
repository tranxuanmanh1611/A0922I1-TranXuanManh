import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

    public static void binarySearch(ArrayList<Integer> list, int low, int high,int needValue) {
        int mid = (low + high) / 2;
        if (high>=low) {
            if (needValue > list.get(mid)) {
                low = mid + 1;
                high = list.size() - 1;
                binarySearch(list, low, high,needValue);
            } else if (needValue < list.get(mid)) {
                low = 0;
                high = mid - 1;
                binarySearch(list, low, high,needValue);
            }else {
                System.out.println("giá trị cần tìm ở vị trí "+mid);
            }
            return;
        }
        System.out.println("Không tìm thấy");
    }
}
