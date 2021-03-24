package com.HuangQingyun.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String passname = request.getParameter("Passname");
        String email = request.getParameter("Email");
        String gender = request.getParameter("Gender");
        String brithDate = request.getParameter("BrithDate");
        PrintWriter writer = response.getWriter();
        writer.println("Username:"+username);
        writer.println("Passname:"+passname);
        writer.println("Email:"+email);
        writer.println("Gender:"+gender);
        writer.println("BrithDate:"+brithDate);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
