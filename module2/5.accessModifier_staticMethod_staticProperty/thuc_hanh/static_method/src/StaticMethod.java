public class StaticMethod {
    public static void main(String[] args) {
        Student s1 = new Student(1, "hoang");
        Student s2 = new Student(2, "khanh");
        Student s3 = new Student(3, "Nam");
        s3.change();
        // cho dù có dùng phương thức cho 1 đối tượng, các đối tượng còn lại vẫn thay đổi, vì dữ lieeu static tất cả các dối tượng dùng chung//
        s1.display();
        s2.display();
        s3.display();
    }
}
