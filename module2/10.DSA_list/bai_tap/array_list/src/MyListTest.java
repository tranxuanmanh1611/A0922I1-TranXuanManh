public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> intList = new MyList<>();
        intList.add(0, 1);
        intList.add(1, 2);
        intList.add(2, 1);
        intList.add(3, 3);
        intList.add(4, 3);
        intList.add(1, 12);
        intList.add(5);
        intList.clear();
        System.out.println("test contains");
        System.out.println(intList.contains(4));
        System.out.println("test indexOf");
        System.out.println(intList.indexOf(3));
        System.out.println("test add");
        for (int i = 0; i < intList.getSize(); i++) {
            System.out.println(intList.get(i));
        }
        System.out.println(intList.getSize());
    }
}
