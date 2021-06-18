package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {
    //todo 1: create a method to add(int firstVal, int secondVal) two number
    private double add(double firstVal, double secondVal){
        return firstVal+secondVal;
    }
    //todo 2: create a method to subtract two number
    private double subtract(int firstVal,double secondVal){
        return firstVal-secondVal;
    }
    //todo 3: create a method to multiply two number
    private double multiply(int firstVal,double secondVal){
        return firstVal*secondVal;
    }
    //todo 4: create a method to divide two number
    private double divide(int firstVal, double secondVal){
        return firstVal/secondVal;
    }
    //todo 5: create a method to computeLength of a string
    private int computeLength(String name){
        return name.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo 6: get all request parameters- firstValue , secondValue,name,action
        int firstValue=request.getParameter("firstVal")!=null?Integer.parseInt(request.getParameter("firstVal")):0;
        int secondValue=request.getParameter("secondVal")!=null?Integer.parseInt(request.getParameter("secondVal")):0;
        String name=request.getParameter("name");
        String action=request.getParameter("action");
        //todo 7: use if else to determine action is add or subtract or multiply or divide or computerLength
        //todo 8 : call method add, subtract , multiply, divide or computeLength based on action and get the calculated result
        //todo 9: if action =add or subtract or multiply or divide
        //todo 10 :create 3 cookie name cFirstValue, cSecondValue,cResult and set the value of cookie
        //todo 11 : add 3 cookies into response
        if(action.equals("subtract")||(action.equals("add"))||(action.equals("multiply"))||(action.equals("divide"))){
            double result=0;
            if(action.equals("add")){
                 result = add(firstValue, secondValue);}
            if(action.equals("subtract"))
                result = subtract(firstValue, secondValue);
            if(action.equals("multiply")){
                 result = multiply(firstValue, secondValue);}
            if(action.equals("divide")){
                result = divide(firstValue, secondValue);}
            Cookie cFirstValue=new Cookie("cFirstValue",String.valueOf(firstValue));
            Cookie cSecondValue=new Cookie("cSecondValue",String.valueOf(secondValue));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }
        //todo 12: if action =computeLength
        //todo 13 :create 2 cookies name cName, cLength and set the value
        //todo 14 : add 2 cookies into response
        else if(action.equals("computeLength")){
            int result=computeLength(name);
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",String.valueOf(result));
            response.addCookie(cName);
            response.addCookie(cLength);
        }

        //todo 13 : send redirect to cal.jsp
        response.sendRedirect("lab3/cal.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
