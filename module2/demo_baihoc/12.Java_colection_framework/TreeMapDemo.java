package map_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new TreeMap<>();
        studentMap.put(1, new Student(1, "Nhi", 8));
        studentMap.put(14, new Student(14, "Hai", 6));
        studentMap.put(25, new Student(25, "Phuoc", 7));
        studentMap.put(22, new Student(22, "Nam", 7));
        studentMap.put(13, new Student(13, "Hoc", 9));

//        System.out.println(studentMap.get(3));
        // duyệt map có nhiều cách
        // cách 1 dùng entry
        for(Map.Entry entry: studentMap.entrySet()) {
           System.out.println(entry.getValue());
        }

        // cách 2 duyệt bằng list value từ map
//        for(Student st: studentMap.values()) {
//            System.out.println(st);
//        }

        // cách 3: duyệt thông qua list key
       // for (int key: studentMap.keySet()) {
       //     System.out.println(studentMap.get(key));
      //  }
    }
}
