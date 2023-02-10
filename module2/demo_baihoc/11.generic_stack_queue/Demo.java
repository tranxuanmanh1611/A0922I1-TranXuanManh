package generic_stack_queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student(4, "Nhi", 9f);
        Student s2 = new Student(3, "Nam", 8.5f);
        if (s1.compareTo(s2) > 0) {
            System.out.println("s1 > s2");
        } else if (s1.compareTo(s2) == 0) {
            System.out.println("s1 = s2");
        } else {
            System.out.println("s1 < s2");
        }

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(new Student(1, "Thang", 7f));
        students.add(new Student(9, "Hoang", 7f));
        students.add(new Student(2, "Anh", 8f));
        students.add(new Student(5, "Khang", 9.5f));

        students.forEach(System.out::println);
        System.out.println("List sau khi sắp xếp theo id");
        Collections.sort(students);
        students.forEach(System.out::println);
        System.out.println("List sau khi sắp xếp theo tên");
        Collections.sort(students, new NameComparator());
        students.forEach(System.out::println);
        System.out.println("List sau khi sắp xếp theo điểm");
        Collections.sort(students, new MarkComparator());
        students.forEach(System.out::println);
    }
}
