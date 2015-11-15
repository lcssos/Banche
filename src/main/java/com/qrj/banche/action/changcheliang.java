package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.BancheDao;
import com.qrj.banche.dao.CheliangDao;
import com.qrj.banche.dao.ShebeiDao;
import com.qrj.banche.model.Banche;
import com.qrj.banche.model.Cheliang;
import com.qrj.banche.model.Shebei;
import com.qrj.banche.vo.SearchInfo;
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

@Component("changcheliang")
//每一次请求都建个新的action
@Scope("prototype")
public class changcheliang extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private CheliangDao cheliangDao;

    @Resource
    private ShebeiDao shebeiDao;

    @Resource
    private BancheDao bancheDao;

    private List<Cheliang> cheliangs;

    private List<Banche> banches;

    private String cuowumessage;

    private File upload;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        int comid = (Integer) request.getSession().getAttribute("comid");
        switch (searchInfo.getSearchcheliang()) {
            //查找
            case 1:
                if (comid == 0) {
                    cheliangs = cheliangDao.findByChepaiAndshebeiId(searchInfo.getSearchclchepai(), searchInfo.getSearchclshebeiid());
                } else {
                    cheliangs = cheliangDao.findByChepaiAndshebeiIdandcomid(searchInfo.getSearchclchepai(), searchInfo.getSearchclshebeiid(), comid);
                }
                return "success";
            //查找具体
            case 2:
                if (comid == 0) {
                    cheliangs = cheliangDao.findByChepai(searchInfo.getXiugaiclchepai());
                    banches = bancheDao.findAll();
                } else {
                    cheliangs = cheliangDao.findByChepaiAndcomid(searchInfo.getXiugaiclchepai(), comid);
                    banches = bancheDao.findBycomdetid(cheliangs.get(0).getComdetId());
                }
                return "xiugai";
            //修改
            case 3:
                cheliangs = cheliangDao.findByCheliangid(searchInfo.getXiugaicheliangid());
                if (searchInfo.getXiugaiclshebeiid() == 0 || searchInfo.getXiugaiclbancheid() == 0) {

                } else {
                    List<Shebei> shebeis = shebeiDao.findByshebeiId(searchInfo.getXiugaiclshebeiid());
                    List<Banche> banches = bancheDao.findByBancheId(searchInfo.getXiugaiclbancheid());
                    if (shebeis.size() == 0) {
                        cuowumessage = "没有该设备ID，请重新修改";
                        return "faild";
                    }
                    if (banches.size() == 0) {
                        cuowumessage = "没有该条班车线路，请重新修改";
                        return "faild";
                    }
                }
                //图片上传
                String time = dateFormat.format(calendar.getTime());
                String prefix = "";
                if (searchInfo.getClfilename().length() > 0) {
                    prefix = searchInfo.getClfilename().substring(searchInfo.getClfilename().lastIndexOf("."));
                    String lujing = request.getSession().getServletContext().getRealPath("/upload");
                    InputStream is = new FileInputStream(upload);
                    OutputStream os = new FileOutputStream(lujing + "/" + time + prefix);
                    byte buffer[] = new byte[8192];
                    int count = 0;
                    while ((count = is.read(buffer)) > 0) {
                        os.write(buffer, 0, count);
                    }
                    os.close();
                    is.close();
                }
                if (cheliangs.size() > 0) {
                    Cheliang cheliang = cheliangs.get(0);
                    cheliang.setCheliangChepai(searchInfo.getXiugaichepai());
                    cheliang.setCheliangChexing(searchInfo.getXiugaichexing());
                    cheliang.setCheliangCheling(searchInfo.getXiugaicheling());
                    cheliang.setCheliangZuoweishu(searchInfo.getXiugaizuoweishu());
                    cheliang.setCheliangJiashiyuan(searchInfo.getXiugaijiashiyuan());
                    cheliang.setCheliangTele(searchInfo.getXiugaicltele());
                    cheliang.setCheliangImage(searchInfo.getXiugaicheliangzhaopian());
                    cheliang.setShebeiId(searchInfo.getXiugaiclshebeiid());
                    cheliang.setBancheId(searchInfo.getXiugaiclbancheid());
                    if (searchInfo.getClfilename().length() > 0) {
                        cheliang.setCheliangImage("/upload/" + time + prefix);
                    }
                    cheliangDao.update(cheliang);
                } else {
                    cheliangs = null;
                    cuowumessage = "没有该车辆，请重新修改";
                    return "faild";
                }
                cheliangs = null;
                return "success";
            //删除
            case 4:
                Cheliang cheliang = new Cheliang();
                cheliang.setCheliangId(searchInfo.getDeletecheliangid());
                cheliangDao.delete(cheliang);
                return "success";
            default:
                break;
        }
        return "faild";
    }

    public changcheliang() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Cheliang> getCheliangs() {
        return cheliangs;
    }

    public void setCheliangs(List<Cheliang> cheliangs) {
        this.cheliangs = cheliangs;
    }

    public String getCuowumessage() {
        return cuowumessage;
    }

    public void setCuowumessage(String cuowumessage) {
        this.cuowumessage = cuowumessage;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public List<Banche> getBanches() {
        return banches;
    }

    public void setBanches(List<Banche> banches) {
        this.banches = banches;
    }
}