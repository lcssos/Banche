package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/24.
 */
@Entity
@Table(name = "shebeilishi")
public class Shebeilishi {
    private int shebeilishiId;
    private Long shebeilishiShebeiid;
    private Double shebeilishiShebeijingdu;
    private Double shebeilishiShebeiweidu;
    private Integer shebeilishiShebeisudu;
    private String shebeilishiShebeishijian;

    @Id
    @Column(name = "shebeilishi_id")
    @GeneratedValue
    public int getShebeilishiId() {
        return shebeilishiId;
    }

    public void setShebeilishiId(int shebeilishiId) {
        this.shebeilishiId = shebeilishiId;
    }

    @Basic
    @Column(name = "shebeilishi_shebeiid")
    public Long getShebeilishiShebeiid() {
        return shebeilishiShebeiid;
    }

    public void setShebeilishiShebeiid(Long shebeilishiShebeiid) {
        this.shebeilishiShebeiid = shebeilishiShebeiid;
    }

    @Basic
    @Column(name = "shebeilishi_shebeijingdu")
    public Double getShebeilishiShebeijingdu() {
        return shebeilishiShebeijingdu;
    }

    public void setShebeilishiShebeijingdu(Double shebeilishiShebeijingdu) {
        this.shebeilishiShebeijingdu = shebeilishiShebeijingdu;
    }

    @Basic
    @Column(name = "shebeilishi_shebeiweidu")
    public Double getShebeilishiShebeiweidu() {
        return shebeilishiShebeiweidu;
    }

    public void setShebeilishiShebeiweidu(Double shebeilishiShebeiweidu) {
        this.shebeilishiShebeiweidu = shebeilishiShebeiweidu;
    }

    @Basic
    @Column(name = "shebeilishi_shebeisudu")
    public Integer getShebeilishiShebeisudu() {
        return shebeilishiShebeisudu;
    }

    public void setShebeilishiShebeisudu(Integer shebeilishiShebeisudu) {
        this.shebeilishiShebeisudu = shebeilishiShebeisudu;
    }

    @Basic
    @Column(name = "shebeilishi_shebeishijian")
    public String getShebeilishiShebeishijian() {
        return shebeilishiShebeishijian;
    }

    public void setShebeilishiShebeishijian(String shebeilishiShebeishijian) {
        this.shebeilishiShebeishijian = shebeilishiShebeishijian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shebeilishi that = (Shebeilishi) o;

        if (shebeilishiId != that.shebeilishiId) return false;
        if (shebeilishiShebeiid != null ? !shebeilishiShebeiid.equals(that.shebeilishiShebeiid) : that.shebeilishiShebeiid != null)
            return false;
        if (shebeilishiShebeijingdu != null ? !shebeilishiShebeijingdu.equals(that.shebeilishiShebeijingdu) : that.shebeilishiShebeijingdu != null)
            return false;
        if (shebeilishiShebeiweidu != null ? !shebeilishiShebeiweidu.equals(that.shebeilishiShebeiweidu) : that.shebeilishiShebeiweidu != null)
            return false;
        if (shebeilishiShebeisudu != null ? !shebeilishiShebeisudu.equals(that.shebeilishiShebeisudu) : that.shebeilishiShebeisudu != null)
            return false;
        if (shebeilishiShebeishijian != null ? !shebeilishiShebeishijian.equals(that.shebeilishiShebeishijian) : that.shebeilishiShebeishijian != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shebeilishiId;
        result = 31 * result + (shebeilishiShebeiid != null ? shebeilishiShebeiid.hashCode() : 0);
        result = 31 * result + (shebeilishiShebeijingdu != null ? shebeilishiShebeijingdu.hashCode() : 0);
        result = 31 * result + (shebeilishiShebeiweidu != null ? shebeilishiShebeiweidu.hashCode() : 0);
        result = 31 * result + (shebeilishiShebeisudu != null ? shebeilishiShebeisudu.hashCode() : 0);
        result = 31 * result + (shebeilishiShebeishijian != null ? shebeilishiShebeishijian.hashCode() : 0);
        return result;
    }
}
