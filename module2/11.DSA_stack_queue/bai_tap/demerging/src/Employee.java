import java.util.Date;

public class Employee {
    private String name;
    private String gender;
    private String birth;
    Employee(){}
    Employee(String name,String gender,String birth){
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee: "+ name+"| gender: "+gender+"| birth: "+birth;
    }
}
