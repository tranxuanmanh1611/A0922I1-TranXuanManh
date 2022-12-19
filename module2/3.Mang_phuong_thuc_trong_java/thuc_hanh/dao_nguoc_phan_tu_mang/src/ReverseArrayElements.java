import java.util.Scanner;

public class ReverseArrayElements {
    public static void main(String[] args){
        System.out.println("Chương trình này đảo ngược phần tử của một mảng số nguyên không quá 20 phần tử");
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Bạn muốn tạo mảng có bao nhiêu phần tử?");
             size = scanner.nextInt();
            if (size>20){
                System.out.println("Không được nhập quá 20 phần tử");
            }else {
                System.out.println("Bạn đã tạo thành công mảng "+size+" phần tử.");
            }
        }while (size>20);
        int[] array;
        array= new int[size];
        for (int i=0;i<array.length;i++){
            System.out.println("Nhập vào phần tử thứ "+(i+1)+" của mảng");
            array[i]= scanner.nextInt();
        }
        System.out.println("Đã tạo thành công mảng "+array.length+" phần tử: ");
        for (int j : array) {
            System.out.print(j + "  ");
        }
        System.out.println("Bat đầu đảo ngược các phần tử...");
        for (int i=0;i<array.length/2;i++){
            int temp = array[i];
            array[i]=array[size-1-i];
            array[size-1-i]=temp;
        }
        System.out.println("Đã đảo ngược xong: ");
        for (int i: array){
            System.out.print(i+"  ");
        }
    }
}
