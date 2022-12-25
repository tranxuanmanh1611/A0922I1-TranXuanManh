import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chương trình tính nghiệm pt bậc 2 dạng ax2+bx+c=0");
        System.out.println("Nhập a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập c:");
        double c = scanner.nextDouble();
        QuadraticEquation equation1 = new QuadraticEquation(a, b, c);
       System.out.println(equation1.display());
       double delta = equation1.getDiscriminant();
       if (delta>=0){
           if (delta>0){
               System.out.println("2 nghiệm: "+equation1.getRoot1()+" | "+equation1.getRoot2());
           }else {
               System.out.println("2 nghiệm kép: "+equation1.getRoot1());
           }
       }else {
           System.out.println("Vô nghiệm");
       }
    }
}
