import java.util.Scanner;
import java.util.Stack;

public class EmployeeBusiness {
    Employee employee;
    Stack<Employee> maleEmployee;
    Stack<Employee> femaleEmployee;

    EmployeeBusiness(){
        maleEmployee = new Stack<>();
        femaleEmployee = new Stack<>();
    }

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên");
        String name = sc.nextLine();
        System.out.println("giới tính");
        String gender = sc.nextLine();
        System.out.println("nhập ngày sinh(Định dạng mm/dd/yyyy)");
        String birth = sc.nextLine();
        employee = new Employee(name, gender, birth);
        if (employee.getGender().equals("male")) {
            maleEmployee.push(employee);
        } else {
            femaleEmployee.push(employee);
        }
    }

    public void display() {
        for (Employee employee : maleEmployee) {
            System.out.println(employee.toString());
        }
        for (Employee employee : femaleEmployee) {
            System.out.println(employee.toString());
        }
    }
}
