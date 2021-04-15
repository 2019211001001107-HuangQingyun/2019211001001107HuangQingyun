package com.HuangQingyun.week4.demo;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/jdbcdemo"},
        initParams = {
//                @WebInitParam(name="driver",value = "com.mysql.cj.jdbc.Driver"),
//                @WebInitParam(name="url",value = "jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC"),
//                @WebInitParam(name="username",value = "root"),
//                @WebInitParam(name="password",value = "940818"),

        },loadOnStartup =1

)
public class JDBCDemoServlet extends HttpServlet {

    Connection con=null;
    public void init(){
//        ServletContext config= getServletConfig().getServletContext();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//             con= DriverManager.getConnection(url, username, password);
//            System.out.println("init->"+con);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String driver="com.mysql.cj.jdbc.Driver";
//        String url="jdbc:mysql://localhost:3306/userdb?serverTimezone=UTC";
//        String username="root";
//        String password="940818";
//
//        try {
//            Class.forName(driver);
//            Connection con= DriverManager.getConnection(url, username, password);
//            System.out.println("->"+con);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
