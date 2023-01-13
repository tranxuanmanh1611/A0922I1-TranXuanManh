public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        for (int i = 0; i < 5; i++) {
            listInteger.add(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("element " + i +": "+ listInteger.get(i));
        }

        listInteger.get(6);
        System.out.println("element 11: " + listInteger.get(6));
    }
}
