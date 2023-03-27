package com.tpe.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_developer2")
public class Developer02 {

    @Id//her bir entity için zorunlu:PK sağlar
    private int id;

    //optional
    @Column(name = "dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

//    private String university;
//    private String department;

    //kendi oluşturduğumuz class tipinde değişken tanımlayabiliriz.
    @Embedded
    private Education education;

    public Developer02() {
    }

    public Developer02(int id, String name, String email, String branch, Education education) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.education = education;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Developer02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", education=" + education +
                '}';
    }
}
