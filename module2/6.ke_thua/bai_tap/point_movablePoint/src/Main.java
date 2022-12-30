public class Main {
    public static void main(String[] args) {
        MovablePoint point1 = new MovablePoint();
        point1.setSpeed(2, 1);
        System.out.println(point1.toString());
        for (int i = 0; i < 3; i++) {
            point1.move();
        }
        System.out.println(point1.toString());

    }
}
