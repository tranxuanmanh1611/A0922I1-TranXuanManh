public class Sort {
    public class SortUtils {
        public void bubbleSort(int[] arr) {
            boolean isSorted = false;
            for (int i = arr.length - 1; i >= 0; i--) {
                isSorted = true;
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSorted = false;
                    }
                }

                if (isSorted) {
                    break;
                }
            }
        }

        public void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[minIndex] > arr[j]) {
                        minIndex = j;
                    }
                }

                if (i != minIndex) {
                    int temp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = temp;
                }
            }
        }

        public void insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
