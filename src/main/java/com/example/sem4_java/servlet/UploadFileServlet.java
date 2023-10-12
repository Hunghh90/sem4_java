package com.example.sem4_java.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet (value = "/upload-file")
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form method='post' action='fileuploadservlet' enctype='multipart/form-data'>");
        writer.write("<input type='file' name='file' />");
        writer.write("<input type='submit' value='Upload' />");
        writer.write("</form>");
        writer.write("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        for (Part part : req.getParts()) {
            part.write("C:\\Users\\micro\\IdeaProjects\\sem4_java\\public\\upload\\image\\" + fileName);
        }
        resp.getWriter().print("uploaded sucessfully.");
    }
}