public class InsertionSort {
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
