package com.tpe.onetoone;

import com.tpe.annotations.Developer01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Computer c1=new Computer(11,"12345678","Lenova");
        Computer c2=new Computer(22,"12345679","Toshiba");
        Computer c3=new Computer(33,"12345670","Dell");

        Developer03 dev1=new Developer03(1,"Harry Potter","hp@gmail.com","backend",c1);
        Developer03 dev2=new Developer03(2,"Shrek","shrek@gmail.com","frontend",c2);
        Developer03 dev3=new Developer03(3,"Jack Sparrow","jack@gmail.com","mobile",c3);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer03.class).addAnnotatedClass(Computer.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(c1);
        session.save(c2);
        session.save(c3);
        session.save(dev1);
        session.save(dev2);
        session.save(dev3);


        tx.commit();//commit ile DB de yapılan değişiklikler kalıcı hale gelir.
        session.close();
        sf.close();


    }
}
