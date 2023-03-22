package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /*
            DB'den bilgi almak istiyorsam
                1) get()
                2) SQL (Native SQL)
                3) HQL
         */

        //!!! 1.YOL : Get() *********************************************
//        Student01 student1 = session.get(Student01.class, 1);
//        Student01 student2 = session.get(Student01.class, 2);
//        Student01 student3 = session.get(Student01.class, 3);
//
//        System.out.println(student1);
//        System.out.println(student2);
//        System.out.println(student3);


        //!!! 2.YOL : SQL *********************************************

//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Objects[]> resultList = session.createSQLQuery(sqlQuery).getResultList();
//
//        for (Object[] object : resultList) {
//            System.out.println(Arrays.toString(object));
//        }

        //!!! 3.YOL : HQL *********************************************
        //Trick: HQL sorgusunda From'dan sonra sinif ismi kullanilmali

//        String hqlQuery = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery, Student01.class).getResultList();
//
//        for (Student01 student01: resultList2){
//            System.out.println(student01);
//        }

        //Not : Yukaridaki 3 metodu kiyaslayalim...
        //1.hazir metod, 2.HQL, 3.SQL

        //!!! Dönecek kaydin unique (tek bir tane) oldugundan emin isem uniqueResult() ...

//        String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='John Rambo'";
//        Objects[] uniqueResult1 =(Objects[]) session.createSQLQuery(sqlQuery2).uniqueResult();
//
//        System.out.println(Arrays.toString(uniqueResult1));

        // yukarda 1 obje gelecek ama icinde fieldlar oldugu icin bunlarti ayri ayri almak istersem:
//        System.out.println(uniqueResult1[0] + " : " + uniqueResult1[1] + " : " + uniqueResult1[2]);
        // HQL ile
        String hqlQuery2 = "FROM Student01 WHERE name='John Connor'";
        Student01 uniqueResult2 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println(uniqueResult2);

        tx.commit();
        session.close();
        sf.close();
    }
}
