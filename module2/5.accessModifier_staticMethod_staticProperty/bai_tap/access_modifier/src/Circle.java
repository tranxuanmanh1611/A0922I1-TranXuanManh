public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public double getRadius() {
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setRadius(double value){
        this.radius = value;
    }
    public void setColor(String value){
        this.color = value;
    }
    public Circle(){}
    public Circle(double r ){
        this.setRadius(r);
    }
    private double getArea(){
        final double pi = Math.PI;
        return Math.pow(this.getRadius(),2)*pi;
    }
}
