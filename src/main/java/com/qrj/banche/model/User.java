package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/13.
 */
@Entity
@Table(name = "user")
public class User {
    private int userId;
    private String userName;
    private String userPassword;
    private String userQuanxian;

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_quanxian")
    public String getUserQuanxian() {
        return userQuanxian;
    }

    public void setUserQuanxian(String userQuanxian) {
        this.userQuanxian = userQuanxian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userQuanxian != null ? !userQuanxian.equals(user.userQuanxian) : user.userQuanxian != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userQuanxian != null ? userQuanxian.hashCode() : 0);
        return result;
    }
}
