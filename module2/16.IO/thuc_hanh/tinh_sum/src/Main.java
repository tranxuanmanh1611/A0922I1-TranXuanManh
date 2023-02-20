import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\codegym\\codegym\\module2\\16.IO\\thuc_hanh\\tinh_sum\\numbers.txt";
        WriteFile writeFile = new WriteFile();
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap vao");
        for (int i=0;i<5;i++){
            int num = sc.nextInt();
            writeFile.writeNumber(path,num);
        }
        sum.sum(ReadFile.readFileText(path));
    }
}
