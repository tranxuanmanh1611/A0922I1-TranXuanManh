public class Shape {
    private String color = "red";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String value) {
        this.color = value;
    }
    @Override
    public String toString(){
        return "A shape with "+getColor()+" color";
    }
}
