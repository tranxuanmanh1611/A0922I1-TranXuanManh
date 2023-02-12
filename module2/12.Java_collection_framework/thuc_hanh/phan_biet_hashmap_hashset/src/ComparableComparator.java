import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableComparator {
    public static void main(String[] args) {
        Student student1 = new Student("Manh",25,"Da Nang");
        Student student2 = new Student("Hue",25,"Ha Tinh");
        Student student3 = new Student("Hung",20,"Da Nang");
        Student student4 = new Student("Nhi", 15,"Da Nang");
        Student student5 = new Student("An",40,"Ha noi");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        System.out.println("trước sort");
        for (Student student : studentList  ){
            System.out.println(student.toString());
        }
        System.out.println("Sau sort theo name");
        Collections.sort(studentList);
        for (Student student : studentList  ){
            System.out.println(student.toString());
        }
        System.out.println("Sort theo age dùng đối tượng comparator");
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(studentList,ageComparator);
        for (Student student : studentList  ){
            System.out.println(student.toString());
        }
    }
}
