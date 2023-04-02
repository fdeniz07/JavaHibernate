package com.tpe.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1)Amazonda çalışan developer bilgilerini getiriniz.
        String hql="SELECT c.developers FROM Company3 c WHERE c.companyname='Amazon'";
        List<Object> resultList =session.createQuery(hql).getResultList();
        resultList.forEach(System.out::println);
        //companyden devlere ulaşabiliriz.

        //2)id=2 olan developerı yazdırınız.
        Developer05 dev=session.get(Developer05.class,2L);
        System.out.println(dev);
        //developerdan company bilgisine ulaşamayız, çünkü tek yönlü ilişki kurduk.




        tx.commit();
        session.close();
        sf.close();
    }
}
