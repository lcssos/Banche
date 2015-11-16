package com.qrj.banche.vo;

/**
 * Created by lcssos on 15/11/16.
 */
public class Wxgeo {
    private String bancheName;
    private String zhandianName;
    private Double zhandianJingdu;
    private Double zhandianWeidu;
    private String zhandianDizhi;
    private String zhandianMiaoshu;
    private Double distance;


    public String getZhandianDizhi() {
        return zhandianDizhi;
    }

    public void setZhandianDizhi(String zhandianDizhi) {
        this.zhandianDizhi = zhandianDizhi;
    }

    public String getBancheName() {
        return bancheName;
    }

    public void setBancheName(String bancheName) {
        this.bancheName = bancheName;
    }

    public String getZhandianName() {
        return zhandianName;
    }

    public void setZhandianName(String zhandianName) {
        this.zhandianName = zhandianName;
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

    public String getZhandianMiaoshu() {
        return zhandianMiaoshu;
    }

    public void setZhandianMiaoshu(String zhandianMiaoshu) {
        this.zhandianMiaoshu = zhandianMiaoshu;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
