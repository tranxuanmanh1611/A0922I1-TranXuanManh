package models;

public class Employee extends Person {
    private int employeeId;
    private String education;
    private String position;
    private int salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        if (education.equals("intermediate") || education.equals("college") || education.equals("universityAndUpper")) {
            this.education = education;
        } else {
            education = "không tồn tại";
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position.equals("receptionist") || position.equals("staff") || position.equals("executive")
                || position.equals("supervisor") || position.equals("manager") || position.equals("director")) {
            this.position = position;
        } else {
            position = "Không tồn tại";
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString()+
                "employeeId=" + employeeId +
                ", education='" + education + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                "} ";
    }

    public Employee() {
       }

    public Employee(int employeeId,String name, String birthday, String gender, String citizenId,
                    String phoneNumber, String email, String education, String position, int salary) {
        super(name, birthday, gender, citizenId, phoneNumber, email);
        setEmployeeId(employeeId);
        setEducation(education);
        setPosition(position);
        setSalary(salary);
    }
}
