import java.util.Scanner;
import java.util.Stack;

public class IntegerArray {
    private int size;
    private int[] newArray;

    IntegerArray() {
    }

    IntegerArray(int size) {
        newArray = new int[size];
    }

    public void inputElement() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println("Vui lòng nhập phần tử thứ " + (i + 1));
            newArray[i] = sc.nextInt();
            if (i == newArray.length - 1) {
                System.out.println("Đã tạo xong");
            }
        }
    }
    public void reverseArray(){
        Stack<Integer> newStack = new Stack<>();
        for (int element : newArray) {
            newStack.push(element);
        }
        for (int i=0;i< newArray.length;i++){
            newArray[i] = newStack.pop();
        }
    }

    public void display(){
        for (int element : newArray){
            System.out.print(element+"|");
        }
    }

}
