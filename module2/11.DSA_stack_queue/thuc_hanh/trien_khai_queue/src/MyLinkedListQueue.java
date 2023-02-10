public class MyLinkedListQueue {
    public Node head;
    public Node tail;

    MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    public void enQueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    public Node deQueue() {

        if (this.head == null) {
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return temp;
    }


    public class Node {
        public int key;
        public Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
}
