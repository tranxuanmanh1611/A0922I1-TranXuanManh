import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        System.out.println("Đây là ứng dụng vẽ hình từ menu cho trước");
        System.out.println("Menu");
        System.out.println("1. Vẽ hình chữ nhật");
        System.out.println("2. Vẽ tam giác vuông: góc vuông ở các vị trí: trên trái, trên phải, dưới trái, dưới phải");
        System.out.println("3. Vẽ tam giác cân");
        System.out.println("0. Thoát");
        Scanner scanner = new Scanner(System.in);
        int choice = 4;
        while (choice != 0) {
            System.out.println("Nhap số để vẽ hình tuơng ứng");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hình chữ nhật");
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 6; j++) {
                            System.out.print("**");
                            if (j == 6) {
                                System.out.println(" ");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("tam giác vuông góc trên trái");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 6 - i; j++) {
                            System.out.print("*");
                        }
                        System.out.println(" ");
                    }
                    System.out.println("tam giác vuông góc trên phải");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (j >= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println(" ");
                    }
                    System.out.println("tam giác vuông góc dưới trái");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5; j++) {
                            if (j <= i) {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("tam giác vuông góc dưới phải");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 5; j >= 1; j--) {
                            if (j <= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Tam giác cân");
                    for (int i = 1; i <= 6; i++) {

                        for (int j = 1; j <= 6; j++) {
                            if (i == 1 && j == 3) {
                                System.out.print("*");
                            } else {
                                System.out.print("");
                            }
                            if (i == 2 && j > 1 && j < 5) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                            if (i == 3 && j > 1 && j < 6) {
                                System.out.print("*");
                            }
                        }
                        System.out.println("");
                    }
            }
        }
    }
}
