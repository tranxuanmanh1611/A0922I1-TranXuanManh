import java.util.Stack;

public class BracketCheck {
    Stack<Character> bracketStack = new Stack<>();

    BracketCheck() {
    }

    public void check(String str) {
        boolean check = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 40) {
                bracketStack.push(str.charAt(i));
            }
            if (str.charAt(i) == 41) {
                if (bracketStack.isEmpty()) {
                    check = false;
                    break;
                }
                bracketStack.pop();
            }
        }
        if (check) {
            System.out.println("Well");
        } else {
            System.out.println("False");
        }
    }
}
