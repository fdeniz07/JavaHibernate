package com.tpe.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Education edu1=new Education("ITU","Computer Eng");
        Education edu2=new Education("YTU","Mathematics");

        Developer02 dev1=new Developer02(1,"Harry Potter","hp@gmail.com","backend",edu1);
        Developer02 dev2=new Developer02(2,"Shrek","shrek@gmail.com","frontend",edu2);
        Developer02 dev3=new Developer02(3,"Jack Sparrow","jack@gmail.com","mobile",edu1);

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer02.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        //educationlar da save edilecek mi?-->hayır, education için tablo oluşturmadık
        //education değişkenlerini dev içerisine gömdük.
        session.save(dev1);
        session.save(dev2);
        session.save(dev3);


        tx.commit();
        session.close();
        sf.close();

    }
}
