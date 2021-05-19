package com.HuangQingyun.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet rs=null;
    public void init(){
//        ServletContext config= getServletConfig().getServletContext();
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");
//
//        try {
//            Class.forName(driver);
//            con= DriverManager.getConnection(url, username, password);
//            System.out.println("init->"+con);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con"); //调用上下文参数
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql="Select * from usertable";
        String SQL2="insert into usertable(username,password,email,Gender,birthdate) value(?,?,?,?,?)";

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String brithDate = request.getParameter("birthDate");
        try {
            pstmt=con.prepareStatement(SQL2);

            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4, gender);
            pstmt.setString(5,brithDate);
            System.out.println("sql:"+SQL2);
            int count=pstmt.executeUpdate();
            System.out.println("处理了"+count+"条数据");
            stmt=con.createStatement();
            rs=stmt.executeQuery(sql);
//            response.setContentType("text/html charset=utf-8");
            PrintWriter out=response.getWriter();
//            out.println("<table  border=\"1\">");
//            out.println("<tr>");
//            out.println("<td>"+"ID"+"</td>");
//            out.println("<td>"+"Username"+"</td>");
//            out.println("<td>"+"Password"+"</td>");
//            out.println("<td>"+"Email"+"</td>");
//            out.println("<td>"+"Gender"+"</td>");
//            out.println("<td>"+"Birthdate"+"</td>");
//            out.println("</tr>");
//            while(rs.next()) {
//                out.println("<tr>");
//                out.println("<td>" + rs.getString("id") + "</td>");
//                out.println("<td>" + rs.getString("username") + "</td>");
//                out.println("<td>" + rs.getString("password") + "</td>");
//                out.println("<td>" + rs.getString("email") + "</td>");
//                out.println("<td>" + rs.getString("Gender") + "</td>");
//                out.println("<td>" + rs.getDate("birthdate") + "</td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");
//            request.setAttribute("rsname",rs);
//        request.getRequestDispatcher("userList.jsp").forward(request,response);
//            System.out.println(" i am in RegisterServlet-> do Post() ->after forward()");
            response.sendRedirect("login");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
}
