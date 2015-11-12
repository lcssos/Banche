package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/8/13.
 */
@Entity
@Table(name = "wxlocation")
public class Wxlocation {
    private String openId;
    private Double jingdu;
    private Double weidu;

    @Id
    @Column(name = "openId")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "jingdu")
    public Double getJingdu() {
        return jingdu;
    }

    public void setJingdu(Double jingdu) {
        this.jingdu = jingdu;
    }

    @Basic
    @Column(name = "weidu")
    public Double getWeidu() {
        return weidu;
    }

    public void setWeidu(Double weidu) {
        this.weidu = weidu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wxlocation that = (Wxlocation) o;

        if (openId != null ? !openId.equals(that.openId) : that.openId != null) return false;
        if (jingdu != null ? !jingdu.equals(that.jingdu) : that.jingdu != null) return false;
        if (weidu != null ? !weidu.equals(that.weidu) : that.weidu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = openId != null ? openId.hashCode() : 0;
        result = 31 * result + (jingdu != null ? jingdu.hashCode() : 0);
        result = 31 * result + (weidu != null ? weidu.hashCode() : 0);
        return result;
    }
}
