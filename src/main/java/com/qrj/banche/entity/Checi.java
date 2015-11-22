package com.qrj.banche.entity;

/**
 * Created by lcssos on 15/11/19.
 */
public class Checi {
    private Integer id;
    private Banche banche;
    private Cheliang cheliang;
    //发车时间
    private String fache;


    public String getFache() {
        return fache;
    }

    public void setFache(String fache) {
        this.fache = fache;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Banche getBanche() {
        return banche;
    }

    public void setBanche(Banche banche) {
        this.banche = banche;
    }

    public Cheliang getCheliang() {
        return cheliang;
    }

    public void setCheliang(Cheliang cheliang) {
        this.cheliang = cheliang;
    }
}
