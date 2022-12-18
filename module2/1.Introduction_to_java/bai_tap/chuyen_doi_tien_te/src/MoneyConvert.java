import java.util.Scanner;

public class MoneyConvert {
    public static void  main (String[] args){
        System.out.println("Đây là ứng dụng chuyển ti giá từ USD sang Việt Nam");
        int rate = 23000;
        System.out.println("Nhập số tiền USD?");
        Scanner scanner = new Scanner(System.in);
        double usd = scanner.nextDouble();
        double vnd = usd*rate;
        System.out.println("USD: "+usd+", VND: "+vnd);
    }
}
