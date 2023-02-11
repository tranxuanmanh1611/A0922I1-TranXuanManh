import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    Palindrome() {
    }
    public void check(String str) {
        Stack<Character> myStringStack = new Stack<>();
        Queue<Character> myStringQueue = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            myStringStack.push(str.charAt(i));
            myStringQueue.add((str.charAt(i)));
        }
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            if (myStringQueue.remove() != myStringStack.pop()) {
                check = false;
            }
        }
        if (check) {
            System.out.println("Chuỗi nhập vào là Palindrome");
        } else {
            System.out.println("Chuỗi nhập vào không phải là Palindrome");
        }
    }
}
