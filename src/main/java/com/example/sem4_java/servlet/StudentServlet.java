package com.example.sem4_java.servlet;

import com.example.sem4_java.daos.StudentDAO;
import com.example.sem4_java.daos.impl.StudentDAOImpl;
import com.example.sem4_java.entities.StudentEntity;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet(value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO;
    public void init(){
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int pageSize = 2;
            List<StudentEntity> students = studentDAO.getAll();
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, students.size());

        List<StudentEntity> currentPageItems = students.subList(startIndex, endIndex);

        req.setAttribute("students", students);
        req.setAttribute("currentPageItems", currentPageItems);

            req.getRequestDispatcher("/listStudent.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action").equals("edit")){
            StudentEntity student = studentDAO.getById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("student",student);
            req.getRequestDispatcher("/editStudent.jsp").forward(req, resp);
        }
        if (req.getParameter("action").equals("editStudent")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                StudentEntity st = new StudentEntity(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        dateFormat.parse(req.getParameter("birthday")),
                        req.getParameter("phone")
                );
                studentDAO.updateStudent(st);
                resp.sendRedirect("student-servlet?page=1");
            }catch (Exception ex){
                System.out.printf(ex.getMessage());
            }
        }
        if (req.getParameter("action").equals("delete")){
             studentDAO.deleteStudent(Integer.parseInt(req.getParameter("id")));
            resp.sendRedirect("student-servlet?page=1");
        }
    if (req.getParameter("action").equals("addStudent")){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            StudentEntity st = new StudentEntity(
                    req.getParameter("name"),
                    dateFormat.parse(req.getParameter("birthday")),
                    req.getParameter("phone")
            );
            studentDAO.createStudent(st);
            resp.sendRedirect("student-servlet?page=1");
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        }
    }

}
