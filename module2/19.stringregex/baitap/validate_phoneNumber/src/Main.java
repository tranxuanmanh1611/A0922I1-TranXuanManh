import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = sc.nextLine();
        String regex = "\\(\\d{2}\\)-\\(0\\d{9}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        while (!matcher.matches()){
            System.out.println("Sai định dạng, nhập lại: ");
            phoneNumber = sc.nextLine();
            matcher = pattern.matcher(phoneNumber);
        }
        System.out.println("Số điện thoại đã nhập: "+phoneNumber);
    }
}
