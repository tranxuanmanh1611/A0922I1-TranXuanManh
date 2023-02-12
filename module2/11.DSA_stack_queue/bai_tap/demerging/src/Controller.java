import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        EmployeeBusiness employeeBusiness = new EmployeeBusiness();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Ứng dụng thêm nhan viên");
            System.out.println("1. Thêm nhân viên\n" + "2. Hiển thị danh sách\n" + "3.Exit\n");
            choice = sc.nextInt();
            if (choice==1){
                employeeBusiness.add();
            }
            if (choice==2){
                employeeBusiness.display();
            }
        } while (choice != 3);
    }

}
