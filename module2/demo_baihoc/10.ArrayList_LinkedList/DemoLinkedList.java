package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();

        // array phải khai báo kích thước
        int[] arrInt = new int[5];

        integers.add(10);
        integers.add(2);
        integers.add(1,5);

        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
        System.out.println("=============");
        for (Integer n: integers) {
            System.out.println(n);
        }
        System.out.println("=============");
        integers.forEach(System.out::println);

    }
}
