package com.tpe.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1)id=1 olan developerın tüm bilgilerini getiriniz.

        Developer03 dev1=session.get(Developer03.class,1);
        System.out.println("-----------------1-------------------");
        System.out.println(dev1);
        System.out.println("------------------1------------------");

        //2)id=33 olan computerın tüm bilgilerini getiriniz.
        Computer computer=session.get(Computer.class,33);
        System.out.println("-----------------2-------------------");
        System.out.println(computer);
        System.out.println("------------------2------------------");


        //3)id=22 olan computerı kullanan developerın tüm bilgilerini getiriniz.
        Computer computer2=session.get(Computer.class,22);
        System.out.println("-----------------3-------------------");
        System.out.println(computer2.getDeveloper());//uni-directional olsaydı computerdan dev e ulaşamazdık.
        System.out.println("-----------------3-------------------");


        //4)id=2 olan developerın kullandığı computerın tüm bilgilerini getiriniz.
        Developer03 dev2=session.get(Developer03.class,2);
        System.out.println("-----------------4-------------------");
        System.out.println(dev2.getComputer());
        System.out.println("-----------------4-------------------");

        //***ÖDEV***
        //tüm developerların ismini ve kullandıkları computerın markasını yazdırınız.
        String hql="SELECT d.name,c.brand FROM Developer03 d JOIN  Computer c ON d.computer.id=c.id";
        List<Object[]> resultList=session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        tx.commit();
        session.close();
        sf.close();


    }
}
