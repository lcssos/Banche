package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/24.
 */
@Entity
@Table(name = "shebei")
public class Shebei {
    private long shebeiId;
    private Double shebeiJingdu;
    private Double shebeiWeidu;
    private Integer shebeiSudu;
    private String shebeiShijian;

    @Id
    @Column(name = "shebei_id")
    public long getShebeiId() {
        return shebeiId;
    }

    public void setShebeiId(long shebeiId) {
        this.shebeiId = shebeiId;
    }

    @Basic
    @Column(name = "shebei_jingdu")
    public Double getShebeiJingdu() {
        return shebeiJingdu;
    }

    public void setShebeiJingdu(Double shebeiJingdu) {
        this.shebeiJingdu = shebeiJingdu;
    }

    @Basic
    @Column(name = "shebei_weidu")
    public Double getShebeiWeidu() {
        return shebeiWeidu;
    }

    public void setShebeiWeidu(Double shebeiWeidu) {
        this.shebeiWeidu = shebeiWeidu;
    }

    @Basic
    @Column(name = "shebei_sudu")
    public Integer getShebeiSudu() {
        return shebeiSudu;
    }

    public void setShebeiSudu(Integer shebeiSudu) {
        this.shebeiSudu = shebeiSudu;
    }

    @Basic
    @Column(name = "shebei_shijian")
    public String getShebeiShijian() {
        return shebeiShijian;
    }

    public void setShebeiShijian(String shebeiShijian) {
        this.shebeiShijian = shebeiShijian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shebei shebei = (Shebei) o;

        if (shebeiId != shebei.shebeiId) return false;
        if (shebeiJingdu != null ? !shebeiJingdu.equals(shebei.shebeiJingdu) : shebei.shebeiJingdu != null)
            return false;
        if (shebeiWeidu != null ? !shebeiWeidu.equals(shebei.shebeiWeidu) : shebei.shebeiWeidu != null) return false;
        if (shebeiSudu != null ? !shebeiSudu.equals(shebei.shebeiSudu) : shebei.shebeiSudu != null) return false;
        if (shebeiShijian != null ? !shebeiShijian.equals(shebei.shebeiShijian) : shebei.shebeiShijian != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (shebeiId ^ (shebeiId >>> 32));
        result = 31 * result + (shebeiJingdu != null ? shebeiJingdu.hashCode() : 0);
        result = 31 * result + (shebeiWeidu != null ? shebeiWeidu.hashCode() : 0);
        result = 31 * result + (shebeiSudu != null ? shebeiSudu.hashCode() : 0);
        result = 31 * result + (shebeiShijian != null ? shebeiShijian.hashCode() : 0);
        return result;
    }
}
