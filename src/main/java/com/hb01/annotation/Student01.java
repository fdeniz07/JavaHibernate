package com.hb01.annotation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //!!! @Entity ile bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz., student01
@Table(name = "t_student01") //opsiyoneldir, tablo adi konulmazsa class adini tablo adi olarak default alir.
public class Student01 {

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    private int grade;


    //Constructor

    public Student01() {
    }

    public Student01(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Getter - Setter

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //Methods

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
