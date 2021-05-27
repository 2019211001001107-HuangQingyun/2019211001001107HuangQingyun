package com.HuangQingyun.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext config= sce.getServletContext();
        String driver = config.getInitParameter("driver");  //<param-name>driver</param-name>
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);

            Connection con= DriverManager.getConnection(url, username, password);
            System.out.println("init->"+con);
            config.setAttribute("con",con);    //设置一个参数
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(" i am in contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println(" i am in contextEvent destoryed()");
        sce.getServletContext().removeAttribute("con");
    }
}
