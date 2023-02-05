import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<person> personList = new ArrayList<>();
        person person1 = new person("Manh",24);
        person person2 = new person("Hue",24);
        personList.add(person1);
        personList.add(person2);
        System.out.println(personList.toString());
    }
}


