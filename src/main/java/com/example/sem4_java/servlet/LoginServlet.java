package com.example.sem4_java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Writer;

@WebServlet (value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private  final String username1 = "admin";
    private  final String password1 = "admin";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form action='login-servlet' method='POST' >");
        writer.write("<input type='text' name='username' />");
        writer.write("<input type='password' name='password' />");
        writer.write("<input type='submit' value='Submit' />");
        writer.write("</form>");
        writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals(username1) && password.equals(password1)) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                resp.sendRedirect("/");
            } else {
                resp.sendRedirect("/login-servlet");
            }
        }catch (Exception ex){
            log(ex.getMessage());
        }
    }
}