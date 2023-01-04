public class Rectangle extends Shape implements Resizable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double value) {
        this.width = value;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double value) {
        this.length = value;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "A rectangle with width = " + getWidth() + " and length = " + getLength() + ", which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setLength(getLength() * (1 + percent / 100));
        setWidth(getWidth() * (1 + percent / 100));
    }
}
