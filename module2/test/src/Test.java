import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str;
        System.out.println("nhập vào 1 chuỗi ký tự bất kỳ: ");
        str = sc.nextLine();
        char characters='a';
        int count=0;
        for (int i = 0; i <str.length() ; i++) {
            if (str.charAt(i)==characters){
                count++;
            }
        }
        System.out.println("Số ký tự 'a' trong chuỗi là:"+count);

    }
}


