package search;

import java.util.Arrays;

public class TestSearch {

    public static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int [] arr = {5, 9, 10, 29, 18, 4, 3, 21};
//        int index = Search.linearSearch(arr, 14);
        // sort mảng trước khi sắp xếp nhị phân
        Arrays.sort(arr);
//        int index = Search.binarySearch(arr, 11);
        int index = Search.binarySearchR(arr, 18, 0, arr.length - 1);
        if (index != NOT_FOUND) {
            System.out.println("Index cua gia tri can tim la: " + index);
        } else {
            System.out.println("Khong tim thay gia tri can tim trong mang");
        }
    }
}
