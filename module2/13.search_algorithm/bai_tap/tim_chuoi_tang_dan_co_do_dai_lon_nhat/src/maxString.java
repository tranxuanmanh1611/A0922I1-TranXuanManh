import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maxString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi");
        String str =sc.nextLine();
        List<Character> max= new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            List<Character> stringList = new ArrayList<>();
            stringList.add(str.charAt(i));
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(j)>stringList.get(stringList.size()-1)){
                    stringList.add(str.charAt(j));
                }
            }
            if (stringList.size()>max.size()){
                max.clear();
                max.addAll(stringList);
            }
        }
        for (Character ch :max){
            System.out.print(ch);
        }
    }
}
