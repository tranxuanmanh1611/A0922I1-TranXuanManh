import java.util.*;

public class main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println("Hiển thị entry:");
        System.out.println(hashMap+" \n");

        TreeMap<String,Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("put entries in treemap" );
        System.out.println(treeMap);

        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("put in linkedHashMap"   );
        System.out.println(linkedHashMap);
        System.out.println("tuổi của Lewis là: "+linkedHashMap.get("Lewis"));
    }
}