import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args){
        System.out.println("Ứng dụng này tính tiền lãi cho vay, không áp dụng ghép lãi");
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập số tiền");
        double money = scanner.nextDouble();
        System.out.println("Nhập lãi suất(bao nhiêu %, lãi theo năm)");
        double interestRate = scanner.nextDouble();
        System.out.println("Nhập kì hạn(theo tháng)");
        int month =scanner.nextInt();
        double result=0;
for (int i=1;i<=month;i++){
    result += money*((interestRate/100)/12);
}
System.out.println("Số tiên gời vào: "+money+", lãi suất: "+interestRate+"%/năm, kỳ hạn: "+month+" tháng. Số tiền" +
        " lãi nhập được ước tính: "+result);
    }
}
