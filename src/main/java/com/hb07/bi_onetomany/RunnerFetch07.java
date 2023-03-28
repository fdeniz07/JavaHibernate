package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        // !!! SQL ile öğrenci bilgilerini ( Inner Join )  alalım ( öğrenci ismi ve kitap ismi )

        // !!! yukardaki sorguyu HQL ile yazalım

        tx.commit();
        session.close();
        sf.close();
    }
}
