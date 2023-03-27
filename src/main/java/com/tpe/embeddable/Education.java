package com.tpe.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Education {

    private String university;

    private String department;

    public Education() {
    }

    public Education(String university, String department) {
        this.university = university;
        this.department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return
                "university='" + university + '\'' +
                ", department='" + department + '\'';
    }
}
