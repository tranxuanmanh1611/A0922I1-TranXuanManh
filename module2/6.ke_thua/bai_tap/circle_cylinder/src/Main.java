public class Main   {
    public static void main(String[] args){
        Circle circle1 = new Circle();
        circle1= new Circle(2,"red");
        System.out.println(circle1.toString());
        System.out.println("area: "+circle1.getArea());
        Cylinder cylinder1 = new Cylinder();
        System.out.println(cylinder1.toString());
        System.out.println("volume: "+cylinder1.getVolume());

        Circle[] array = new Circle[2];
        array[0]= new Circle();
        array[1]= new Cylinder();
        for (int i=0;i<array.length;i++){
            System.out.println(array[i].toString());
        }
    }
}
