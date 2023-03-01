import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in  );
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        String regex = "^[A-Za-z\\d]+[A-Za-z\\d]*@[A-Za-z\\d]+(\\.[A-Za-z\\d]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
      while (!matcher.matches()){
            System.out.println("Sai định dạng, nhap lai");
            email = sc.nextLine();
            matcher=pattern.matcher(email);
        }
        System.out.println("so sánh: "+matcher.matches());
        System.out.println("Email da tao: "+email);
    }
}
