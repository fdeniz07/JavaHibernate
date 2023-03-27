package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {

    public static void main(String[] args) {


        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer01.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Developer01 dev=session.get(Developer01.class,1);
        System.out.println(dev);

        //1-sql ile tüm datayı çekiniz.
        String sqlQuery1="SELECT * FROM t_developer01";
        List<Object[]> resultList=session.createSQLQuery(sqlQuery1).getResultList();
        System.out.println("------SQL----------");
        for (Object[] r:resultList ){
            System.out.println(Arrays.toString(r));
        }

        //2-hql ile tüm datayı çekiniz.
        String hqlQuery1="FROM Developer01";
        List<Developer01> devList=session.createQuery(hqlQuery1, Developer01.class).getResultList();
        System.out.println("------HQL----------");
        devList.forEach(t-> System.out.println(t));

        //***ÖDEV***
        //3-hql ile ismi 'Shrek' olan datayı çekiniz.
        String hqlQuery2="FROM Developer01 WHERE name='Shrek'";
        List<Developer01> devList2=session.createQuery(hqlQuery2, Developer01.class).getResultList();
        devList2.forEach(t-> System.out.println(t));


        //4-hql ile emaili 'jack@gmail.com' olan datayı çekiniz.
        String hqlQuery3="FROM Developer01 WHERE email='jack@gmail.com'";
        Developer01 dev2=session.createQuery(hqlQuery3, Developer01.class).uniqueResult();
        System.out.println(dev2);


        //5-hql ile branch i backend olan datanın ismini getiriniz.
        String hqlQuery4="SELECT d.name FROM Developer01 d WHERE d.branch='backend'";
        List<String> nameList=session.createQuery(hqlQuery4,String.class).getResultList();
        nameList.forEach(t-> System.out.println(t));




        tx.commit();
        session.close();
        sf.close();



    }



}
