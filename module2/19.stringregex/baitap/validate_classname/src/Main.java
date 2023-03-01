import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Nhập tên lớp: ");
        String className = scanner.nextLine();
        String regex = "^[CAP]\\d{4}[GHIKLM]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(className);
        while (!matcher.matches()){
            System.out.println("Sai định dạng, nhập lại: ");
            className = scanner.nextLine();
            matcher = pattern.matcher(className);
        }
        System.out.println("Tên lớp vừa nhập: "+ className);
    }
}
