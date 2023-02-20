import java.util.List;

public class sum {
    public static void sum(List<Integer> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("Sum la: "+sum);
    }
}
