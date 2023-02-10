public class MyQueueClient {
    public static void main(String[] args) {
        MyQueue intList = new MyQueue(5);
        System.out.println("test đợt 1");
        for (int i =1;i<6;i++)  {
            intList.enQueue(i);
        }
        for (int i =0;i<intList.currentSize;i++){
            System.out.println(intList.queueArr[i]);
        }
        for (int i = 0; i < 6; i++) {
            intList.deQueue();}
        System.out.println(intList.front+"|"+intList.rear);

        System.out.println("test đợt 2");
        for (int i =6;i<11;i++)  {
            intList.enQueue(i);
        }
        for (int i =0;i<intList.currentSize;i++){
            System.out.println(intList.queueArr[i]);
        }
        for (int i = 0; i < 6; i++) {
            intList.deQueue();}
        System.out.println(intList.front+"|"+intList.rear);
    }
}
