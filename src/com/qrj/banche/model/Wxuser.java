package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/8/3.
 */
@Entity
@Table(name = "wxuser")
public class Wxuser {
    private int wxuserId;
    private String wxuserUsername;
    private String wxuserPassword;
    private String wxuserTele;
    private String wxuserQuanxian;
    private String wxuserTouxiang;

    @Id
    @Column(name = "wxuser_id")
    @GeneratedValue
    public int getWxuserId() {
        return wxuserId;
    }

    public void setWxuserId(int wxuserId) {
        this.wxuserId = wxuserId;
    }

    @Basic
    @Column(name = "wxuser_username")
    public String getWxuserUsername() {
        return wxuserUsername;
    }

    public void setWxuserUsername(String wxuserUsername) {
        this.wxuserUsername = wxuserUsername;
    }

    @Basic
    @Column(name = "wxuser_password")
    public String getWxuserPassword() {
        return wxuserPassword;
    }

    public void setWxuserPassword(String wxuserPassword) {
        this.wxuserPassword = wxuserPassword;
    }

    @Basic
    @Column(name = "wxuser_tele")
    public String getWxuserTele() {
        return wxuserTele;
    }

    public void setWxuserTele(String wxuserTele) {
        this.wxuserTele = wxuserTele;
    }

    @Basic
    @Column(name = "wxuser_quanxian")
    public String getWxuserQuanxian() {
        return wxuserQuanxian;
    }

    public void setWxuserQuanxian(String wxuserQuanxian) {
        this.wxuserQuanxian = wxuserQuanxian;
    }

    @Basic
    @Column(name = "wxuser_touxiang")
    public String getWxuserTouxiang() {
        return wxuserTouxiang;
    }

    public void setWxuserTouxiang(String wxuserTouxiang) {
        this.wxuserTouxiang = wxuserTouxiang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wxuser wxuser = (Wxuser) o;

        if (wxuserId != wxuser.wxuserId) return false;
        if (wxuserUsername != null ? !wxuserUsername.equals(wxuser.wxuserUsername) : wxuser.wxuserUsername != null)
            return false;
        if (wxuserPassword != null ? !wxuserPassword.equals(wxuser.wxuserPassword) : wxuser.wxuserPassword != null)
            return false;
        if (wxuserTele != null ? !wxuserTele.equals(wxuser.wxuserTele) : wxuser.wxuserTele != null) return false;
        if (wxuserQuanxian != null ? !wxuserQuanxian.equals(wxuser.wxuserQuanxian) : wxuser.wxuserQuanxian != null)
            return false;
        if (wxuserTouxiang != null ? !wxuserTouxiang.equals(wxuser.wxuserTouxiang) : wxuser.wxuserTouxiang != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wxuserId;
        result = 31 * result + (wxuserUsername != null ? wxuserUsername.hashCode() : 0);
        result = 31 * result + (wxuserPassword != null ? wxuserPassword.hashCode() : 0);
        result = 31 * result + (wxuserTele != null ? wxuserTele.hashCode() : 0);
        result = 31 * result + (wxuserQuanxian != null ? wxuserQuanxian.hashCode() : 0);
        result = 31 * result + (wxuserTouxiang != null ? wxuserTouxiang.hashCode() : 0);
        return result;
    }
}
