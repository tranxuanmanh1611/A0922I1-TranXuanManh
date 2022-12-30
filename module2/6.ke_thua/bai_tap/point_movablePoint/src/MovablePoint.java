public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint() {
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float value) {
        this.xSpeed = value;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float value) {
        this.ySpeed = value;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] array = new float[2];
        array[0] = xSpeed;
        array[1] = ySpeed;
        return array;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ") ,speed = " + "(" + getXSpeed() + "," + getYSpeed() + ")";
    }

    public MovablePoint move() {
        this.setX(getX() + getXSpeed());
        this.setY(getY() + getYSpeed());
        return this;
    }
}
