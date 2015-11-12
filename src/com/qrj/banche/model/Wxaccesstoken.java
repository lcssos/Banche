package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/8/13.
 */
@Entity
@Table(name = "wxaccesstoken")
public class Wxaccesstoken {
    //id 1 是普通，基础支持 2是JS用
    private int id;
    private String accessToken;
    private String expirestime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "expirestime")
    public String getExpirestime() {
        return expirestime;
    }

    public void setExpirestime(String expirestime) {
        this.expirestime = expirestime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wxaccesstoken that = (Wxaccesstoken) o;

        if (id != that.id) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (expirestime != null ? !expirestime.equals(that.expirestime) : that.expirestime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (expirestime != null ? expirestime.hashCode() : 0);
        return result;
    }
}
