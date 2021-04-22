package com.HuangQingyun.dao;


import com.HuangQingyun.model.User;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="Insert into userdb values(?,?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);
                          //Temporarily uncertain in what form to output, so tentatively
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {

        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        return 0;
    }

    @Override
    public User findById(Connection con, String id) throws SQLException {
        String sql="Select * from usertable where id=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,id);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        String sql="Select * from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();

        User user=null;
        if(rs.next()){
          user=new User();
          user.setId(rs.getString(1));
          user.setUsername(rs.getString(2));
          user.setPassword(rs.getString(3));
          user.setEmail(rs.getString(4));
          user.setGender(rs.getString(5));
          user.setBirthdate(rs.getDate(6));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="Select * from usertable where username=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="Select * from usertable where password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="Select * from usertable where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="Select * from usertable where gender=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;

    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="Select * from usertable where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setDate(1,birthDate);
        ResultSet rs=st.executeQuery();
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="Select * from usertable";
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(sql);
        User user=null;
        List<User> ls =new ArrayList<User>();
        if(rs.next()){
            user=new User();
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setGender(rs.getString(5));
            user.setBirthdate(rs.getDate(6));
            ls.add(user);
        }
        return ls;
    }
}
