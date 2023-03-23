package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {

    public static void main(String[] args) {

        Student02 student1 = new Student02();
        student1.setId(1001);
        student1.setName("Neo");
        student1.setGrade(75);

        Address address1 = new Address();
        address1.setStreet("Apple Street");
        address1.setCity("New York");
        address1.setCountry("USA");
        address1.setZipCode("12345");

        student1.setAddress(address1);

        Address address2 = new Address();
        address2.setStreet("Orange Street");
        address2.setCity("London");
        address2.setCountry("England");
        address2.setZipCode("67890");

        Student02 student2 = new Student02();
        student2.setId(1002);
        student2.setName("Trinity");
        student2.setGrade(95);

        student2.setAddress(address2);

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);


        tx.commit();
        session.close();
        sf.close();


    }
}
