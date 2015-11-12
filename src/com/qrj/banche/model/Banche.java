package com.qrj.banche.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by liujian on 15/9/9.
 */
@Entity
@Table(name = "banche")
public class Banche {
    private int bancheId;

    @Id
    @javax.persistence.Column(name = "banche_id")
    public int getBancheId() {
        return bancheId;
    }

    public void setBancheId(int bancheId) {
        this.bancheId = bancheId;
    }

    private String bancheName;

    @Basic
    @javax.persistence.Column(name = "banche_name")
    public String getBancheName() {
        return bancheName;
    }

    public void setBancheName(String bancheName) {
        this.bancheName = bancheName;
    }

    private String bancheTime;

    @Basic
    @javax.persistence.Column(name = "banche_time")
    public String getBancheTime() {
        return bancheTime;
    }

    public void setBancheTime(String bancheTime) {
        this.bancheTime = bancheTime;
    }

    private String bancheXianshi;

    @Basic
    @javax.persistence.Column(name = "banche_xianshi")
    public String getBancheXianshi() {
        return bancheXianshi;
    }

    public void setBancheXianshi(String bancheXianshi) {
        this.bancheXianshi = bancheXianshi;
    }

    private String bancheYincang;

    @Basic
    @javax.persistence.Column(name = "banche_yincang")
    public String getBancheYincang() {
        return bancheYincang;
    }

    public void setBancheYincang(String bancheYincang) {
        this.bancheYincang = bancheYincang;
    }

    private Integer comdetId;

    @Basic
    @javax.persistence.Column(name = "comdet_id")
    public Integer getComdetId() {
        return comdetId;
    }

    public void setComdetId(Integer comdetId) {
        this.comdetId = comdetId;
    }

    private String bancheYunxingtime;

    @Basic
    @javax.persistence.Column(name = "banche_yunxingtime")
    public String getBancheYunxingtime() {
        return bancheYunxingtime;
    }

    public void setBancheYunxingtime(String bancheYunxingtime) {
        this.bancheYunxingtime = bancheYunxingtime;
    }

    private Integer bancheStatus;

    @Basic
    @javax.persistence.Column(name = "banche_status")
    public Integer getBancheStatus() {
        return bancheStatus;
    }

    public void setBancheStatus(Integer bancheStatus) {
        this.bancheStatus = bancheStatus;
    }

    private String bancheJieshao;

    @Basic
    @javax.persistence.Column(name = "banche_jieshao")
    public String getBancheJieshao() {
        return bancheJieshao;
    }

    public void setBancheJieshao(String bancheJieshao) {
        this.bancheJieshao = bancheJieshao;
    }

    private String bancheStart;

    @Basic
    @javax.persistence.Column(name = "banche_start")
    public String getBancheStart() {
        return bancheStart;
    }

    public void setBancheStart(String bancheStart) {
        this.bancheStart = bancheStart;
    }

    private String bancheEnd;

    @Basic
    @javax.persistence.Column(name = "banche_end")
    public String getBancheEnd() {
        return bancheEnd;
    }

    public void setBancheEnd(String bancheEnd) {
        this.bancheEnd = bancheEnd;
    }

    private String bancheJiange;

    @Basic
    @javax.persistence.Column(name = "banche_jiange")
    public String getBancheJiange() {
        return bancheJiange;
    }

    public void setBancheJiange(String bancheJiange) {
        this.bancheJiange = bancheJiange;
    }

    private String bancheQuancheng;

    @Basic
    @javax.persistence.Column(name = "banche_quancheng")
    public String getBancheQuancheng() {
        return bancheQuancheng;
    }

    public void setBancheQuancheng(String bancheQuancheng) {
        this.bancheQuancheng = bancheQuancheng;
    }

    private String bancheStartday;

    @Basic
    @javax.persistence.Column(name = "banche_startday")
    public String getBancheStartday() {
        return bancheStartday;
    }

    public void setBancheStartday(String bancheStartday) {
        this.bancheStartday = bancheStartday;
    }

    private String bancheStarttime;

    @Basic
    @javax.persistence.Column(name = "banche_starttime")
    public String getBancheStarttime() {
        return bancheStarttime;
    }

    public void setBancheStarttime(String bancheStarttime) {
        this.bancheStarttime = bancheStarttime;
    }

