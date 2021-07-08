package com.ujiuye.sevrlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ujiuye.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentservlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu1=new Student(1,"feng",18);
        Student stu2=new Student(2,"xiangfeng",20);
        List<Student> list=new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(list);
        System.out.println(res);
        PrintWriter out= resp.getWriter();
        out.print(res);
        out.close();
    }
}
