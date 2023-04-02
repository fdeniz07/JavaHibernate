package com.tpe.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //1)id=2 olan developerın çalıştığı company bilgilerini yazdırınız.
        Developer04 dev=session.get(Developer04.class,2L);
        System.out.println("------------------1----------------------");
        System.out.println(dev);
        System.out.println(dev.getCompany());
        System.out.println("------------------1----------------------");
        //developerdan company bilgisine ulaşabiliriz.

        //2)id=11 olan company bilgilerini yazdırınız.
        Company company=session.get(Company.class,11L);
        System.out.println("------------------2----------------------");
        System.out.println(company);
        System.out.println("------------------2----------------------");

        //companyden dev bilgilerine ulaşamıyoruz, çünkü tek yönlü ilişki

        //3)tüm developerların ismini ve çalıştıkları company ismini yazdırınız.
        String sql="SELECT d.dev_name, c.companyname FROM t_developer4 d JOIN company c ON d.company_id=c.id";
        List<Object[]> resultList=session.createSQLQuery(sql).getResultList();
        System.out.println("------------------3----------------------");
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println("------------------3----------------------");

        //2.yöntem
        String hql="SELECT d.name,d.company.companyname FROM Developer04 d ";
        List<Object[]> resultList2=session.createQuery(hql).getResultList();
        System.out.println("------------------3(alternatif)----------------------");
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));
        System.out.println("------------------3----------------------");

        //***ÖDEV***
        //4)Googleda çalışan developerların isim, branch, company name bilgilerini yazdırınız.

        tx.commit();
        session.close();
        sf.close();


    }
}
