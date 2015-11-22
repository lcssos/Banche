package com.qrj.banche.entity;

/**
 * Created by lcssos on 15/11/21.
 */
public class ZhandianCheci {
    private Integer id;
    private Integer checiId;
    private Zhandian zhandian;
    private String zhandianYuji;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheciId() {
        return checiId;
    }

    public void setCheciId(Integer checiId) {
        this.checiId = checiId;
    }

    public Zhandian getZhandian() {
        return zhandian;
    }

    public void setZhandian(Zhandian zhandian) {
        this.zhandian = zhandian;
    }

    public String getZhandianYuji() {
        return zhandianYuji;
    }

    public void setZhandianYuji(String zhandianYuji) {
        this.zhandianYuji = zhandianYuji;
    }
}
