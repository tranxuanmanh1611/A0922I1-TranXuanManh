import java.util.Map;

public class TreeMap {
    public static void main(String[] args) {
        String newString = "abcabcaefgh";
        Map<Character, KyTuXuatHien> newTreeMap = new java.util.TreeMap<>();
        for (int i = 0; i < newString.length(); i++) {
            if (!newTreeMap.containsKey(newString.charAt(i))) {
                newTreeMap.put(newString.charAt(i), new KyTuXuatHien(newString.charAt(i)));
            } else {
                (newTreeMap.get(newString.charAt(i))).addCount();
            }
        }
    /*    for (Map.Entry entry : newTreeMap.entrySet() ){
            System.out.println(entry);
        }*/
    /*    for (KyTuXuatHien kytu : newTreeMap.values()){
            System.out.println(kytu);
        }*/
    }
}
