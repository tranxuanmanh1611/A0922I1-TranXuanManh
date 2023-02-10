public class MyQueue {
    public int capacity;
    public int[] queueArr;
    public int front = 0;
    public int rear = -1;
    public int currentSize = 0;

    MyQueue() {
    }

    MyQueue(int queueSize) {
        capacity = queueSize;
        queueArr = new int[queueSize];
    }

    public boolean isQueueFull() {
        boolean check = false;
        if (capacity == currentSize) {
            check = true;
        }
        return check;
    }

    public boolean isQueueEmpty() {
        boolean check = false;
        if (currentSize == 0) {
            check = true;
        }
        return check;
    }

    public void enQueue(int item) {
        if (isQueueFull()) {
            System.out.println("đã đầy bộ nhớ không thể thêm " + item);
        } else {
            rear++;
        }
        queueArr[rear] = item;
        currentSize++;
        System.out.println("item: " + item + " đã được thêm vào queue" + "| currentsize =" + currentSize);

    }

    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Không có item nào để lấy ra");
        } else {
            front++;
            if (front == capacity) {
                System.out.println("lấy ra thành công item " + queueArr[front - 1] + "| currentsize =" + currentSize);
                front = 0;
                rear = -1;
            } else {
                System.out.println("lấy ra thành công item " + queueArr[front - 1] + "| currentsize =" + currentSize);
            }
            currentSize--;
        }

    }
}
