public class GenericStackClient {
    public static void main(String[] args){
GenericStackClient.stackOfString();
    }
    private static void stackOfString(){
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("five");
        stack.push("four");
        stack.push("three");
        stack.push("two");
        stack.push("one");
        System.out.println("size stack sau khi push: "+stack.size());
        System.out.println("tiến hành pop...");
        while (stack.size()!=0){
            stack.pop();
        }
        System.out.println("size stack sau khi pop: "+stack.size());
    }
}
