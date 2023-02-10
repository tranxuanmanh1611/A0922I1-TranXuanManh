package search;

public class Search {
    public static final int NOT_FOUND = -1;

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public static int binarySearch(int[] arr, int x) {
        int begin = 0, end = arr.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end)/2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return NOT_FOUND;
    }

    // xây dựng thuật toán nhị phân bằng đệ quy
    public static int binarySearchR(int[] arr, int x, int begin, int end) {
        int mid = (begin + end)/2;
        if (begin > end) return NOT_FOUND;
        if (arr[mid] == x) return mid;
        if (arr[mid] > x) return binarySearchR(arr, x, begin, mid - 1);
        return binarySearchR(arr, x, mid + 1, end);
    }
}
