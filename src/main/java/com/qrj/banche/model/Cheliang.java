package com.qrj.banche.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liujian on 15/8/21.
 */
@Entity
@Table(name = "cheliang")
public class Cheliang {
    private int cheliangId;

    @Id
    @javax.persistence.Column(name = "cheliang_id")
    public int getCheliangId() {
        return cheliangId;
    }

    public void setCheliangId(int cheliangId) {
        this.cheliangId = cheliangId;
    }

    private String cheliangChepai;

    @Basic
    @javax.persistence.Column(name = "cheliang_chepai")
    public String getCheliangChepai() {
        return cheliangChepai;
    }

    public void setCheliangChepai(String cheliangChepai) {
        this.cheliangChepai = cheliangChepai;
    }

    private Integer cheliangDaozhanshijian;

    @Basic
    @javax.persistence.Column(name = "cheliang_daozhanshijian")
    public Integer getCheliangDaozhanshijian() {
        return cheliangDaozhanshijian;
    }

    public void setCheliangDaozhanshijian(Integer cheliangDaozhanshijian) {
        this.cheliangDaozhanshijian = cheliangDaozhanshijian;
    }

    private String cheliangChexing;

    @Basic
    @javax.persistence.Column(name = "cheliang_chexing")
    public String getCheliangChexing() {
        return cheliangChexing;
    }

    public void setCheliangChexing(String cheliangChexing) {
        this.cheliangChexing = cheliangChexing;
    }

    private Integer cheliangZuoweishu;

    @Basic
    @javax.persistence.Column(name = "cheliang_zuoweishu")
    public Integer getCheliangZuoweishu() {
        return cheliangZuoweishu;
    }

    public void setCheliangZuoweishu(Integer cheliangZuoweishu) {
        this.cheliangZuoweishu = cheliangZuoweishu;
    }

    private Integer cheliangCheling;

    @Basic
    @javax.persistence.Column(name = "cheliang_cheling")
    public Integer getCheliangCheling() {
        return cheliangCheling;
    }

    public void setCheliangCheling(Integer cheliangCheling) {
        this.cheliangCheling = cheliangCheling;
    }

    private String cheliangJiashiyuan;

    @Basic
    @javax.persistence.Column(name = "cheliang_jiashiyuan")
    public String getCheliangJiashiyuan() {
        return cheliangJiashiyuan;
    }

    public void setCheliangJiashiyuan(String cheliangJiashiyuan) {
        this.cheliangJiashiyuan = cheliangJiashiyuan;
    }

    private String cheliangTele;

    @Basic
    @javax.persistence.Column(name = "cheliang_tele")
    public String getCheliangTele() {
        return cheliangTele;
    }

    public void setCheliangTele(String cheliangTele) {
        this.cheliangTele = cheliangTele;
    }

    private Integer cheliangWangfan;

    @Basic
    @javax.persistence.Column(name = "cheliang_wangfan")
    public Integer getCheliangWangfan() {
        return cheliangWangfan;
    }

    public void setCheliangWangfan(Integer cheliangWangfan) {
        this.cheliangWangfan = cheliangWangfan;
    }

    private String cheliangWangfantime;

    @Basic
    @javax.persistence.Column(name = "cheliang_wangfantime")
    public String getCheliangWangfantime() {
        return cheliangWangfantime;
    }

    public void setCheliangWangfantime(String cheliangWangfantime) {
        this.cheliangWangfantime = cheliangWangfantime;
    }

    private String cheliangImage;

    @Basic
    @javax.persistence.Column(name = "cheliang_image")
    public String getCheliangImage() {
        return cheliangImage;
    }

    public void setCheliangImage(String cheliangImage) {
        this.cheliangImage = cheliangImage;
    }

    private int bancheId;

    @Basic
    @javax.persistence.Column(name = "banche_id")
    public int getBancheId() {
        return bancheId;
    }

    public void setBancheId(int bancheId) {
        this.bancheId = bancheId;
    }

    private Long shebeiId;

    @Basic
    @javax.persistence.Column(name = "shebei_id")
    public Long getShebeiId() {
        return shebeiId;
    }

    public void setShebeiId(Long shebeiId) {
        this.shebeiId = shebeiId;
    }

    private Integer comdetId;

    @Basic
    @javax.persistence.Column(name = "comdet_id")
    public Integer getComdetId() {
        return comdetId;
    }

    public void setComdetId(Integer comdetId) {
        this.comdetId = comdetId;
    }

    private Integer cheliangCurrentzhandian;

    @Basic
    @javax.persistence.Column(name = "cheliang_currentzhandian")
    public Integer getCheliangCurrentzhandian() {
        return cheliangCurrentzhandian;
    }

    public void setCheliangCurrentzhandian(Integer cheliangCurrentzhandian) {
        this.cheliangCurrentzhandian = cheliangCurrentzhandian;
    }

    private Integer cheliangGotozhandian;

