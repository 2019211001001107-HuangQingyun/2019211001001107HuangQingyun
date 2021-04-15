package com.HuangQingyun.week5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet" ,value="/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sql="Select * from usertable where username=? and password=?";
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        try {
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
//            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
//            out.println("<HTML>");
//            out.println("<HEAD><TITLE>UsingServlet</TITLE></HEAD>");
//            out.println("<Body>");

            if(rs.next()){
                request.setAttribute("id",rs.getString("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("Gender",rs.getString("Gender"));
                request.setAttribute("birthdate",rs.getDate("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }
            out.println("</HTML>");
            out.println("</Body>");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
