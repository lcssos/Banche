package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.dao.BancheDao;
import com.qrj.banche.dao.ZhandianDao;
import com.qrj.banche.model.Banche;
import com.qrj.banche.model.Zhandian;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component("addbanche")
@Scope("prototype")
public class addbanche extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();


    @Resource
    private BancheDao bancheDao;

    @Resource
    private ZhandianDao zhandianDao;

    private String[] jingweidu;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        //c站点名称 b站点jingdu和weidu a是否显示
        String[] zhandianname = request.getParameterValues("ccc");
        String[] jingweidus = request.getParameterValues("bbb");
        String[] yincang = searchInfo.getCheckedsd().split(",");
        String[] dizhi = request.getParameterValues("dizhi");
        String[] miaoshu = request.getParameterValues("miaoshu");
        String[] daozhan = request.getParameterValues("daozhan");

        Banche banche = new Banche();
        banche.setBancheName(searchInfo.getAddbanchename());
        banche.setComdetId((Integer) request.getSession().getAttribute("comid"));
        banche.setBancheYunxingtime(searchInfo.getAddbancheyunxingtime());
        banche.setBancheStatus(searchInfo.getAddbanchestatus());
        banche.setBancheJieshao(searchInfo.getAddbanchejianjie());
        banche.setBancheJiange(searchInfo.getAddbanchejiange());
        banche.setBancheQuancheng(searchInfo.getAddbanchequancheng());
        banche.setBancheTime(searchInfo.getAddbanchetime());

        for (int i = 0; i < jingweidus.length; i++) {
            jingweidu = jingweidus[i].split(",");
            if (Integer.valueOf(jingweidu[2]) == 1) {
                banche.setBancheStart(zhandianname[i]);
            } else if (Integer.valueOf(jingweidu[2]) == zhandianname.length) {
                banche.setBancheEnd(zhandianname[i]);
            }
        }
        jingweidu = null;
        bancheDao.save(banche);
        List<Banche> banches = bancheDao.findByBancheNameAndComidAndstatus(searchInfo.getAddbanchename(), (Integer) request.getSession().getAttribute("comid"), searchInfo.getAddbanchestatus());
        if (banches.size() > 0) {

            if (zhandianname != null && zhandianname.length > 0) {
                for (int i = 0; i < zhandianname.length; i++) {
                    Zhandian zhandian = new Zhandian();
                    zhandian.setZhandianName(zhandianname[i]);
                    jingweidu = jingweidus[i].split(",");
                    zhandian.setZhandianJingdu(Double.parseDouble(jingweidu[0]));
                    zhandian.setZhandianWeidu(Double.parseDouble(jingweidu[1]));
                    zhandian.setZhandianXuhao(Integer.valueOf(jingweidu[2]));
                    //1显示0隐藏
                    zhandian.setZhandianYincang(Integer.valueOf(yincang[i]));
                    zhandian.setZhandianDizhi(dizhi[i]);
                    zhandian.setZhandianMiaoshu(miaoshu[i]);
                    zhandian.setZhandianStatus(1);
                    zhandian.setZhandianYuji(daozhan[i]);
                    zhandian.setBancheId(banches.get(banches.size() - 1).getBancheId());
                    zhandianDao.save(zhandian);
                }
            }
        }
//        }
        return "success";
    }

    public addbanche() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
