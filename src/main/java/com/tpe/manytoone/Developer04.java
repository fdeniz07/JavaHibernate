package com.tpe.manytoone;

import javax.persistence.*;

@Entity
@Table(name = "t_developer4")
public class Developer04 {

    @Id//her bir entity için zorunlu:PK sağlar
    private Long id;

    //optional
    @Column(name = "dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

    //developerların çalıştığı companyi de kaydetmek istiyoruz.
    //bir companyde birden çok developer çalışabilir, bir dev sadece bir companyde çalışabilir.
    @ManyToOne
    private Company company;

    public Developer04() {
    }

    public Developer04(Long id, String name, String email, String branch, Company company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developer04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", company=" + company +
                '}';
    }
}
