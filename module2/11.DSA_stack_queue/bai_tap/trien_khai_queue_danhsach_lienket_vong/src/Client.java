public class Client {
    public static void main(String[] args){
      MyCircleLinkedListQueue<String> newQueue = new MyCircleLinkedListQueue<>();
      newQueue.enQueue("Danang");
      newQueue.enQueue("Hue");
      newQueue.enQueue("Quang Tri");
      newQueue.enQueue("Dong Ha");
      System.out.println("test enQueue");
      newQueue.displayQueue();

      System.out.println("test deQueue");
      newQueue.deQueue();
      newQueue.displayQueue();
      System.out.println("check cycle");
      System.out.println(newQueue.rear.link.data);
    }
}
