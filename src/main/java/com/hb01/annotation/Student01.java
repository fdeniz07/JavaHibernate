package com.hb01.annotation;

import javax.persistence.*;

@Entity //!!! @Entity ile bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz., student01
@Table(name = "t_student01") //opsiyoneldir, tablo adi konulmazsa class adini tablo adi olarak default alir.
//Java kodu içinde bu class'a ulaşırken Student01 ile, SQL ile ulaşirken t_student01 ile yazmam lazım
public class Student01 {

    @Id //Primary key olusmasini saglar
    //@Column(name = "std_id") -> Column ismini customize eder.
    private int id;


    @Column(name = "student_name", length = 100, nullable = false, unique = false)
    private String name;

    //@Transient //!!! Db deki tabloda "grade" adinda bir kolon olusmasini engeller
    private int grade;

//    @Lob //!!! Large Object ile büyük datalar tutulabiliyor.
//    private byte[] image;


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
