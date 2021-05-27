package com.HuangQingyun.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt=request.getParameter("txt");
        String search = request.getParameter("search");
        System.out.println(txt);
        System.out.println(search);
        if(search.isEmpty()){
            response.sendRedirect("http://www.baidu.com");
        }
        else  {
            if (search.equals("baidu")){
                response.sendRedirect("http://www.baidu.com/s?wd="+txt);
            }
            else if (search.equals("bing")) {
                response.sendRedirect("http://www.bing.com/search?q="+txt);
            }
            else if (search.equals("google")) {
                response.sendRedirect("http://www.google.com/search?q="+txt);
            }
        }
    }
}
