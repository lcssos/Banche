package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/14.
 */
@Entity
@Table(name = "comdet")
public class Comdet {
    private int comdetId;
    private String comdetName;
    private String comdetJianjie;
    private String comdetDizhi;
    private String comdetLianxiren;
    private String comdetLianxitele;

    @Id
    @Column(name = "comdet_id")
    @GeneratedValue
    public int getComdetId() {
        return comdetId;
    }

    public void setComdetId(int comdetId) {
        this.comdetId = comdetId;
    }

    @Basic
    @Column(name = "comdet_name")
    public String getComdetName() {
        return comdetName;
    }

    public void setComdetName(String comdetName) {
        this.comdetName = comdetName;
    }

    @Basic
    @Column(name = "comdet_jianjie")
    public String getComdetJianjie() {
        return comdetJianjie;
    }

    public void setComdetJianjie(String comdetJianjie) {
        this.comdetJianjie = comdetJianjie;
    }

    @Basic
    @Column(name = "comdet_dizhi")
    public String getComdetDizhi() {
        return comdetDizhi;
    }

    public void setComdetDizhi(String comdetDizhi) {
        this.comdetDizhi = comdetDizhi;
    }

    @Basic
    @Column(name = "comdet_lianxiren")
    public String getComdetLianxiren() {
        return comdetLianxiren;
    }

    public void setComdetLianxiren(String comdetLianxiren) {
        this.comdetLianxiren = comdetLianxiren;
    }

    @Basic
    @Column(name = "comdet_lianxitele")
    public String getComdetLianxitele() {
        return comdetLianxitele;
    }

    public void setComdetLianxitele(String comdetLianxitele) {
        this.comdetLianxitele = comdetLianxitele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comdet comdet = (Comdet) o;

        if (comdetId != comdet.comdetId) return false;
        if (comdetName != null ? !comdetName.equals(comdet.comdetName) : comdet.comdetName != null) return false;
        if (comdetJianjie != null ? !comdetJianjie.equals(comdet.comdetJianjie) : comdet.comdetJianjie != null)
            return false;
        if (comdetDizhi != null ? !comdetDizhi.equals(comdet.comdetDizhi) : comdet.comdetDizhi != null) return false;
        if (comdetLianxiren != null ? !comdetLianxiren.equals(comdet.comdetLianxiren) : comdet.comdetLianxiren != null)
            return false;
        if (comdetLianxitele != null ? !comdetLianxitele.equals(comdet.comdetLianxitele) : comdet.comdetLianxitele != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = comdetId;
        result = 31 * result + (comdetName != null ? comdetName.hashCode() : 0);
        result = 31 * result + (comdetJianjie != null ? comdetJianjie.hashCode() : 0);
        result = 31 * result + (comdetDizhi != null ? comdetDizhi.hashCode() : 0);
        result = 31 * result + (comdetLianxiren != null ? comdetLianxiren.hashCode() : 0);
        result = 31 * result + (comdetLianxitele != null ? comdetLianxitele.hashCode() : 0);
        return result;
    }
}
