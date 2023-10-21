package com.example.sem4_java.daos;

import com.example.sem4_java.entities.StudentEntity;

import java.util.List;

public interface StudentDAO {
    void createStudent(StudentEntity student);
    List<StudentEntity> getAll();

    void updateStudent(StudentEntity student);
    void deleteStudent(int id);
    StudentEntity getById(int id);
}