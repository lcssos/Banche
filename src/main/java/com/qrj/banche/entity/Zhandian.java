package com.qrj.banche.entity;

public class Zhandian {
    private Integer zhandianId;

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

    public Integer getZhandianId() {
        return zhandianId;
    }

    public void setZhandianId(Integer zhandianId) {
        this.zhandianId = zhandianId;
    }

    public String getZhandianName() {
        return zhandianName;
    }

    public void setZhandianName(String zhandianName) {
        this.zhandianName = zhandianName == null ? null : zhandianName.trim();
    }

    public Double getZhandianJingdu() {
        return zhandianJingdu;
    }

    public void setZhandianJingdu(Double zhandianJingdu) {
        this.zhandianJingdu = zhandianJingdu;
    }

    public Double getZhandianWeidu() {
        return zhandianWeidu;
    }

    public void setZhandianWeidu(Double zhandianWeidu) {
        this.zhandianWeidu = zhandianWeidu;
    }

    public String getZhandianDizhi() {
        return zhandianDizhi;
    }

    public void setZhandianDizhi(String zhandianDizhi) {
        this.zhandianDizhi = zhandianDizhi == null ? null : zhandianDizhi.trim();
    }

    public String getZhandianMiaoshu() {
        return zhandianMiaoshu;
    }

    public void setZhandianMiaoshu(String zhandianMiaoshu) {
        this.zhandianMiaoshu = zhandianMiaoshu == null ? null : zhandianMiaoshu.trim();
    }

    public Integer getZhandianStatus() {
        return zhandianStatus;
    }

    public void setZhandianStatus(Integer zhandianStatus) {
        this.zhandianStatus = zhandianStatus;
    }

    public String getZhandianImage() {
        return zhandianImage;
    }

    public void setZhandianImage(String zhandianImage) {
        this.zhandianImage = zhandianImage == null ? null : zhandianImage.trim();
    }

    public Integer getZhandianYincang() {
        return zhandianYincang;
    }

    public void setZhandianYincang(Integer zhandianYincang) {
        this.zhandianYincang = zhandianYincang;
    }

    public Integer getZhandianXuhao() {
        return zhandianXuhao;
    }

    public void setZhandianXuhao(Integer zhandianXuhao) {
        this.zhandianXuhao = zhandianXuhao;
    }

    public String getZhandianYuji() {
        return zhandianYuji;
    }

    public void setZhandianYuji(String zhandianYuji) {
        this.zhandianYuji = zhandianYuji == null ? null : zhandianYuji.trim();
    }

    public Integer getBancheId() {
        return bancheId;
    }

    public void setBancheId(Integer bancheId) {
        this.bancheId = bancheId;
    }
}