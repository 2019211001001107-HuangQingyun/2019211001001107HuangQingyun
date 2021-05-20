package com.HuangQingyun.controller;

import com.HuangQingyun.dao.ProductDao;
import com.HuangQingyun.model.Category;
import com.HuangQingyun.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value="/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215)   //upload file's size up to 16MB
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
         con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get all parameters
        String productName=request.getParameter("productName");
        double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):8;
        String productDescription=request.getParameter("productDescription");

        //get picture
        InputStream inputStream=null;
        Part fileParts=request.getPart("picture");

        if(fileParts!=null){
           inputStream=fileParts.getInputStream();
        }
        //set into model
        Product product=new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        //call same dao

        ProductDao productDao=new ProductDao();
        try {
            int n=productDao.save(product,con);

            //redirect
            if(n>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList=Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            String path="/WEB-INF/views/admin/addProduct.jsp";
            request.getRequestDispatcher(path).forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