    private String bancheEndday;

    @Basic
    @javax.persistence.Column(name = "banche_endday")
    public String getBancheEndday() {
        return bancheEndday;
    }

    public void setBancheEndday(String bancheEndday) {
        this.bancheEndday = bancheEndday;
    }

    private String bancheEndtime;

    @Basic
    @javax.persistence.Column(name = "banche_endtime")
    public String getBancheEndtime() {
        return bancheEndtime;
    }

    public void setBancheEndtime(String bancheEndtime) {
        this.bancheEndtime = bancheEndtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Banche banche = (Banche) o;

        if (bancheId != banche.bancheId) return false;
        if (bancheName != null ? !bancheName.equals(banche.bancheName) : banche.bancheName != null) return false;
        if (bancheTime != null ? !bancheTime.equals(banche.bancheTime) : banche.bancheTime != null) return false;
        if (bancheXianshi != null ? !bancheXianshi.equals(banche.bancheXianshi) : banche.bancheXianshi != null)
            return false;
        if (bancheYincang != null ? !bancheYincang.equals(banche.bancheYincang) : banche.bancheYincang != null)
            return false;
        if (comdetId != null ? !comdetId.equals(banche.comdetId) : banche.comdetId != null) return false;
        if (bancheYunxingtime != null ? !bancheYunxingtime.equals(banche.bancheYunxingtime) : banche.bancheYunxingtime != null)
            return false;
        if (bancheStatus != null ? !bancheStatus.equals(banche.bancheStatus) : banche.bancheStatus != null)
            return false;
        if (bancheJieshao != null ? !bancheJieshao.equals(banche.bancheJieshao) : banche.bancheJieshao != null)
            return false;
        if (bancheStart != null ? !bancheStart.equals(banche.bancheStart) : banche.bancheStart != null) return false;
        if (bancheEnd != null ? !bancheEnd.equals(banche.bancheEnd) : banche.bancheEnd != null) return false;
        if (bancheJiange != null ? !bancheJiange.equals(banche.bancheJiange) : banche.bancheJiange != null)
            return false;
        if (bancheQuancheng != null ? !bancheQuancheng.equals(banche.bancheQuancheng) : banche.bancheQuancheng != null)
            return false;
        if (bancheStartday != null ? !bancheStartday.equals(banche.bancheStartday) : banche.bancheStartday != null)
            return false;
        if (bancheStarttime != null ? !bancheStarttime.equals(banche.bancheStarttime) : banche.bancheStarttime != null)
            return false;
        if (bancheEndday != null ? !bancheEndday.equals(banche.bancheEndday) : banche.bancheEndday != null)
            return false;
        if (bancheEndtime != null ? !bancheEndtime.equals(banche.bancheEndtime) : banche.bancheEndtime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bancheId;
        result = 31 * result + (bancheName != null ? bancheName.hashCode() : 0);
        result = 31 * result + (bancheTime != null ? bancheTime.hashCode() : 0);
        result = 31 * result + (bancheXianshi != null ? bancheXianshi.hashCode() : 0);
        result = 31 * result + (bancheYincang != null ? bancheYincang.hashCode() : 0);
        result = 31 * result + (comdetId != null ? comdetId.hashCode() : 0);
        result = 31 * result + (bancheYunxingtime != null ? bancheYunxingtime.hashCode() : 0);
        result = 31 * result + (bancheStatus != null ? bancheStatus.hashCode() : 0);
        result = 31 * result + (bancheJieshao != null ? bancheJieshao.hashCode() : 0);
        result = 31 * result + (bancheStart != null ? bancheStart.hashCode() : 0);
        result = 31 * result + (bancheEnd != null ? bancheEnd.hashCode() : 0);
        result = 31 * result + (bancheJiange != null ? bancheJiange.hashCode() : 0);
        result = 31 * result + (bancheQuancheng != null ? bancheQuancheng.hashCode() : 0);
        result = 31 * result + (bancheStartday != null ? bancheStartday.hashCode() : 0);
        result = 31 * result + (bancheStarttime != null ? bancheStarttime.hashCode() : 0);
        result = 31 * result + (bancheEndday != null ? bancheEndday.hashCode() : 0);
        result = 31 * result + (bancheEndtime != null ? bancheEndtime.hashCode() : 0);
        return result;
    }
}
