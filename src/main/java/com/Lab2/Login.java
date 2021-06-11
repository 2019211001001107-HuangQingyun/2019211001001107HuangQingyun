package com.Lab2;

public class Login {
    private String username;
    private String password;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwork) {
        this.password = passwork;
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", passwork='" + password + '\'' +
                '}';
    }
}
