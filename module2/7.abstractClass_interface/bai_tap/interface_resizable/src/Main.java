public class Main {
    public static void main(String[] args) {
        System.out.println("circle before resizing");
        Circle circle = new Circle(3.5);
        System.out.println(circle);
        circle.resize(100);
        System.out.println("circle after resizing");
        System.out.println(circle);
        System.out.println("");
        System.out.println("rectangle before resizing");
        Rectangle rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        rectangle.resize(100);
        System.out.println("rectangle after resizing");
        System.out.println(rectangle);
    }
}
