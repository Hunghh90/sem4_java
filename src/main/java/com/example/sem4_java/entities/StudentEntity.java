package com.example.sem4_java.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="student_code")
    private String studentCode;
    private String name;
    private Date birthday;
    private String phone;

    public Integer getId() {
        return id;
    }

    public String getStudentCode() {
        return studentCode;
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

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
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

    public StudentEntity(Integer id, String studentCode, String name, Date birthday, String phone) {
        this.id = id;
        this.studentCode = studentCode;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    public StudentEntity() {
    }

    public StudentEntity(String studentCode, String name, Date birthday, String phone) {
        this.studentCode = studentCode;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }
}