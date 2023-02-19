public class Triangle {
    public double a;
    public double b;
    public double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleException("Độ dài được nhỏ hơn 0");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new TriangleException("tổng 2 cạnh bất kì phải lơn hơn cạnh còn lai");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
