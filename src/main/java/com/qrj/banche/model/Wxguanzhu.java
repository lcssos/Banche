package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/8/3.
 */
@Entity
@Table(name = "wxguanzhu")
public class Wxguanzhu {
    private int wxguanzhuId;
    private Integer wxguanzhuBanchid;
    private Integer wxguanzhuWxuserid;

    @Id
    @Column(name = "wxguanzhu_id")
    @GeneratedValue
    public int getWxguanzhuId() {
        return wxguanzhuId;
    }

    public void setWxguanzhuId(int wxguanzhuId) {
        this.wxguanzhuId = wxguanzhuId;
    }

    @Basic
    @Column(name = "wxguanzhu_banchid")
    public Integer getWxguanzhuBanchid() {
        return wxguanzhuBanchid;
    }

    public void setWxguanzhuBanchid(Integer wxguanzhuBanchid) {
        this.wxguanzhuBanchid = wxguanzhuBanchid;
    }

    @Basic
    @Column(name = "wxguanzhu_wxuserid")
    public Integer getWxguanzhuWxuserid() {
        return wxguanzhuWxuserid;
    }

    public void setWxguanzhuWxuserid(Integer wxguanzhuWxuserid) {
        this.wxguanzhuWxuserid = wxguanzhuWxuserid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wxguanzhu wxguanzhu = (Wxguanzhu) o;

        if (wxguanzhuId != wxguanzhu.wxguanzhuId) return false;
        if (wxguanzhuBanchid != null ? !wxguanzhuBanchid.equals(wxguanzhu.wxguanzhuBanchid) : wxguanzhu.wxguanzhuBanchid != null)
            return false;
        if (wxguanzhuWxuserid != null ? !wxguanzhuWxuserid.equals(wxguanzhu.wxguanzhuWxuserid) : wxguanzhu.wxguanzhuWxuserid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wxguanzhuId;
        result = 31 * result + (wxguanzhuBanchid != null ? wxguanzhuBanchid.hashCode() : 0);
        result = 31 * result + (wxguanzhuWxuserid != null ? wxguanzhuWxuserid.hashCode() : 0);
        return result;
    }
}
