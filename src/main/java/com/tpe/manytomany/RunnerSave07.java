package com.tpe.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Project project1=new Project(11L,"CarRental");
        Project project2=new Project(22L,"AtmApp");

        Developer07 dev1=new Developer07(1L,"Harry Potter","hp@gmail.com","backend");
        Developer07 dev2=new Developer07(2L,"Shrek","shrek@gmail.com","frontend");
        Developer07 dev3=new Developer07(3L,"Jack Sparrow","jack@gmail.com","mobile");


        project1.getDevelopers().add(dev1);
        project1.getDevelopers().add(dev2);

        project2.getDevelopers().add(dev1);
        project2.getDevelopers().add(dev2);
        project2.getDevelopers().add(dev3);

        //dev1.setProjects(project1);->cascadeType.ALL ile devler save yapınca projectler de save olsun istersek



        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        session.save(project1);
        session.save(project2);


        tx.commit();
        session.close();
        sf.close();
    }
}
