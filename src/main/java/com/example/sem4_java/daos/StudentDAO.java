package com.example.sem4_java.daos;

import com.example.sem4_java.entities.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void createStudent(StudentEntity student);
    List<StudentEntity> getAll();
}