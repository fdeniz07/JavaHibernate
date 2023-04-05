package com.tpe.idgeneration;


import javax.persistence.*;


@Entity
@Table(name = "t_developer8")
public class Developer08 {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //id nin üretilmesinden oto. artırılmasından tamamen DB sorumlu.
    @SequenceGenerator(name = "sequence",sequenceName = "dev8_seq",initialValue = 100,allocationSize = 5)
    //allocationSize kadar id kümesi oluşturulur, her insert için Java uyg., DB ye sıradaki sequenceın(yeni) ilk elemanını sorar
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    private Long id;

    //optional
    @Column(name = "dev_name",length = 50,nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    //@Transient
    private String branch;


    public Developer08() {
    }

    public Developer08( String name, String email, String branch) {
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    @Override
    public String toString() {
        return "Developer08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
