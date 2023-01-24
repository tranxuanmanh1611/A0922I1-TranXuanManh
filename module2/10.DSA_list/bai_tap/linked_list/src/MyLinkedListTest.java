public class MyLinkedListTest {
    public static void main(String[] args){
        MyLinkedList<Integer> linkedListInteger = new MyLinkedList<>(2);
linkedListInteger.add(0,1);
linkedListInteger.add(5,4);
        linkedListInteger.add(2,3);
linkedListInteger.printList();
        System.out.println("numNodes: "+linkedListInteger.size());
        System.out.println("test get");
        System.out.println(linkedListInteger.get(1));
        System.out.println("test remove an element");
        linkedListInteger.removeElement(1);
        System.out.println("print list");
        linkedListInteger.printList();
        System.out.println("numNodes: "+linkedListInteger.size());
        System.out.println("test contains");
        System.out.println(linkedListInteger.contains(1));
        System.out.println(linkedListInteger.contains(2));
        System.out.println("test indexOf");
            System.out.println(linkedListInteger.indexOf(1));
        System.out.println(linkedListInteger.indexOf(2));

    }
}
