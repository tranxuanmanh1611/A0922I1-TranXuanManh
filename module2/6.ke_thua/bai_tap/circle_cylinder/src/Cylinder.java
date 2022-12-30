public class Cylinder extends Circle {
    private double heigth = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, double heigth, String color) {
        super(radius, color);
        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double value) {
        this.heigth = value;
    }

    public double getVolume() {
        return getArea() * heigth;
    }

    @Override
    public String toString() {
        return "A cylinder with radius = " + getRadius() + " and heigth = " + getHeigth()
                + ", which is a subclass of " + super.toString();
    }
}
