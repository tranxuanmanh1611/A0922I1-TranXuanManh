import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ten ban la gi?");
        String name = scanner.nextLine();
        System.out.println("Xin chao "+name);
    }
}
