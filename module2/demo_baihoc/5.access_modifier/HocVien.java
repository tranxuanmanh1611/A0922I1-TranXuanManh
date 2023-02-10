package access_modifier;

public class HocVien {
    public String name;
    public int age;
    public String address;
    public static String className;

    static {
        System.out.println("Khởi tạo biến static");
        className = "A0922I1";
    }

    public HocVien() {
        System.out.println("Khởi tạo object");
    }

    public static void showClass() {
        System.out.println("Class: " + className);
    }

//    public static void showName() {
//        System.out.println("Name: " + this.name);
//    }
}
