import javafx.scene.transform.Scale;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class CountSymbol {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String str ="abcdxyzabcdaa";
        System.out.println("Nhập vao kí tự muốn đếm");
        char input = scanner.next().charAt(0);
        int count =0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==input){
                count++;
            }
        }
        System.out.println("Xuất hiện "+count+" lần");
    }
}
