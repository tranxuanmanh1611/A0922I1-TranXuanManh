public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("Testing...");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.add(1,10.5);
        ll.add(1,10.5);
        ll.printList();

    }
}
