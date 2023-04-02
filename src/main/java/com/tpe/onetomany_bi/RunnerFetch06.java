package com.tpe.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

//        //1-Amazonda çalışan developer bilgilerini yazdırınız.
//        String hql="FROM Company3 c WHERE c.companyname='Amazon'";
//        Company3 amazon=session.createQuery(hql, Company3.class).uniqueResult();
//        System.out.println("------------Amazonda çalışanlar-----------------");
//        amazon.getDevelopers().forEach(System.out::println);
//        System.out.println("------------Amazonda çalışanlar-----------------");
//        //company den devlere ulaşabiliyoruz.
//
//        //2--email i gandalf@gmail.com olan devin çalıştığı company bilgilerini getiriniz.
//        String hql2="FROM Developer06 d WHERE d.email='gandalf@gmail.com'";
//        Developer06 dev=session.createQuery(hql2, Developer06.class).uniqueResult();
//        System.out.println("-------------------2-----------------------");
//        System.out.println(dev.getCompany());
//        System.out.println("-------------------2-----------------------");
//        //developer dan da companye ulaşabiliriz.



        //----------------------------DELETE-ORPHANREMOVAL-CASCADETYPE_ALL------------------------------------------
        //3--id=22 olan companynin dev listesinden id=3 olan developerı siliniz.
//        Developer06 dev3=session.get(Developer06.class,3L);
//        Company3 company=session.get(Company3.class,22L);
//        company.getDevelopers().remove(dev3);
//        System.out.println("Amazonda çalışanlar: "+company.getDevelopers());

        //orphanremoval true ise datayı listeden kaldırdığımızda/nulla set edersek tablodan siliyor.
        //cascadetypeAll da listeden çıkarılsa da tabloda duruyor.


//        //4--id 22 olan company i siliniz.
        Company3 company22=session.get(Company3.class,22L);
        session.delete(company22);
        //company iflas etti, devler de gitti:)(cascadetypeALL,orphanremoval)



        tx.commit();
        session.close();
        sf.close();

    }
}
