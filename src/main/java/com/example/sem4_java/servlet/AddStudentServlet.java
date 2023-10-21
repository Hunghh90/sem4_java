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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(value = "/add-student")
public class AddStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init(){
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.printf("<h1>Add Student</h1>");
        out.printf("<form action='add-student' method='POST'");
        out.printf("<table>");
        out.print("<tr><td>Student Code:</td><td><input type='text' name='studentCode'/></td></tr><br/>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name'/></td></tr><br/>");
        out.print("<tr><td>Birthday:</td><td><input type='date' name='birthday'/></td></tr><br/>");
        out.print("<tr><td>Phone:</td><td><input type='text' name='phone'/></td></tr><br/>");
        out.print("<tr><td colspan='2'><input type='submit' value='Submit '/></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
          String name = req.getParameter("name");
          String birthday = req.getParameter("birthday");
          String phone = req.getParameter("phone");
          Date bod = dateFormat.parse(birthday);
          StudentEntity student = new StudentEntity(name,bod,phone);
          studentDAO.createStudent(student);
          resp.sendRedirect("/list-student");
      }catch (Exception ex){
          System.out.printf(ex.getMessage());
      }
    }
}