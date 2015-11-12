package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/27.
 */
@Entity
@Table(name = "shebeishuxing")
public class Shebeishuxing {
    private int shebeishuxingId;
    private Long shebeishuxingShebeiid;
    private String shebeishuxingShoujihao;
    private Integer shebeishuxingShebeistatus;

    @Id
    @Column(name = "shebeishuxing_id")
    @GeneratedValue
    public int getShebeishuxingId() {
        return shebeishuxingId;
    }

    public void setShebeishuxingId(int shebeishuxingId) {
        this.shebeishuxingId = shebeishuxingId;
    }

    @Basic
    @Column(name = "shebeishuxing_shebeiid")
    public Long getShebeishuxingShebeiid() {
        return shebeishuxingShebeiid;
    }

    public void setShebeishuxingShebeiid(Long shebeishuxingShebeiid) {
        this.shebeishuxingShebeiid = shebeishuxingShebeiid;
    }

    @Basic
    @Column(name = "shebeishuxing_shoujihao")
    public String getShebeishuxingShoujihao() {
        return shebeishuxingShoujihao;
    }

    public void setShebeishuxingShoujihao(String shebeishuxingShoujihao) {
        this.shebeishuxingShoujihao = shebeishuxingShoujihao;
    }

    @Basic
    @Column(name = "shebeishuxing_shebeistatus")
    public Integer getShebeishuxingShebeistatus() {
        return shebeishuxingShebeistatus;
    }

    public void setShebeishuxingShebeistatus(Integer shebeishuxingShebeistatus) {
        this.shebeishuxingShebeistatus = shebeishuxingShebeistatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shebeishuxing that = (Shebeishuxing) o;

        if (shebeishuxingId != that.shebeishuxingId) return false;
        if (shebeishuxingShebeiid != null ? !shebeishuxingShebeiid.equals(that.shebeishuxingShebeiid) : that.shebeishuxingShebeiid != null)
            return false;
        if (shebeishuxingShoujihao != null ? !shebeishuxingShoujihao.equals(that.shebeishuxingShoujihao) : that.shebeishuxingShoujihao != null)
            return false;
        if (shebeishuxingShebeistatus != null ? !shebeishuxingShebeistatus.equals(that.shebeishuxingShebeistatus) : that.shebeishuxingShebeistatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shebeishuxingId;
        result = 31 * result + (shebeishuxingShebeiid != null ? shebeishuxingShebeiid.hashCode() : 0);
        result = 31 * result + (shebeishuxingShoujihao != null ? shebeishuxingShoujihao.hashCode() : 0);
        result = 31 * result + (shebeishuxingShebeistatus != null ? shebeishuxingShebeistatus.hashCode() : 0);
        return result;
    }
}
