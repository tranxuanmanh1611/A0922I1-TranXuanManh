package com.my_project.validate_signup_form.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname")
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;
    @Column(name = "lastname")
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;
    @Column(name = "phone_number")
    @Pattern(regexp = "^0[0-9]*$", message = "Phone number must follow format 0xxxxx...")
    @Size(min = 9, max = 11, message = "Phone number must have 9 - 11 numbers")
    private String phoneNumber;
    @Column(name = "age")
    @Min(value = 18, message = "User must 18+")
    private int age;
    @Column(name = "email")
    @Email
    @NotBlank
    private String email;

    public Account() {
    }

    public Account(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
