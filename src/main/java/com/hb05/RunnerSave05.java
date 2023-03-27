package com.hb05;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {

    Student05 student1 = new Student05();
    student1.setId(1001);
    student1.setName("Zisan Hanim");
    student1.setGrade(70);


        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Gülsüm Hanim");
        student2.setGrade(75);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Cemil Bey");
        student3.setGrade(80);

        University university1 = new University();
        university1.setId(1);
        university1.setName("TPE Unv");

        student1.setUniversity(university1);
        student2.setUniversity(university1);
        student3.setUniversity(university1);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university1);

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
