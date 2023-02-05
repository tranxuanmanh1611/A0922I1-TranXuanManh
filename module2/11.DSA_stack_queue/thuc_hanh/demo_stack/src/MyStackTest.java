import java.sql.SQLOutput;
import java.util.Stack ;
public class MyStackTest {
    public static void main(String[] args){
        Stack<String> MyStack1 = new Stack<>();
        MyStack1.push("Tran");
        MyStack1.push("Xuan");
        MyStack1.push("Manh");
        System.out.println("test peek");
        System.out.println(MyStack1.peek());
        System.out.println("test pop");
        while (!MyStack1.isEmpty()){
            System.out.println(MyStack1.pop());
        }

    }
}
