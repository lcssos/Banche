package com.qrj.banche.entity;

public class Comdet {
    private Integer comdetId;

    private String comdetName;

    private String comdetJianjie;

    private String comdetDizhi;

    private String comdetLianxiren;

    private String comdetLianxitele;

    public Integer getComdetId() {
        return comdetId;
    }

    public void setComdetId(Integer comdetId) {
        this.comdetId = comdetId;
    }

    public String getComdetName() {
        return comdetName;
    }

    public void setComdetName(String comdetName) {
        this.comdetName = comdetName == null ? null : comdetName.trim();
    }

    public String getComdetJianjie() {
        return comdetJianjie;
    }

    public void setComdetJianjie(String comdetJianjie) {
        this.comdetJianjie = comdetJianjie == null ? null : comdetJianjie.trim();
    }

    public String getComdetDizhi() {
        return comdetDizhi;
    }

    public void setComdetDizhi(String comdetDizhi) {
        this.comdetDizhi = comdetDizhi == null ? null : comdetDizhi.trim();
    }

    public String getComdetLianxiren() {
        return comdetLianxiren;
    }

    public void setComdetLianxiren(String comdetLianxiren) {
        this.comdetLianxiren = comdetLianxiren == null ? null : comdetLianxiren.trim();
    }

    public String getComdetLianxitele() {
        return comdetLianxitele;
    }

    public void setComdetLianxitele(String comdetLianxitele) {
        this.comdetLianxitele = comdetLianxitele == null ? null : comdetLianxitele.trim();
    }
}