package com.qrj.banche.entity;

public class Wxaccesstoken {
    private Integer id;

    private String accessToken;

    private String expirestime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getExpirestime() {
        return expirestime;
    }

    public void setExpirestime(String expirestime) {
        this.expirestime = expirestime == null ? null : expirestime.trim();
    }
}