    @Basic
    @javax.persistence.Column(name = "cheliang_gotozhandian")
    public Integer getCheliangGotozhandian() {
        return cheliangGotozhandian;
    }

    public void setCheliangGotozhandian(Integer cheliangGotozhandian) {
        this.cheliangGotozhandian = cheliangGotozhandian;
    }

    private Long cheliangUpdatetime;

    @Basic
    @javax.persistence.Column(name = "cheliang_updatetime")
    public Long getCheliangUpdatetime() {
        return cheliangUpdatetime;
    }

    public void setCheliangUpdatetime(Long cheliangUpdatetime) {
        this.cheliangUpdatetime = cheliangUpdatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cheliang cheliang = (Cheliang) o;

        if (cheliangId != cheliang.cheliangId) return false;
        if (bancheId != cheliang.bancheId) return false;
        if (cheliangChepai != null ? !cheliangChepai.equals(cheliang.cheliangChepai) : cheliang.cheliangChepai != null)
            return false;
        if (cheliangDaozhanshijian != null ? !cheliangDaozhanshijian.equals(cheliang.cheliangDaozhanshijian) : cheliang.cheliangDaozhanshijian != null)
            return false;
        if (cheliangChexing != null ? !cheliangChexing.equals(cheliang.cheliangChexing) : cheliang.cheliangChexing != null)
            return false;
        if (cheliangZuoweishu != null ? !cheliangZuoweishu.equals(cheliang.cheliangZuoweishu) : cheliang.cheliangZuoweishu != null)
            return false;
        if (cheliangCheling != null ? !cheliangCheling.equals(cheliang.cheliangCheling) : cheliang.cheliangCheling != null)
            return false;
        if (cheliangJiashiyuan != null ? !cheliangJiashiyuan.equals(cheliang.cheliangJiashiyuan) : cheliang.cheliangJiashiyuan != null)
            return false;
        if (cheliangTele != null ? !cheliangTele.equals(cheliang.cheliangTele) : cheliang.cheliangTele != null)
            return false;
        if (cheliangWangfan != null ? !cheliangWangfan.equals(cheliang.cheliangWangfan) : cheliang.cheliangWangfan != null)
            return false;
        if (cheliangWangfantime != null ? !cheliangWangfantime.equals(cheliang.cheliangWangfantime) : cheliang.cheliangWangfantime != null)
            return false;
        if (cheliangImage != null ? !cheliangImage.equals(cheliang.cheliangImage) : cheliang.cheliangImage != null)
            return false;
        if (shebeiId != null ? !shebeiId.equals(cheliang.shebeiId) : cheliang.shebeiId != null) return false;
        if (comdetId != null ? !comdetId.equals(cheliang.comdetId) : cheliang.comdetId != null) return false;
        if (cheliangCurrentzhandian != null ? !cheliangCurrentzhandian.equals(cheliang.cheliangCurrentzhandian) : cheliang.cheliangCurrentzhandian != null)
            return false;
        if (cheliangGotozhandian != null ? !cheliangGotozhandian.equals(cheliang.cheliangGotozhandian) : cheliang.cheliangGotozhandian != null)
            return false;
        if (cheliangUpdatetime != null ? !cheliangUpdatetime.equals(cheliang.cheliangUpdatetime) : cheliang.cheliangUpdatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cheliangId;
        result = 31 * result + (cheliangChepai != null ? cheliangChepai.hashCode() : 0);
        result = 31 * result + (cheliangDaozhanshijian != null ? cheliangDaozhanshijian.hashCode() : 0);
        result = 31 * result + (cheliangChexing != null ? cheliangChexing.hashCode() : 0);
        result = 31 * result + (cheliangZuoweishu != null ? cheliangZuoweishu.hashCode() : 0);
        result = 31 * result + (cheliangCheling != null ? cheliangCheling.hashCode() : 0);
        result = 31 * result + (cheliangJiashiyuan != null ? cheliangJiashiyuan.hashCode() : 0);
        result = 31 * result + (cheliangTele != null ? cheliangTele.hashCode() : 0);
        result = 31 * result + (cheliangWangfan != null ? cheliangWangfan.hashCode() : 0);
        result = 31 * result + (cheliangWangfantime != null ? cheliangWangfantime.hashCode() : 0);
        result = 31 * result + (cheliangImage != null ? cheliangImage.hashCode() : 0);
        result = 31 * result + bancheId;
        result = 31 * result + (shebeiId != null ? shebeiId.hashCode() : 0);
        result = 31 * result + (comdetId != null ? comdetId.hashCode() : 0);
        result = 31 * result + (cheliangCurrentzhandian != null ? cheliangCurrentzhandian.hashCode() : 0);
        result = 31 * result + (cheliangGotozhandian != null ? cheliangGotozhandian.hashCode() : 0);
        result = 31 * result + (cheliangUpdatetime != null ? cheliangUpdatetime.hashCode() : 0);
        return result;
    }
}
