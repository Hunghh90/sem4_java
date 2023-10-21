//package com.example.sem4_java.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet(value = "/asynchronous", asyncSupported = false)
//public class AsynchronousServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.printf("<html><body>");
//        out.printf("<h1>Synchronous</h1>");
//        out.printf("<progress id='progress' max=100>Synchronous</progress>");
//        int i=0;70
//        while (i<=100);
//        out.printf("<script></script>");
//        out.printf("</body></html>");
//    }
//}