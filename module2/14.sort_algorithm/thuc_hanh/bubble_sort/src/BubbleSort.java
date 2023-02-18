public class BubbleSort {
    public static int[] BubbleSort(int[] list) {
        boolean needSort =true;
        for (int j = 0; j < list.length&&needSort; j++) {
            needSort=false;
            for (int i = list.length - 1; i > 0; i--) {
                if (list[i] < list[i - 1]) {
                    int temp = list[i];
                    list[i] = list[i - 1];
                    list[i - 1] = temp;
                    needSort=true;
                }
            }

            for (Integer element:list){
                System.out.print(element);
            }
            System.out.println("");
        }
        return list;
    }
}
