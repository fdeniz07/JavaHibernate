package com.tpe.onetomany_uni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company2 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    //companyde çalışan devleri görmek istiyorum.
    @OneToMany
    @JoinColumn(name = "company_id")//developer tablosunda bir fk oluştur.
    //join column kullanmazsak join table üretilir.
    private Set<Developer05> developers=new HashSet<>();

    public Company2() {
    }

    public Company2(Long id, String companyname) {
        this.id = id;
        this.companyname = companyname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Set<Developer05> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer05> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company3{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                ", developers=" + developers +
                '}';
    }
}
