package com.my_project.customer_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "province_name")
    private String provinceName;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customerList;

    public Province() {
    }

    public Province(String province_name) {
        this.provinceName = province_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String province_name) {
        this.provinceName = province_name;
    }
}
