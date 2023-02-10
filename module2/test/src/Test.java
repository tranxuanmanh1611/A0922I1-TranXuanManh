import java.util.*;

public class Test {
    public static void main(String[] args) {
      /* List<person> personList = new ArrayList<>();
        person person1 = new person("Manh",24);
        person person2 = new person("Hue",24);
        personList.add(person1);
        personList.add(person2);
        System.out.println(personList);*/
        /*Set<String> cities = new HashSet<>();
        cities.add("Danang");
        cities.add("");
        cities.add("Hue");
        cities.add("Quangtri");

        ListIterator<String> iteratorCities = cities.listIterator();
        while (iteratorCities.hasNext()) {
            System.out.println(iteratorCities.next());
        }*/
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco"); set.add("Beijing");
                set.add("NewYork");
        System.out.println(set);
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }
    }
}


