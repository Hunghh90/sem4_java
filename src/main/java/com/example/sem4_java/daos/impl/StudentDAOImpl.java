package com.example.sem4_java.daos.impl;

import com.example.sem4_java.daos.StudentDAO;
import com.example.sem4_java.entities.StudentEntity;
import com.example.sem4_java.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    EntityManager entityManager;
    EntityTransaction transaction;
    public StudentDAOImpl(){
      entityManager = PersistenceUtil.createEntityManagerFactory().createEntityManager();
      transaction = entityManager.getTransaction();
    }

    @Override
    public void createStudent(StudentEntity student) {
        try{
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
        }catch(Exception ex){
            System.out.printf(ex.getMessage());
                    transaction.rollback();
        }
    }

    @Override
    public List<StudentEntity> getAll() {
        List<StudentEntity> students = new ArrayList<>();
        try{
            Query query  = entityManager.createQuery("select s from StudentEntity s");
            return query.getResultList();
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        return students;
    }

    @Override
    public void deleteStudent(int id) {
        try {
            transaction.begin();
            StudentEntity student = entityManager.find(StudentEntity.class, id);
            entityManager.remove(student);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public void updateStudent( StudentEntity student) {
        try {
            transaction.begin();
            StudentEntity s = entityManager.find(StudentEntity.class, student.getId());
            s.setName(student.getName());
            s.setBirthday(student.getBirthday());
            s.setPhone(student.getPhone());
            entityManager.merge(s);
            transaction.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            transaction.rollback();
        }
    }

    @Override
    public StudentEntity getById(int id) {
        StudentEntity student = new StudentEntity();
        try{
             student = entityManager.find(StudentEntity.class, id);
            return student;
        }catch (Exception ex) {
            System.out.printf(ex.getMessage());

        }
        return student;
    }
}
