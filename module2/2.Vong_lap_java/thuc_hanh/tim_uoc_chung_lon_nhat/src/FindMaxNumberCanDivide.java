import java.util.Scanner;

public class FindMaxNumberCanDivide {
    public static void main(String[] args) {
        System.out.println("Chương trình này tìm ước số chung lớn nhất của 2 số nhập vào");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số đầu tiên");
        int firstNum = scanner.nextInt();
        System.out.println("Nhập vào số thứ hai");
        int secondNum = scanner.nextInt();
        int bigger;
        int smaller;
        if (firstNum > secondNum) {
            bigger = firstNum;
            smaller = secondNum;
        } else {
            bigger = secondNum;
            smaller = firstNum;
        }
        if (secondNum == 0 || firstNum == 0) {
            System.out.println("Không có ước chung lớn nhất");
        } else {
            if (secondNum == firstNum) {
                System.out.println("Ước chung lớn nhất của hai số: " + firstNum + " và " + secondNum + " là " + firstNum);
            } else {
                for (int i = bigger; i > 0; i--) {
                    if (bigger % i == 0 && smaller % i == 0) {
                        System.out.println("Ước chung lớn nhất của hai số: " + firstNum + " và " + secondNum + " là " + i);
                        break;
                    }
                }
            }
        }
    }
}
