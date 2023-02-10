package inheritance;

public class Test2 {
    public static void main(String[] args) {
        Person p1 = new Student();
        Person p2 = new Teacher();


        Student s1 = (Student)p1;
        if (p2 instanceof Student) {
            Student s2 = (Student) p2;
        }
    }
}
