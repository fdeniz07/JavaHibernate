package com.tpe.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1-id=1 olan developerın çalıştığı projeleri yazdırınız.
        Developer07 dev=session.get(Developer07.class,1L);
        System.out.println(dev.getProjects());

        //2-id=22 olan projede çalışan devleri getiriniz.
        Project project=session.get(Project.class,22L);
        System.out.println(project.getDevelopers());


        tx.commit();
        session.close();
        sf.close();
    }
}
