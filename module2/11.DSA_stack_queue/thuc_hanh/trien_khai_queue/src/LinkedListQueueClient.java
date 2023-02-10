public class LinkedListQueueClient {
    public static void main(String[] args){
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(30);
        queue.enQueue(40);
        queue.enQueue(50);
        System.out.println("Dequeued item is " + queue.deQueue().key);
    }

}
