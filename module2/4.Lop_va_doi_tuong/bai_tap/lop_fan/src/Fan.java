public class Fan {
    final int SLOW=1,MEDIUM =2,FAST =3;
    int speed =SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    public int getSpeed(){
        return speed;
    }
    public boolean getOn(){
        return on;
    }
    public double getRadius(){
        return radius;
    }
    public String getColor(){
        return color;
    }
    public void setSpeed(int num){
        this.speed=num;
    }
    public void setOn(boolean value){
        this.on = value;
    }
    public void setRadius(double value){
        this.radius = value;
    }
    public void setColor(String value){
        this.color = value;
    }
    public Fan(){}
    public Fan(int speed,boolean on, double radius,String color){
        this.setSpeed(speed);
        this.setOn(on);
        this.setRadius(radius);
        this.setColor(color);
    };
    public String toString(){
        if (this.getOn()){
            return "Tốc độ: "+this.getSpeed()+" | màu: "+this.getColor()+" | bán kính quạt: "+this.getRadius();
        }else {
            return  "fan is off";
        }
    }
}
