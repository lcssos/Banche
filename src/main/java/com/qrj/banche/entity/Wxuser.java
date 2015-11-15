package com.qrj.banche.entity;

public class Wxuser {
    private Integer wxuserId;

    private String wxuserUsername;

    private String wxuserPassword;

    private String wxuserTele;

    private String wxuserQuanxian;

    private String wxuserTouxiang;

    public Integer getWxuserId() {
        return wxuserId;
    }

    public void setWxuserId(Integer wxuserId) {
        this.wxuserId = wxuserId;
    }

    public String getWxuserUsername() {
        return wxuserUsername;
    }

    public void setWxuserUsername(String wxuserUsername) {
        this.wxuserUsername = wxuserUsername == null ? null : wxuserUsername.trim();
    }

    public String getWxuserPassword() {
        return wxuserPassword;
    }

    public void setWxuserPassword(String wxuserPassword) {
        this.wxuserPassword = wxuserPassword == null ? null : wxuserPassword.trim();
    }

    public String getWxuserTele() {
        return wxuserTele;
    }

    public void setWxuserTele(String wxuserTele) {
        this.wxuserTele = wxuserTele == null ? null : wxuserTele.trim();
    }

    public String getWxuserQuanxian() {
        return wxuserQuanxian;
    }

    public void setWxuserQuanxian(String wxuserQuanxian) {
        this.wxuserQuanxian = wxuserQuanxian == null ? null : wxuserQuanxian.trim();
    }

    public String getWxuserTouxiang() {
        return wxuserTouxiang;
    }

    public void setWxuserTouxiang(String wxuserTouxiang) {
        this.wxuserTouxiang = wxuserTouxiang == null ? null : wxuserTouxiang.trim();
    }
}