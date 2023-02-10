package generic_stack_queue;

import java.util.Comparator;

public class MarkComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.mark == o2.mark) {
            return o1.id - o2.id;
        }
        return o1.mark > o2.mark ? -1 : 1;
    }
}
