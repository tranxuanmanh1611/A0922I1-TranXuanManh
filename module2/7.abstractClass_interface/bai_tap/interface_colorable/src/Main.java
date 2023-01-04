public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(4, 3);
        shapes[1] = new Square(4);
        shapes[2] = new Circle(3);

        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            } else {
                System.out.println(shape);
            }
        }
    }
}
