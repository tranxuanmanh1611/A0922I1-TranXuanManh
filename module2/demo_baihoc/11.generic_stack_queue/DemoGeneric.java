package generic_stack_queue;

public class DemoGeneric {
    public int plus(int a, int b) {
        return a + b;
    }

    public long plus(long a, long b) {
        return a + b;
    }

    public float plus(float a, float b) {
        return a + b;
    }

    public <T> T plus(T a, T b) {
        return a;
    }

    public <T> void print(T[] array) {
        for (T e: array) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String[] cities = new String[]{"Da Nang", "Ha noi", "Ho Chi Minh"};
        Integer[] list = {1, 6, 9 ,10};
        DemoGeneric demoGeneric = new DemoGeneric();
        demoGeneric.<String>print(cities);
        demoGeneric.print(list);
    }
}
