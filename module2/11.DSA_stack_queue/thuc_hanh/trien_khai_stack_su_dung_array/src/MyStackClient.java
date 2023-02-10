public class MyStackClient {
    public static void main(String[] args) throws Exception {
        MyStack intList = new MyStack(5);
        intList.push(1);
        intList.push(2);
        intList.push(3);
        intList.push(4);
        intList.push(5);
        System.out.println(intList.isFull() + "|" + intList.isEmpty());
        System.out.println("after push");
        for (int i = 0; i < intList.index; i++) {
            System.out.println(intList.arr[i]);
        }
        intList.pop();
        System.out.println("after pop");
        for (int i = 0; i < intList.index; i++) {
            System.out.println(intList.arr[i]);
        }
        System.out.println("exception");
        for (int i = 0; i < 5; i++) {
            intList.pop();
        }
    }
}
