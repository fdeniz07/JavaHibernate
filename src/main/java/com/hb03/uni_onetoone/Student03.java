package com.hb03.uni_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student03")
public class Student03 {

    @Id
    private int Id;

    @Column(name = "std_name")
    private String name;

    private int grade;

    //Getter & Setter


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    //toString()


    @Override
    public String toString() {
        return "Student03{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
