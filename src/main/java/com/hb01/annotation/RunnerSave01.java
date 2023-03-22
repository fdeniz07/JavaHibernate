package com.hb01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1);
        student1.setName("John Wick");
        student1.setGrade(80);

        Student01 student2 = new Student01();
        student2.setId(2);
        student2.setName("John Rambo");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(3);
        student3.setName("John Connor");
        student3.setGrade(70);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
        // yukardaki satirda, Hibernate 'e konfigurasyon dosyami ve Entity classimi bildirdim

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();

        session.close();
        sf.close();

    }
}
