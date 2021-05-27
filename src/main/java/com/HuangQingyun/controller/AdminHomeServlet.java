package com.HuangQingyun.controller;

import com.HuangQingyun.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminHomeServlet",value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.get Username from session
        HttpSession session = request.getSession(false); //r    eturn session or null(no session) but not create a new session
        if(session !=null && session.getAttribute("user")!=null){
            //2. if username = admin --forward to WEB/admin/index.jsp
            User user= (User) session.getAttribute("user");
            if("admin".equals(user.getUsername())){
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request,response);
            }else{
                //have session but not admin user
                session.invalidate(); //kill session right now
                request.setAttribute("message","Unauthorized Access Admin Module !!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
            }
        }else{
            // no session
            request.setAttribute("message","Please login as admin");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request,response);
        }
    }
}
