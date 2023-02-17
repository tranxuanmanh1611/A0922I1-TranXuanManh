public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println(binarySearch(numbers,79));
        System.out.println(binarySearch(numbers,80));

    }

    static int binarySearch(int[] aList, int key) {
        int low = 0;
        int high = aList.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < aList[mid]) {
                high = mid - 1;
            } else if (key > aList[mid]) {
                low = mid + 1;
            } else if (key == aList[mid]) {
                return mid;
            }
        }
        return -1;
    }
}

