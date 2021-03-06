package com.HuangQingyun.controller;

import com.HuangQingyun.dao.OrderDao;
import com.HuangQingyun.model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet",value ="/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
        Item item=new Item();
        OrderDao orderDao=new OrderDao();
        List<Item> itemList=orderDao.findItemsByOrderId(con,orderId);//get all items in a order
        request.setAttribute("itemList",itemList);
        String path="orderDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }
}
