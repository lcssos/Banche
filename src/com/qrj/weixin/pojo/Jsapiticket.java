package com.qrj.weixin.pojo;

/**
 * JS凭证
 */
public class Jsapiticket {
    // JS接口访问凭证
    private String jsapiticket;
    // 凭证有效期，单位：秒
    private int expiresIn;

    public String getJsapiticket() {
        return jsapiticket;
    }

    public void setJsapiticket(String jsapiticket) {
        this.jsapiticket = jsapiticket;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
