package com.HuangQingyun.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name ="name",value = "HuangQingyun"),
                @WebInitParam(name ="studentID",value = "2019211001001107"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name = config.getInitParameter("name");
        String studentID = config.getInitParameter("studentID");
        PrintWriter writer = response.getWriter();
        writer.println("name :"+name);
        writer.println("studentID :"+studentID);
    }
}
