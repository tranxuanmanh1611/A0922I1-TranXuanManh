import java.util.Scanner;

public class DrawMenu {
    public static void  main (String[] args){
        System.out.println("Đây là ứng dụng vẽ hình từ menu cho trước");
        System.out.println("Menu");
        System.out.println("1. Vẽ tam giac");
        System.out.println("2. Vẽ hình vuông");
        System.out.println("3. Vẽ hình chữ nhật");
        System.out.println("0. Thoát");
        Scanner scanner = new Scanner(System.in);
        int choice=4;
        while (choice!=0){
            System.out.println("Nhập số tương ứng với hinh muốn vẽ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Hình tam giac");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    System.out.println("xong");
                    break;
                case 2:
                    System.out.println("Hình vuông");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("xong");
                    break;
                case 3:
                    System.out.println("Hình chữ nhật");
                    System.out.println("* * * * * * * * * *");
                    System.out.println("* * * * * * * * * *");
                    System.out.println("* * * * * * * * * *");
                    System.out.println("* * * * * * * * * *");
                    System.out.println("* * * * * * * * * *");
                    System.out.println("xong");
                    break;
                case 0:
                    System.out.println("Đã thoát");
            }
        }
    }
}
