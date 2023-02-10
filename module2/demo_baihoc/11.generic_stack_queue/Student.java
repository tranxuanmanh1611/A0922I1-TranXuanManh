package generic_stack_queue;

public class Student implements Comparable<Student> {
    public int id;
    public String name;
    public float mark;

    public Student() {
    }

    public Student(int id, String name, float mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return o.id - this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
