import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap ky tu: ");
        String character = sc.nextLine();
        for (int i = 0; i < 10; i++) {
            System.out.println(character);
        }
    }
}
