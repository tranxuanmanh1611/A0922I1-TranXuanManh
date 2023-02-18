import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhập vào 1 chuỗi");
        String str=sc.nextLine();
        LinkedList<Character> tempString = new LinkedList<>();
        LinkedList<Character> maxString = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (tempString.size()>0&&str.charAt(i)<=tempString.getLast()){

                tempString.clear();
            }
            tempString.add(str.charAt(i));
            if (maxString.size()<tempString.size()){
                maxString.clear();;
                maxString.addAll(tempString);
            }
        }
        for (Character character:maxString){
            System.out.print(character);
        }
    }
}
