package com.qrj.banche.entity;

public class Shebeishuxing {
    private Integer shebeishuxingId;

    private Long shebeishuxingShebeiid;

    private String shebeishuxingShoujihao;

    private Integer shebeishuxingShebeistatus;

    public Integer getShebeishuxingId() {
        return shebeishuxingId;
    }

    public void setShebeishuxingId(Integer shebeishuxingId) {
        this.shebeishuxingId = shebeishuxingId;
    }

    public Long getShebeishuxingShebeiid() {
        return shebeishuxingShebeiid;
    }

    public void setShebeishuxingShebeiid(Long shebeishuxingShebeiid) {
        this.shebeishuxingShebeiid = shebeishuxingShebeiid;
    }

    public String getShebeishuxingShoujihao() {
        return shebeishuxingShoujihao;
    }

    public void setShebeishuxingShoujihao(String shebeishuxingShoujihao) {
        this.shebeishuxingShoujihao = shebeishuxingShoujihao == null ? null : shebeishuxingShoujihao.trim();
    }

    public Integer getShebeishuxingShebeistatus() {
        return shebeishuxingShebeistatus;
    }

    public void setShebeishuxingShebeistatus(Integer shebeishuxingShebeistatus) {
        this.shebeishuxingShebeistatus = shebeishuxingShebeistatus;
    }
}