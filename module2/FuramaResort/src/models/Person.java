package models;

public abstract class Person {
    private String name;
    private String birthday;
    private String gender;
    private String citizenId;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", citizenId='" + citizenId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email +", " +'\'' ;
    }

    public Person(){}
    public Person(String name, String birthday, String gender, String citizenId, String phoneNumber, String email) {
        setName(name);
        setBirthday(birthday);
        setGender(gender);
        setCitizenId(citizenId);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }
}
