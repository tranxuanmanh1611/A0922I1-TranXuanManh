public class MyCircleLinkedListQueue<E> {

    Node front;
    Node rear;
    int size =0;
    MyCircleLinkedListQueue(){
front = null;
rear = null;
    }
    public void enQueue(E data){
    if (rear==null){
        Node temp = new Node(data);
        rear = front = temp;
        size++;
}else {
         Node temp = new Node(data);
         rear.link = temp;
         rear = temp;
         rear.link =  front;
         size++;
}
    }
    public void deQueue(){
        if (front==null){
            System.out.println("Không có dữ liêu");}
        front = front.link;
        rear.link = front;
        size--;
}

public void displayQueue(){
        Node current = front;
if (rear == null){System.out.println("Không có dữ liệu");
}
for (int i=0;i<size;i++){
    System.out.println("Node: "+(i+1)+"|"+"data: "+current.data);
    current = current.link;
}

    }
    public class Node<E>{
E data;
Node link;
public Node (){}
public Node(E data){
this.data = data;
this.link = null;
}
    }}


