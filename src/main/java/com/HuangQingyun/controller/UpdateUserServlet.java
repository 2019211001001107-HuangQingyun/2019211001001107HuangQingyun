package com.HuangQingyun.controller;

import com.HuangQingyun.dao.UserDao;
import com.HuangQingyun.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value ="/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.get all parameter
        String Id=request.getParameter("id");
        String username=request.getParameter("Username");
        String password=request.getParameter("Password");
        String email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String Birthdate=request.getParameter("BrithDate");
        //create object and set  value
        User user=new User();
        user.setId(Integer.parseInt(Id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(Gender);
        user.setBirthdate(Date.valueOf(Birthdate));
        //create userDao
        UserDao userDao=new UserDao();
        //call updateUser() in UserDao
        Connection con= (Connection) getServletContext().getAttribute("con");
        try {
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",user);

            if(userDao.updateUser(con,user)>0){
                request.getRequestDispatcher("accountDetails").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/UpdateUser.jsp").forward(request,response);
    }
}
