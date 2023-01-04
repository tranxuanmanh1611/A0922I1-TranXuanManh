public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    public double getArea() {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    public double getPerimeter() {
        return 2 * this.getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with area = " + getArea() + " which is a subclass of " + super.toString();
    }
}
