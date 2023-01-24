import javax.xml.soap.Node;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes = 0;

    public MyLinkedList(E data) {
        this.head = new Node(data);
        tail = head;
        numNodes++;
    }

    private class Node {
        private Node next;
        private E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= numNodes) {
            addLast(e);
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(e);
            current.next.next = temp;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        tail.next = newNode;
        tail = newNode;
        numNodes++;
    }

    public E get(int index) {
        Node temp;
        if (index == 0) {
            temp = head;
        } else if (index == numNodes - 1) {
            temp = tail;
        } else {
            temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
        }
        return temp.getData();
    }

    public void removeIndex(int index) {
        if (index == 0) {
            head = head.next;
            numNodes--;
        } else if (index >= (size() - 1)) {
            Node temp = head;
            for (int i = 1; i < (size() - 1); i++) {
                temp = temp.next;
            }
            temp.next = null;
            numNodes--;
        } else {
            Node temp = head;
            Node previous = head;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            previous.next = temp;
            numNodes--;
        }
    }

    public void removeElement(Object e) {
        Node current = head;
        for (int i = 0; i < (size() - 1); i++) {
            if (current.getData() == e) {
                removeIndex(i);
                break;
            }
        }
    }

    public boolean contains(Object e) {
        Node current = head;
        boolean check = false;
        for (int i = 0; i < (size() - 1); i++) {
            if (current.getData() == e) {
                check = true;
            }
        }
        return check;
    }

    public int indexOf(Object e) {
        Node current = head;
        int index = -1;
        for (int i = 0; i < (size() - 1); i++) {
            if (current.getData() == e) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int size() {
        return this.numNodes;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
