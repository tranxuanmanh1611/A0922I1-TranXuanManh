public class Circle {
    private double radius = 1.0;
    private String color = "green";

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String value) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius,2) * Math.PI;
    }
    @Override
    public String toString(){
        return "A circle with radius = "+getRadius()+" and color "+getColor();
    }
}
