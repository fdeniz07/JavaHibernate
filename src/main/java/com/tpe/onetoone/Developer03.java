package com.tpe.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "t_developer3")
public class Developer03 {

    @Id//her bir entity için zorunlu:PK sağlar
    private int id;

    //optional
    @Column(name = "dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;

    //her deve bir bilgisayar veriliyor.
    //dev e hangi bilgisayarın verildiğini tutmak istiyoruz.
    @OneToOne//ilişki sahibi
    @JoinColumn(name = "c_id")//computer_id
    private Computer computer;

    public Developer03() {
    }

    public Developer03(int id, String name, String email, String branch, Computer computer) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.computer = computer;
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

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Developer03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", computer=" + computer +
                '}';
    }
}
