package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/8/24.
 */
@Entity
@Table(name = "zhandian")
public class Zhandian {
    private int zhandianId;
    private String zhandianName;
    private Double zhandianJingdu;
    private Double zhandianWeidu;
    private String zhandianDizhi;
    private String zhandianMiaoshu;
    private Integer zhandianStatus;
    private String zhandianImage;
    private Integer zhandianYincang;
    private Integer zhandianXuhao;
    private String zhandianYuji;
    private Integer bancheId;

    @Id
    @Column(name = "zhandian_id")
    @GeneratedValue
    public int getZhandianId() {
        return zhandianId;
    }

    public void setZhandianId(int zhandianId) {
        this.zhandianId = zhandianId;
    }

    @Basic
    @Column(name = "zhandian_name")
    public String getZhandianName() {
        return zhandianName;
    }

    public void setZhandianName(String zhandianName) {
        this.zhandianName = zhandianName;
    }

    @Basic
    @Column(name = "zhandian_jingdu")
    public Double getZhandianJingdu() {
        return zhandianJingdu;
    }

    public void setZhandianJingdu(Double zhandianJingdu) {
        this.zhandianJingdu = zhandianJingdu;
    }

    @Basic
    @Column(name = "zhandian_weidu")
    public Double getZhandianWeidu() {
        return zhandianWeidu;
    }

    public void setZhandianWeidu(Double zhandianWeidu) {
        this.zhandianWeidu = zhandianWeidu;
    }

    @Basic
    @Column(name = "zhandian_dizhi")
    public String getZhandianDizhi() {
        return zhandianDizhi;
    }

    public void setZhandianDizhi(String zhandianDizhi) {
        this.zhandianDizhi = zhandianDizhi;
    }

    @Basic
    @Column(name = "zhandian_miaoshu")
    public String getZhandianMiaoshu() {
        return zhandianMiaoshu;
    }

    public void setZhandianMiaoshu(String zhandianMiaoshu) {
        this.zhandianMiaoshu = zhandianMiaoshu;
    }

    @Basic
    @Column(name = "zhandian_status")
    public Integer getZhandianStatus() {
        return zhandianStatus;
    }

    public void setZhandianStatus(Integer zhandianStatus) {
        this.zhandianStatus = zhandianStatus;
    }

    @Basic
    @Column(name = "zhandian_image")
    public String getZhandianImage() {
        return zhandianImage;
    }

    public void setZhandianImage(String zhandianImage) {
        this.zhandianImage = zhandianImage;
    }

    @Basic
    @Column(name = "zhandian_yincang")
    public Integer getZhandianYincang() {
        return zhandianYincang;
    }

    public void setZhandianYincang(Integer zhandianYincang) {
        this.zhandianYincang = zhandianYincang;
    }

    @Basic
    @Column(name = "zhandian_xuhao")
    public Integer getZhandianXuhao() {
        return zhandianXuhao;
    }

    public void setZhandianXuhao(Integer zhandianXuhao) {
        this.zhandianXuhao = zhandianXuhao;
    }

    @Basic
    @Column(name = "zhandian_yuji")
    public String getZhandianYuji() {
        return zhandianYuji;
    }

    public void setZhandianYuji(String zhandianYuji) {
        this.zhandianYuji = zhandianYuji;
    }

    @Basic
    @Column(name = "banche_id")
    public Integer getBancheId() {
        return bancheId;
    }

    public void setBancheId(Integer bancheId) {
        this.bancheId = bancheId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zhandian zhandian = (Zhandian) o;

        if (zhandianId != zhandian.zhandianId) return false;
        if (zhandianName != null ? !zhandianName.equals(zhandian.zhandianName) : zhandian.zhandianName != null)
            return false;
        if (zhandianJingdu != null ? !zhandianJingdu.equals(zhandian.zhandianJingdu) : zhandian.zhandianJingdu != null)
            return false;
        if (zhandianWeidu != null ? !zhandianWeidu.equals(zhandian.zhandianWeidu) : zhandian.zhandianWeidu != null)
            return false;
        if (zhandianDizhi != null ? !zhandianDizhi.equals(zhandian.zhandianDizhi) : zhandian.zhandianDizhi != null)
            return false;
        if (zhandianMiaoshu != null ? !zhandianMiaoshu.equals(zhandian.zhandianMiaoshu) : zhandian.zhandianMiaoshu != null)
            return false;
        if (zhandianStatus != null ? !zhandianStatus.equals(zhandian.zhandianStatus) : zhandian.zhandianStatus != null)
            return false;
        if (zhandianImage != null ? !zhandianImage.equals(zhandian.zhandianImage) : zhandian.zhandianImage != null)
            return false;
        if (zhandianYincang != null ? !zhandianYincang.equals(zhandian.zhandianYincang) : zhandian.zhandianYincang != null)
            return false;
        if (zhandianXuhao != null ? !zhandianXuhao.equals(zhandian.zhandianXuhao) : zhandian.zhandianXuhao != null)
            return false;
        if (zhandianYuji != null ? !zhandianYuji.equals(zhandian.zhandianYuji) : zhandian.zhandianYuji != null)
            return false;
        if (bancheId != null ? !bancheId.equals(zhandian.bancheId) : zhandian.bancheId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = zhandianId;
        result = 31 * result + (zhandianName != null ? zhandianName.hashCode() : 0);
        result = 31 * result + (zhandianJingdu != null ? zhandianJingdu.hashCode() : 0);
        result = 31 * result + (zhandianWeidu != null ? zhandianWeidu.hashCode() : 0);
        result = 31 * result + (zhandianDizhi != null ? zhandianDizhi.hashCode() : 0);
        result = 31 * result + (zhandianMiaoshu != null ? zhandianMiaoshu.hashCode() : 0);
        result = 31 * result + (zhandianStatus != null ? zhandianStatus.hashCode() : 0);
        result = 31 * result + (zhandianImage != null ? zhandianImage.hashCode() : 0);
        result = 31 * result + (zhandianYincang != null ? zhandianYincang.hashCode() : 0);
        result = 31 * result + (zhandianXuhao != null ? zhandianXuhao.hashCode() : 0);
        result = 31 * result + (zhandianYuji != null ? zhandianYuji.hashCode() : 0);
        result = 31 * result + (bancheId != null ? bancheId.hashCode() : 0);
        return result;
    }
}
