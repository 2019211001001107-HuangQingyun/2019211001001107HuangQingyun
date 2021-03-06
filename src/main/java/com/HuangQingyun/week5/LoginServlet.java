package com.HuangQingyun.week5;

import com.HuangQingyun.dao.UserDao;
import com.HuangQingyun.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out=response.getWriter();

//            pstmt=con.prepareStatement(sql);
//            pstmt.setString(1,username);
//            pstmt.setString(2,password);
//            rs=pstmt.executeQuery();
//            response.setContentType("text/html");

//            out.println("<HTML>");
//            out.println("<HEAD><TITLE>UsingServlet</TITLE></HEAD>");
//            out.println("<Body>");
            UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){

                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null&&rememberMe.equals("1")){  //want to remember  create 3 cookies
                    Cookie UsernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie PasswordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie RememberMeCookie = new Cookie("cRememberMe",rememberMe);
                    UsernameCookie.setMaxAge(10);
                    PasswordCookie.setMaxAge(10);
                    RememberMeCookie.setMaxAge(10);
                    response.addCookie(UsernameCookie);
                    response.addCookie(PasswordCookie);
                    response.addCookie(RememberMeCookie);
                }
                // week 8 code --demo#1  use cookie for session
                HttpSession session = request.getSession();
                System.out.println("session id  ---"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
//            if(rs.next()){
//                request.setAttribute("id",rs.getString("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("Gender",rs.getString("Gender"));
//                request.setAttribute("birthdate",rs.getDate("birthdate"));
//
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//
//            }else{
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//
//            }
//            out.println("</HTML>");
//            out.println("</Body>");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
