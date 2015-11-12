package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.BancheDao;
import com.qrj.banche.dao.ZhandianDao;
import com.qrj.banche.model.Banche;
import com.qrj.banche.model.Zhandian;
import com.qrj.banche.vo.SearchInfo;
import net.coobird.thumbnailator.Thumbnails;
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

@Component("changzhandian")
@Scope("prototype")
public class changzhandian extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private BancheDao bancheDao;

    @Resource
    private ZhandianDao zhandianDao;

    private List<Zhandian> zhandians;

    private List<Banche> banches;

    private String cuowumessage;

    private File upload;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        int comid = (Integer) request.getSession().getAttribute("comid");
        //1根据班车ID搜站点 2查找具体站点信息 3update站点信息
        switch (searchInfo.getSearchzhandian()) {
            case 1:
                zhandians = zhandianDao.findByBancheId(searchInfo.getXiugaibancheid());
                return "success";
            case 2:
                zhandians = zhandianDao.findByZhandianId(searchInfo.getXiugaizhandianid());
                return "xiugai";
            case 3:
                zhandians = zhandianDao.findByBancheIdandXuhao(searchInfo.getXiugaizhandianbancheid(), searchInfo.getXiugaizhandianxuhao());
                if (zhandians.get(0).getZhandianXuhao() == searchInfo.getXiugaizhandianxuhao()) {
                } else {
                    if (zhandians.size() > 0) {
                        cuowumessage = "已有该序号站点，请重新修改";
                        return "faild";
                    }
                }
                String prefix = "";
                long time;
                    time = System.currentTimeMillis();
                if (searchInfo.getZdfilename().length() > 0) {
                    prefix = searchInfo.getZdfilename().substring(searchInfo.getZdfilename().lastIndexOf("."));
//                    time = dateFormat.format(calendar.getTime());
                    String lujing = request.getSession().getServletContext().getRealPath("/upload");
                    String yuantulujing = lujing + "/zhandian/" + searchInfo.getXiugaizhandianbancheid() + "/yuan/" + time + prefix;
                    File file =new File(lujing + "/zhandian/" + searchInfo.getXiugaizhandianbancheid() + "/yuan");
                    if  (!file .exists()  && !file .isDirectory())
                    {
                        file .mkdirs();
                    }
                    File file2 =new File(lujing + "/zhandian/" + searchInfo.getXiugaizhandianbancheid() + "/360");
                    if  (!file2 .exists()  && !file2 .isDirectory())
                    {
                        file2 .mkdirs();
                    }
                    InputStream is = new FileInputStream(upload);
                    OutputStream os = new FileOutputStream(yuantulujing);
                    byte buffer[] = new byte[8192];
                    int count = 0;
                    while ((count = is.read(buffer)) > 0) {
                        os.write(buffer, 0, count);
                    }
                    os.close();
                    is.close();
                    Thumbnails.of(yuantulujing).size(360, 187).keepAspectRatio(false).toFile(lujing + "/zhandian/" + searchInfo.getXiugaizhandianbancheid() + "/360/" + time + prefix);
                }
                zhandians = zhandianDao.findByZhandianId(searchInfo.getXiugaizhandianid());
                if (zhandians.size() > 0) {
                    Zhandian zhandian = zhandians.get(0);
                    zhandian.setZhandianName(searchInfo.getXiugaizhandianname());
                    zhandian.setZhandianYincang(searchInfo.getXiugaizhandianyincang());
                    zhandian.setZhandianXuhao(searchInfo.getXiugaizhandianxuhao());
                    zhandian.setZhandianStatus(searchInfo.getXiugaizhandianstatus());
                    zhandian.setZhandianJingdu(Double.parseDouble(searchInfo.getXiugaizhandianjingdu()));
                    zhandian.setZhandianWeidu(Double.parseDouble(searchInfo.getXiugaizhandianweidu()));
                    if (searchInfo.getZdfilename().length() > 0) {
                        zhandian.setZhandianImage("http://123.57.61.220:80/Banche/upload/zhandian/" + searchInfo.getXiugaizhandianbancheid() + "/360/" + time + prefix);
                    }
                    zhandianDao.update(zhandian);
                } else {
                    cuowumessage = "更新失败，请重新修改";
                    return "faild";
                }
                zhandians = null;
                return "update";
            case 4:
                zhandians = zhandianDao.findByZhandianId(searchInfo.getDeletezhandianid());
                int deletexuhao = zhandians.get(0).getZhandianXuhao();
                int deletebancheid = zhandians.get(0).getBancheId();
                zhandians = zhandianDao.findByBancheId(deletebancheid);
                for (Zhandian zhandian1 : zhandians) {
                    int newxuhao = zhandian1.getZhandianXuhao();
                    if (newxuhao > deletexuhao) {
                        zhandian1.setZhandianXuhao(newxuhao - 1);
                        zhandianDao.update(zhandian1);
                    }
                }
                Zhandian zhandian = new Zhandian();
                zhandian.setZhandianId(searchInfo.getDeletezhandianid());
                zhandianDao.delete(zhandian);
                zhandians = null;
                return "delete";
            default:
                break;
        }
        return "faild";
    }

    public changzhandian() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Zhandian> getZhandians() {
        return zhandians;
    }

    public void setZhandians(List<Zhandian> zhandians) {
        this.zhandians = zhandians;
    }

    public List<Banche> getBanches() {
        return banches;
    }

    public void setBanches(List<Banche> banches) {
        this.banches = banches;
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
}
