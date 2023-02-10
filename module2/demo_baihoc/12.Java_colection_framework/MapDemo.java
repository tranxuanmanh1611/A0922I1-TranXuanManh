package map_tree;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "Nhi", 8));
        studentMap.put(3, new Student(3, "Nam", 7));
        studentMap.put(2, new Student(2, "Hoc", 9));
        studentMap.put(5, new Student(5, "Hai", 6));
        studentMap.put(4, new Student(4, "Phuoc", 7));

//        System.out.println(studentMap.get(3));
        // duyệt map có nhiều cách
        // cách 1 dùng entry
//        for(Map.Entry entry: studentMap.entrySet()) {
//            System.out.println(entry.getValue());
//        }

        // cách 2 duyệt bằng list value từ map
//        for(Student st: studentMap.values()) {
//            System.out.println(st);
//        }

        // cách 3: duyệt thông qua list key
        for (int key: studentMap.keySet()) {
            System.out.println(studentMap.get(key));
        }
    }
}
