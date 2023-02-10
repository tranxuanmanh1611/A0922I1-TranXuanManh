import java.util.Stack;

public class Decimal {
    public static void toBinary(int number) throws Exception {
        Stack<Integer> myNumberStack = new Stack<>();
        if (number >= 0) {
            if (number == 0 || number == 1) {
                System.out.println("Số " + number + " chuyển sang hệ nhị phân là " + number);
            } else {
                do {
                    myNumberStack.push(number % 2);
                    number = (number - (number % 2)) / 2;
                    if (number == 1) {
                        myNumberStack.push(1);
                    }
                } while (number != 1);
                while (!myNumberStack.isEmpty()) {
                    System.out.print(myNumberStack.pop());
                }
            }

        } else {
            throw new Exception("Khó quá không biết chuyển hệ thập phan số âm");
        }
    }
}
