/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="enrollment")
    private long enrollment;

    public Student() {
    }

    public Student(long enrollment, String name, String email) {
        this.enrollment = enrollment;
        this.name = name;
        this.email = email;
    }
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;

    public long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(long enrollment) {
        this.enrollment = enrollment;
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

    

   
    
}
