package com.qrj.banche.entity;

public class Company {
    private Integer companyId;

    private String companyName;

    private String companyPassword;

    private String companyQuanxian;

    private String companyLxtele;

    private String companyLxname;

    private Integer comdetId;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword == null ? null : companyPassword.trim();
    }

    public String getCompanyQuanxian() {
        return companyQuanxian;
    }

    public void setCompanyQuanxian(String companyQuanxian) {
        this.companyQuanxian = companyQuanxian == null ? null : companyQuanxian.trim();
    }

    public String getCompanyLxtele() {
        return companyLxtele;
    }

    public void setCompanyLxtele(String companyLxtele) {
        this.companyLxtele = companyLxtele == null ? null : companyLxtele.trim();
    }

    public String getCompanyLxname() {
        return companyLxname;
    }

    public void setCompanyLxname(String companyLxname) {
        this.companyLxname = companyLxname == null ? null : companyLxname.trim();
    }

    public Integer getComdetId() {
        return comdetId;
    }

    public void setComdetId(Integer comdetId) {
        this.comdetId = comdetId;
    }
}