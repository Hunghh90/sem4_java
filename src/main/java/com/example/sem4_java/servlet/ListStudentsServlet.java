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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/list-student")
public class ListStudentsServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init(){
        studentDAO = new StudentDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<StudentEntity> studentList = studentDAO.getAll();
        req.setAttribute("studentList",studentList);
        PrintWriter out=resp.getWriter();
        out.println("<a href='add-student'>Add New Student</a>");
        out.println("<h1>Employees List</h1>");
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>Birthday</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>");

        for(StudentEntity s:studentList){
            out.print("<tr><td>"+s.getId()+
                    "</td><td>"+s.getName()+
                    "</td><td>"+s.getBirthday()+
                    "</td><td>"+s.getPhone()+
                    "</td><td><a href='EditServlet?id="+s.getId()+
                    "'>edit</a></td><td><a href='DeleteServlet?id="+s.getId()+"'>delete</a></td></tr>");


        }
        out.print("</table>");

        out.close();
    }
}