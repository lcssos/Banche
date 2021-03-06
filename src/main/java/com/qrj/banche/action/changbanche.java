package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Banche;
import com.qrj.banche.entity.Wxaccesstoken;
import com.qrj.banche.entity.Zhandian;
import com.qrj.banche.repository.BancheMapper;
import com.qrj.banche.repository.WxaccesstokenMapper;
import com.qrj.banche.repository.ZhandianMapper;
import com.qrj.banche.vo.SearchInfo;
import com.qrj.weixin.servlet.sign;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Component("changbanche")
@Scope("prototype")
public class changbanche extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private BancheMapper bancheMapper;

    @Resource
    private ZhandianMapper zhandianMapper;

    @Resource
    private WxaccesstokenMapper wxaccesstokenMapper;

    private List<Banche> banches;
//    private Banche banche;

    private String nonceStr;

    private String timestamp;

    private String signature;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (searchInfo.getSearchform() == 2) {
            //根据单位ID获取所有线路
            if ((String) request.getSession().getAttribute("wxcomid") == null) {
                banches = bancheMapper.findBycomdetid(1);
            } else {
                banches = bancheMapper.findBycomdetid(Integer.valueOf((String) request.getSession().getAttribute("wxcomid")).intValue());
            }
//            creatjsconfig();
            return "wxsearchbanche";
        }
        //comid 线路公司id
        int comid = (Integer) request.getSession().getAttribute("comid");
        switch (searchInfo.getSearchbanche()) {
            //查询
            case 1:
                if (comid == 0) {
                    String bancheName = StringUtils.isBlank(searchInfo.getSearchbanchename()) ? null : ("%" + searchInfo.getSearchbanchename() + "%");
                    banches = bancheMapper.findByBancheNameAndstatus(bancheName, searchInfo.getSearchbanchezhuangtai());
                } else {
                    banches = bancheMapper.findByBancheNameAndComidAndstatus(searchInfo.getSearchbanchename(), comid, searchInfo.getSearchbanchezhuangtai());
                }
                //来自修改班车还是修改站点的请求
                if (searchInfo.getSearchform() == 1) {
                    return "searchbanche";
                } else {
                    return "searchzhandian";
                }
                //修改状态
            case 2:
                Banche banche = bancheMapper.findByBancheId(searchInfo.getXiugaibancheid());
//                if (banches.size() > 0) {
//                    Banche banche = banches.get(0);
                    if (banche.getComdetId() == comid || comid == 0) {
                        if (searchInfo.getXiugaibanchestatus() == 1) {
                            banche.setBancheStatus(0);
                        } else {
                            banche.setBancheStatus(1);
                        }
                        bancheMapper.updateByPrimaryKeySelective(banche);
                    }
//                }
//                banches = null;
                return "searchbanche";
            //删除
            case 3:
                 banche = bancheMapper.findByBancheId(searchInfo.getXiugaibancheid());
//                if (banches.size() > 0) {
//                    Banche banche = banches.get(0);
                    if (banche.getComdetId() == comid || comid == 0) {
                        List<Zhandian> zhandians = zhandianMapper.findByBancheId(banche.getBancheId());
                        for (Zhandian zhandian : zhandians) {
                            zhandianMapper.deleteByPrimaryKey(zhandian.getZhandianId());
                        }
                        bancheMapper.deleteByPrimaryKey(banche.getBancheId());
                    }
//                }
//                banches = null;
                return "searchbanche";
            //查询
            case 4:
                banche = bancheMapper.findByBancheId(searchInfo.getXiugaibancheid());

//                if (banches.size() > 0) {
//                    Banche banche = banches.get(0);
                    if (banche.getComdetId() == comid || comid == 0) {
                        return "xiugai";
                    }
//                }
                return "searchbanche";
            //更新
            case 5:
                banche = bancheMapper.findByBancheId(searchInfo.getXiugaibancheid());
//                if (banches.size() > 0) {
//                    Banche banche = banches.get(0);
                    if (banche.getComdetId() == comid || comid == 0) {
                        banche.setBancheName(searchInfo.getXiugaibanchename());
                        banche.setBancheJieshao(searchInfo.getXiugaibanchejianjie());
                        banche.setBancheJiange(searchInfo.getXiugaibanchejiange());
                        banche.setBancheQuancheng(searchInfo.getXiugaibanchequancheng());
                        banche.setBancheYunxingtime(searchInfo.getXiugaibancheyunxing());
                        banche.setBancheTime(searchInfo.getXiugaibanchetime());
                        banche.setBancheStatus(searchInfo.getXiugaibczhuangtai());
                        banche.setBancheStartday(searchInfo.getXiugaibcstartday());
                        banche.setBancheStarttime(searchInfo.getXiugaibcstarttime());
                        banche.setBancheEndday(searchInfo.getXiugaibcendday());
                        banche.setBancheEndtime(searchInfo.getXiugaibcendtime());
                        bancheMapper.updateByPrimaryKeySelective(banche);
                    }
//                }
                return "searchbanche";
            default:
                break;
        }
        return "searchbanche";
    }

    public changbanche() {

    }

    /**
     * 生成微信JS所需配置
     */
    private void creatjsconfig() {
        Wxaccesstoken wxaccesstoken = wxaccesstokenMapper.findByid(2).get(0);

        String url = "http://www.banchezaina.com/Banche/changbanche.action?searchform=2";
        Map<String, String> ret = sign.creatsign(wxaccesstoken.getAccessToken(), url);
        for (Map.Entry entry : ret.entrySet()) {
            if (entry.getKey().equals("nonceStr")) {
                nonceStr = (String) entry.getValue();
            }
            if (entry.getKey().equals("timestamp")) {
                timestamp = (String) entry.getValue();
            }
            if (entry.getKey().equals("signature")) {
                signature = (String) entry.getValue();
            }
        }
    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Banche> getBanches() {
        return banches;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setBanches(List<Banche> banches) {
        this.banches = banches;

    }

}
