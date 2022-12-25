public class QuadraticEquation {
    private double a, b, c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setC(double num3) {
        this.c = num3;
    }

    public void setA(double num1) {
        this.a = num1;
    }

    public void setB(double num2) {
        this.b = num2;
    }

    QuadraticEquation(double num1, double num2, double num3) {
        this.setA(num1);
        this.setB(num2);
        this.setC(num3);
    }

    public double getDiscriminant() {
        return Math.pow(this.getB(), 2) - 4 * this.getA() * this.getC();
    }

    public double getRoot1() {
        return ((-this.getB() + Math.sqrt(Math.pow(this.getB(), 2) - 4 * this.getC() * this.getA())) / (2 * this.getA()));
    }

    public double getRoot2() {
        return ((-this.getB() - Math.sqrt(Math.pow(this.getB(), 2) - 4 * this.getC() * this.getA())) / (2 * this.getA()));
    }

    public String display() {
        return "a: " + this.getA() + "|b: " + this.getB() + "|c: " + this.getC();
    }
}
