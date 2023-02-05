import java.util.Scanner;
import java.util.Stack;

public class StringArray {
    private String data;
    Scanner sc = new Scanner(System.in);

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    StringArray() {
    }

    StringArray(String data) {
        setData(data);
    }

    public void reverseString() {
        String newData = "";
        Stack<Character> newStringStack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            newStringStack.push(data.charAt(i));
        }
        for (int i = 0; i < data.length(); i++) {
            newData += newStringStack.pop();
        }
        System.out.println("kết quả:" + newData);
    }
}
