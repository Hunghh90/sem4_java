package com.example.sem4_java.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date birthday;
    private String phone;

    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentEntity(Integer id, String name, Date birthday, String phone) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    public StudentEntity() {
    }

    public StudentEntity( String name, Date birthday, String phone) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }
}