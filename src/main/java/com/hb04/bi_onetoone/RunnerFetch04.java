package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //belli id'li student getirelim
        Student04 student = session.get(Student04.class, 1001);

        //diary getirelim
        Diary04 diary = session.get(Diary04.class, 101);
        System.out.println(student);
        System.out.println("******************************");
        System.out.println(diary);
        System.out.println("******************************");
        System.out.println("Diary üzerinden student objesine ulasalim : " + diary.getStudent());
        System.out.println("******************************");
        System.out.println("Student üzerinden diary objesine ulasalim : " + student.getDiary());

        //!!! Task : Kesisim kümesini bana getirin (INNER JOIN)
        String hqlQuery = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d on s.id=d.student";

        List<Object[]> resultList =session.createQuery(hqlQuery).getResultList();

//        for (Object[] object:resultList){
//            System.out.println(Arrays.toString(object));
//        }

        //Lambda Expression ile yazalim
        resultList.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        System.out.println("------------------------------------------------------------------------------");

        // Task 2 : HQL ile LEFT JOIN
        String hqlQuery2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultList2 =session.createQuery(hqlQuery2).getResultList();

        resultList2.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });

        tx.commit();
        session.close();
        sf.close();

    }

}
