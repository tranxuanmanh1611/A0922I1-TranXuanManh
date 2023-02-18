public class SelectionSortTest {
    public static void main(String[] args) {
        double[] list={1, 9, 4.5, 6.6, 5.7, -4.5};
        list= SelectionSort.selectionSort(list);
        for (double element : list){
            System.out.println(element);
        }
    }
}
