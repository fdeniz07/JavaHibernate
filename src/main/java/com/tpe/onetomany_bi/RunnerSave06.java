package com.tpe.onetomany_bi;

import com.tpe.onetomany_uni.Company2;
import com.tpe.onetomany_uni.Developer05;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class RunnerSave06 {
    public static void main(String[] args) {
        Company3 company1=new Company3(11L,"Google");
        Company3 company2=new Company3(22L,"Amazon");
        Company3 company3=new Company3(33L,"Trendyol");

        Developer06 dev1=new Developer06(1L,"Harry Potter","hp@gmail.com","backend");
        Developer06 dev2=new Developer06(2L,"Shrek","shrek@gmail.com","frontend");
        Developer06 dev3=new Developer06(3L,"Jack Sparrow","jack@gmail.com","mobile");
        Developer06 dev4=new Developer06(4L,"Richie Rich","rich@gmail.com","fullstack");
        Developer06 dev5=new Developer06(5L,"Gandalf","gandalf@gmail.com","backend");


        //ilişki sahibi tarafında set edilmeli
        dev1.setCompany(company1);
        dev2.setCompany(company1);
        dev3.setCompany(company2);
        dev4.setCompany(company2);
        dev5.setCompany(company3);

        //company1.getDevelopers().add(dev1);-->db de ilişki kurulmaz.



        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


         session.save(dev1);
         session.save(dev2);
         session.save(dev3);
         session.save(dev4);
         session.save(dev5);

         session.save(company1);
         session.save(company2);
         session.save(company3);


        tx.commit();
        session.close();
        sf.close();
    }

}
