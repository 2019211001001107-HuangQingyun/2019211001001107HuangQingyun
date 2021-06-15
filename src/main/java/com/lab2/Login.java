package com.lab2;

public class Login {
    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Login{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
