public class MyStack {
    public int[] arr;
    public int size = 0;
    public int index = 0;

    MyStack() {
        System.out.println("Khởi tạo thành công stack rỗng");
    }

    MyStack(int size) {
        this.size = size;
        arr = new int[size];
        System.out.println("khởi tạo thành công stack size " + size);
    }

    public void push(int element) {
        arr[index] = element;
        System.out.println("thêm thành công " + element + "|index: " + index);
        index++;
    }

    public int pop() throws Exception {
        if (index == 0) {
            throw new Exception("Khong có dữ liệu");
        }

        return arr[--index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        boolean check = false;
        if (index == 0) {
            check = true;
        }
        return check;
    }

    public boolean isFull() {
        boolean check = false;
        if (index == size) {
            check = true;
        }
        return check;
    }
}
