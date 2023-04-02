package com.tpe.onetomany_bi;

import com.tpe.onetomany_uni.Developer05;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Company3 {

    @Id
    private Long id;

    @Column(unique = true)
    private String companyname;

    //companyde çalışan devleri görmek istiyorum.
    //@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "company",orphanRemoval = true)
    private Set<Developer06> developers=new HashSet<>();

    public Company3() {
    }

    public Company3(Long id, String companyname) {
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

    public Set<Developer06> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer06> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Company3{" +
                "id=" + id +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
