package com.example.maverick;

public class User {
    String email;
    String password;
    String sex;
    String phone;
    String username;
    String fullname;


    public User() {
    }

    public User(String email, String password, String sex, String phone, String username, String fullname) {
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.username = username;
        this.fullname = fullname;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
