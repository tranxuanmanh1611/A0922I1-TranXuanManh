import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double weight,height,bmi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap can nang?");
        weight = scanner.nextDouble();
        System.out.println("Nhap chieu cao?");
        height = scanner.nextDouble();
        bmi = weight/Math.pow(height,2);
        if(bmi<18){
            System.out.println("Underweight");
        } else if(bmi<25){
            System.out.println("Normal");
        }else if(bmi <30){
            System.out.println("Overweight");
        }else {
            System.out.println("Obese");
        }
    }
}