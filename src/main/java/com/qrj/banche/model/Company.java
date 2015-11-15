package com.qrj.banche.model;

import javax.persistence.*;

/**
 * Created by liujian on 15/7/13.
 */
@Entity
@Table(name = "company")
public class Company {
    private int companyId;
    private String companyName;
    private String companyPassword;
    private String companyQuanxian;
    private String companyLxtele;
    private String companyLxname;
    private Integer comdetId;

    @Id
    @Column(name = "company_id")
    @GeneratedValue
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_password")
    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    @Basic
    @Column(name = "company_quanxian")
    public String getCompanyQuanxian() {
        return companyQuanxian;
    }

    public void setCompanyQuanxian(String companyQuanxian) {
        this.companyQuanxian = companyQuanxian;
    }

    @Basic
    @Column(name = "company_lxtele")
    public String getCompanyLxtele() {
        return companyLxtele;
    }

    public void setCompanyLxtele(String companyLxtele) {
        this.companyLxtele = companyLxtele;
    }

    @Basic
    @Column(name = "company_lxname")
    public String getCompanyLxname() {
        return companyLxname;
    }

    public void setCompanyLxname(String companyLxname) {
        this.companyLxname = companyLxname;
    }

    @Basic
    @Column(name = "comdet_id")
    public Integer getComdetId() {
        return comdetId;
    }

    public void setComdetId(Integer comdetId) {
        this.comdetId = comdetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (companyId != company.companyId) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (companyPassword != null ? !companyPassword.equals(company.companyPassword) : company.companyPassword != null)
            return false;
        if (companyQuanxian != null ? !companyQuanxian.equals(company.companyQuanxian) : company.companyQuanxian != null)
            return false;
        if (companyLxtele != null ? !companyLxtele.equals(company.companyLxtele) : company.companyLxtele != null)
            return false;
        if (companyLxname != null ? !companyLxname.equals(company.companyLxname) : company.companyLxname != null)
            return false;
        if (comdetId != null ? !comdetId.equals(company.comdetId) : company.comdetId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyId;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyPassword != null ? companyPassword.hashCode() : 0);
        result = 31 * result + (companyQuanxian != null ? companyQuanxian.hashCode() : 0);
        result = 31 * result + (companyLxtele != null ? companyLxtele.hashCode() : 0);
        result = 31 * result + (companyLxname != null ? companyLxname.hashCode() : 0);
        result = 31 * result + (comdetId != null ? comdetId.hashCode() : 0);
        return result;
    }
}
