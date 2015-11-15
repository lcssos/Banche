package com.qrj.banche.entity;

public class Shebei {
    private Long shebeiId;

    private Double shebeiJingdu;

    private Double shebeiWeidu;

    private Integer shebeiSudu;

    private String shebeiShijian;

    public Long getShebeiId() {
        return shebeiId;
    }

    public void setShebeiId(Long shebeiId) {
        this.shebeiId = shebeiId;
    }

    public Double getShebeiJingdu() {
        return shebeiJingdu;
    }

    public void setShebeiJingdu(Double shebeiJingdu) {
        this.shebeiJingdu = shebeiJingdu;
    }

    public Double getShebeiWeidu() {
        return shebeiWeidu;
    }

    public void setShebeiWeidu(Double shebeiWeidu) {
        this.shebeiWeidu = shebeiWeidu;
    }

    public Integer getShebeiSudu() {
        return shebeiSudu;
    }

    public void setShebeiSudu(Integer shebeiSudu) {
        this.shebeiSudu = shebeiSudu;
    }

    public String getShebeiShijian() {
        return shebeiShijian;
    }

    public void setShebeiShijian(String shebeiShijian) {
        this.shebeiShijian = shebeiShijian == null ? null : shebeiShijian.trim();
    }
}