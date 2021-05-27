package com.HuangQingyun.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int CategoryId;
    private String CategoryName;
    private String Description;
    private Boolean active;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String description, Boolean active) {
        CategoryId = categoryId;
        CategoryName = categoryName;
        Description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryId=" + CategoryId +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", active=" + active +
                '}';
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException{
        String sql="select * from Category";
        List<Category> list=new ArrayList<Category>();
        PreparedStatement pt=con.prepareStatement(sql);
        ResultSet rs=pt.executeQuery();
        while(rs.next()){
            Category c=new Category();
            c.setCategoryId(rs.getInt("CategoryId"));
            c.setCategoryName(rs.getString("CategoryName"));
            c.setDescription(rs.getString("Description"));
            list.add(c);
        }
        return list;
    }
    public static String findByCategoryId(Connection con,int CategoryId) throws SQLException{
        String sql="select * from Category where CategoryId=?";

        PreparedStatement pt=con.prepareStatement(sql);
        pt.setInt(1,CategoryId);
        ResultSet rs=pt.executeQuery();
        String CategoryName=null;
        while(rs.next()){
           CategoryName=rs.getString("CategoryName");
        }
        return CategoryName;
    }
}
