import java.util.Scanner;

public class FindElements {
    public static void main(String[] args) {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        String[] studentList = {"Quang", "Dien", "Thang", "Tan", "Manh"};
        System.out.println("Nhập tên bạn muốn tìm trong lớp A0922I1?");
        String name = scanner.nextLine();
        for (int i = 0; i < studentList.length; i++) {
            if (name.equals(studentList[i])) {
                System.out.println("Đã tìm thấy sinh viên " + name + " trong danh sách ở index " + i);
                check= true;
                break;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy");
        }
    }
}
