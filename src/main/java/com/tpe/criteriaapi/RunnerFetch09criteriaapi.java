package com.tpe.criteriaapi;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch09criteriaapi {
    public static void main(String[] args) {


        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();


        //----------------Criteria API-------------------------
        //SQL ve HQL String bazlı->hataya açık ve hataları run timeda görebiliriz.
        //Criteria API, java kodları ile programatik olarak sorgulama yapmamızı sağlar,
        //derleme anında hataları görebiliriz, hataların minimize edilmesini sağlar.


        CriteriaBuilder cbuilder=session.getCriteriaBuilder();//CriteriQuery nesnesi oluşturmak için, bazı metodlarını kullanmak için
        CriteriaQuery<Developer09> cq=cbuilder.createQuery(Developer09.class);
        Root<Developer09> root= cq.from(Developer09.class);//classımızın tüm datalarını tutan kaynak

        //1-ismi Cemal olan developerı getiriniz.
        cq.select(root).//tüm datayı getirir.
                where(cbuilder.equal(root.get("name"),"Cemal"));//where Predicate ister
        List<Developer09> resultList=session.createQuery(cq).getResultList();
        resultList.forEach(System.out::println);

        //2-salarysi 8000 olan developerları getiriniz.
        cq.select(root).where(cbuilder.equal(root.get("salary"),"8000"));
        List<Developer09> resultList2=session.createQuery(cq).getResultList();
        resultList2.forEach(System.out::println);

        //3-salarysi 8000 den fazla olan developerları getiriniz.
        cq.select(root).where(cbuilder.greaterThan(root.get("salary"),"8000"));
        List<Developer09> resultList3=session.createQuery(cq).getResultList();
        resultList3.forEach(System.out::println);

        //4-ismi Erdem olan veya salarysi 9000 den fazla developerları getiriniz.
        Predicate pred1=cbuilder.equal(root.get("name"),"Erdem");
        Predicate pred2=cbuilder.greaterThan(root.get("salary"),"9000");
        Predicate predOr=cbuilder.or(pred1,pred2);

        cq.select(root).where(predOr);
        List<Developer09> resultList4=session.createQuery(cq).getResultList();
        resultList4.forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();
    }
}
