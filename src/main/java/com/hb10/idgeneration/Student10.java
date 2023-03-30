package com.hb10.idgeneration;

import javax.persistence.*;

@Entity
public class Student10 {

    /*
        Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
         başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)

        MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
                 içlerindeki en basitidir)
        GenerationType.AUTO ---> Hibernate otomatik olarak kullanilan DB ye gore stratejiyi belirler
        GenerationType.TABLE ---> En yavaşı , oyüzden çok kullanılmıyor, çünkü id
                 üretmek için ekstra tablo oluşturuyor


     */


    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
                        sequenceName = "student_seq", // @GeneratedValue'nun generator parametresi ile ayni isimle olmali, ismi biz veriyoruz
                        initialValue = 1000,  //id'lerin baslangic degeri
                        allocationSize = 10) //cach'leme mekanizmasinda 10 adet id hazirda beklesin
    @Id
    private int id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int grade;


    //Getter & Setter

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
