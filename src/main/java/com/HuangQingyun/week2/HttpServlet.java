package com.HuangQingyun.week2;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpServlet extends javax.servlet.http.HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter Writer=response.getWriter();

        Writer.println("Name:HuangQingyun");
        Writer.println("2019211001001107");
        Writer.println("Date and time:"+(new Date()));
    }
}
