package com.qrj.banche.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.*;
import com.qrj.banche.repository.*;
import com.qrj.banche.util.Getdistance;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component("fujinxianlu")
@Scope("prototype")
public class fujinxianlu extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private BancheMapper bancheMapper;

    @Resource
    private ZhandianMapper zhandianMapper;

    @Resource
    private CheliangMapper cheliangMapper;

    @Resource
    private ShebeiMapper shebeiMapper;

    @Resource
    private ShebeilishiMapper shebeilishiMapper;

    private List<Zhandian> zhandians;

    private List<Zhandian> zhandiansdesc;

    private List<Banche> banches;

    private List<Shebei> shebeis;

    private List<Cheliang> cheliangs;

    private List<Shebeilishi> shebeilishis;

    private Boolean timechang = false;

    @Override
    public String execute() throws Exception {
        //TODO 优化数据库查询，减少zhandian等查询次数 比如数据库存储当前车站和到当前车站距离，当距离从小于100变到大于100是否进行变站到下一站
        HttpServletRequest request = ServletActionContext.getRequest();
        switch (searchInfo.getFujinxianlu()) {
            case 1:
                banches = bancheMapper.findByBancheNameAndstatus(searchInfo.getWxsearchbanche(), 1);
                return "success";
            case 2:
                banches = new ArrayList<>();
                banches.add(bancheMapper.findByBancheId(searchInfo.getXianluid()));
                zhandians = zhandianMapper.findByBancheId(searchInfo.getXianluid());
                zhandiansdesc = zhandianMapper.findByBancheIdDESC(searchInfo.getXianluid());
                //
                cheliangs = cheliangMapper.findByBancheid(searchInfo.getXianluid());
                long sbids[] = new long[cheliangs.size()];
                int daozhan[] = new int[cheliangs.size()];
                for (int i = 0; i < cheliangs.size(); i++) {
//                    changwangfan(cheliangs.get(i));
                    sbids[i] = cheliangs.get(i).getShebeiId();
                    daozhan[i] = daozhanshijian(cheliangs.get(i), cheliangs.get(i).getShebeiId(), zhandians, zhandiansdesc);
                }

                Document document = DocumentHelper.createDocument();
                Element rootelement = document.addElement("Message");
                Element cheliangselement = rootelement.addElement("Cheliangs");
                for (int i = 0; i < cheliangs.size(); i++) {
                    Cheliang cheliang = cheliangs.get(i);
                    Element cheliangelement = cheliangselement.addElement("Cheliang");
                    Element chepaielement = cheliangelement.addElement("Chepai");
                    chepaielement.addText(cheliang.getCheliangChepai());
                    Element shebeiidelement = cheliangelement.addElement("Shebeiid");
                    shebeiidelement.addText(String.valueOf(cheliang.getShebeiId()));
                    Element daozhanelement = cheliangelement.addElement("Daozhan");
                    if (daozhan[i] == 0) {
                        daozhanelement.addText("即将到站");
//                    } else if(daozhan[i] == 10000) {
//                        cheliangselement.remove(cheliangelement);
                    } else {
                        daozhanelement.addText(String.valueOf(daozhan[i]));
                    }
                }
                if (sbids.length > 0) {
                    shebeis = shebeiMapper.findByshebeiids(sbids);
                    Element shebeiselement = rootelement.addElement("Shebeis");
                    for (Shebei shebei : shebeis) {
                        Element shebeielement = shebeiselement.addElement("Shebei");
                        Element shebeiid = shebeielement.addElement("Shebeiid");
                        shebeiid.addText(String.valueOf(shebei.getShebeiId()));
                        Element shebeijingduelement = shebeielement.addElement("Shebeijingdu");
                        shebeijingduelement.addText(String.valueOf(shebei.getShebeiJingdu()));
                        Element shebeiweiduelement = shebeielement.addElement("Shebeiweidu");
                        shebeiweiduelement.addText(String.valueOf(shebei.getShebeiWeidu()));
                    }
                }
                Element zhandianselement = rootelement.addElement("Zhandians");
                for (Zhandian zhandian : zhandians) {
                    Element zhandianelement = zhandianselement.addElement("Zhandian");
                    Element zhandiannameelement = zhandianelement.addElement("Zhandianname");
                    zhandiannameelement.addText(zhandian.getZhandianName());
                    Element zhandianxuhaoelement = zhandianelement.addElement("Zhandianxuhao");
                    zhandianxuhaoelement.addText(String.valueOf(zhandian.getZhandianXuhao()));
                    Element zhandianjingduelement = zhandianelement.addElement("Zhandianjingdu");
                    zhandianjingduelement.addText(String.valueOf(zhandian.getZhandianJingdu()));
                    Element zhandianweiduelement = zhandianelement.addElement("Zhandianweidu");
                    zhandianweiduelement.addText(String.valueOf(zhandian.getZhandianWeidu()));
                    Element zhandiandizhielement = zhandianelement.addElement("Zhandiandizhi");
                    zhandiandizhielement.addText(zhandian.getZhandianDizhi());
                    Element zhandianmiaoshuelement = zhandianelement.addElement("Zhandianmiaoshu");
                    zhandianmiaoshuelement.addText(zhandian.getZhandianMiaoshu());
                    Element zhandianyincangelement = zhandianelement.addElement("Zhandianyincang");
                    zhandianyincangelement.addText(String.valueOf(zhandian.getZhandianYincang()));
                }
                if (banches.get(0).getBancheStartday() == null || banches.get(0).getBancheStartday().equals("")){} else {
                shebeilishis = shebeilishiMapper.findguiji(banches.get(0).getBancheStartday(),banches.get(0).getBancheStarttime(),banches.get(0).getBancheEndday(),banches.get(0).getBancheEndtime(),shebeis.get(0).getShebeiId());
                Element biaodianselement = rootelement.addElement("Biaodians");
                for (Shebeilishi shebeilishi : shebeilishis) {
                    Element biaodianelement = biaodianselement.addElement("Biaodian");
                    Element jingduelement = biaodianelement.addElement("Jingdu");
                    jingduelement.addText(String.valueOf(shebeilishi.getShebeilishiShebeijingdu()));
                    Element weiduelement = biaodianelement.addElement("Weidu");
                    weiduelement.addText(String.valueOf(shebeilishi.getShebeilishiShebeiweidu()));
                }}
                returnxml(document);
                return null;
            case 3:
                Boolean refrsh = false;
                cheliangs = cheliangMapper.findByBancheid(searchInfo.getXianluid());

                sbids = new long[cheliangs.size()];
                daozhan = new int[cheliangs.size()];
                for (Cheliang cl : cheliangs) {
                    if ((System.currentTimeMillis() / 1000) - Long.valueOf(cl.getCheliangUpdatetime()) > 60) {
                        refrsh = true;
                    }
                }
                if (refrsh) {
                    zhandians = zhandianMapper.findByBancheId(searchInfo.getXianluid());
                    zhandiansdesc = zhandianMapper.findByBancheIdDESC(searchInfo.getXianluid());
                }
                for (int i = 0; i < cheliangs.size(); i++) {
                    sbids[i] = cheliangs.get(i).getShebeiId();
                    if (refrsh) {
                        daozhan[i] = daozhanshijian(cheliangs.get(i), cheliangs.get(i).getShebeiId(), zhandians, zhandiansdesc);
                    }
                }
                document = DocumentHelper.createDocument();
                rootelement = document.addElement("Message");
                cheliangselement = rootelement.addElement("Cheliangs");
                for (int i = 0; i < cheliangs.size(); i++) {
                    Cheliang cheliang = cheliangs.get(i);
                    Element cheliangelement = cheliangselement.addElement("Cheliang");
                    Element chepaielement = cheliangelement.addElement("Chepai");
                    chepaielement.addText(cheliang.getCheliangChepai());
                    Element shebeiidelement = cheliangelement.addElement("Shebeiid");
                    shebeiidelement.addText(String.valueOf(cheliang.getShebeiId()));

                    Element daozhanelement = cheliangelement.addElement("Daozhan");
                    if (refrsh) {
                        if (daozhan[i] == 0) {
                            daozhanelement.addText("即将到站");
//                    } else if(daozhan[i] == 10000) {
//                        cheliangselement.remove(cheliangelement);
                        } else {
                            daozhanelement.addText(String.valueOf(daozhan[i]));
                        }
                    } else {
                        daozhanelement.addText(String.valueOf(cheliang.getCheliangDaozhanshijian()));
                    }
                }

                if (sbids.length > 0) {
                    shebeis = shebeiMapper.findByshebeiids(sbids);
                    Element shebeiselement = rootelement.addElement("Shebeis");
                    for (Shebei shebei : shebeis) {
                        Element shebeielement = shebeiselement.addElement("Shebei");
                        Element shebeiid = shebeielement.addElement("Shebeiid");
                        shebeiid.addText(String.valueOf(shebei.getShebeiId()));
                        Element shebeijingduelement = shebeielement.addElement("Shebeijingdu");
                        shebeijingduelement.addText(String.valueOf(shebei.getShebeiJingdu()));
                        Element shebeiweiduelement = shebeielement.addElement("Shebeiweidu");
                        shebeiweiduelement.addText(String.valueOf(shebei.getShebeiWeidu()));
                    }
                }
                returnxml(document);
                return null;
            default:
                break;
        }
        return "success";
    }

    public fujinxianlu() {

    }

    /**
     * 返回结果XML给WEB
     *
     * @param document 需要返回给WEB的XML
     * @throws java.io.IOException
     * @author 刘健
     */
    private void returnxml(Document document) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/xml;charset=gbk"); // （1）一定要在（2）的前面，不然会乱码
        response.setCharacterEncoding("GBK"); // （2）
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter(); // （3）一定要在（1）（2）的后面
        out.print(document.asXML());
        out.flush();
        out.close();
    }

    /**
     * 计算车辆到站时间
     *
     * @author 刘健
     */
    private int daozhanshijian(Cheliang cheliang, long shebeiid, List<Zhandian> zhandians, List<Zhandian> zhandiansdesc) {
//        List<Shebei> theshebei = shebeiMapper.findByshebeiId(shebeiid);
//        Shebei shebei = theshebei.get(0);
        Shebei shebei = shebeiMapper.selectByPrimaryKey(shebeiid);
        List<Zhandian> thezhandian;
        if (cheliang.getCheliangWangfan() == 1) {
            //返回和出发站点顺序相反
            thezhandian = zhandiansdesc;
        } else {
            //出发
            thezhandian = zhandians;
        }
        //获取设备最后5条GPS数据
        List<Shebeilishi> the5lishi = shebeilishiMapper.findByshebeiidthelast5(shebeiid);
        int sudu = 0;
        for (int i = 0; i < the5lishi.size(); i++) {
            //最后5条平均速度
            sudu = sudu + the5lishi.get(i).getShebeilishiShebeisudu();
        }
        String kaishiandjieshuzhandian = gotozhandian(thezhandian, shebei);
//        int kaishizhandian = Integer.valueOf(kaishiandjieshuzhandian.split(",")[0]);
//        int jieshuzhandian = Integer.valueOf(kaishiandjieshuzhandian.split(",")[1]);

        int kaishizhandian = cheliang.getCheliangCurrentzhandian();
        int jieshuzhandian = cheliang.getCheliangGotozhandian();
        int kaishizhandiani = 0;
        int jieshuzhandiani = 0;
        int userzhandiani =0;
        for (int i = 0; i < zhandians.size() - 1; i++) {
            if (Objects.equals(zhandians.get(i).getZhandianXuhao(), kaishizhandian)) {
                kaishizhandiani = i;
            }
            if (Objects.equals(zhandians.get(i).getZhandianXuhao(), jieshuzhandian)) {
                jieshuzhandiani = i;
            }
        }
        double juli = Getdistance.GetLongDistance(shebei.getShebeiJingdu(), shebei.getShebeiWeidu(), thezhandian.get(kaishizhandiani).getZhandianJingdu(), thezhandian.get(kaishizhandiani).getZhandianWeidu());
        if ((jieshuzhandiani - kaishizhandiani) >= 1) {
            for (int i = kaishizhandiani; i < jieshuzhandiani -1; i++) {
                juli = juli + Getdistance.GetLongDistance(thezhandian.get(i).getZhandianJingdu(), thezhandian.get(i).getZhandianWeidu(), thezhandian.get(i + 1).getZhandianJingdu(), thezhandian.get(i + 1).getZhandianWeidu());
            }
        } else {
            juli = juli + Getdistance.GetLongDistance(thezhandian.get(kaishizhandiani).getZhandianJingdu(), thezhandian.get(kaishizhandiani).getZhandianWeidu(), thezhandian.get(jieshuzhandiani).getZhandianJingdu(), thezhandian.get(jieshuzhandiani).getZhandianWeidu());
        }
        double doubletime = (juli / 10) / (Double.parseDouble(String.valueOf(sudu / the5lishi.size())) / 36);
        int shijian = 0;
        if (sudu != 0) {
            shijian = Integer.valueOf(String.valueOf(doubletime).substring(0, String.valueOf(doubletime).indexOf("."))) / 60;
        } else {
            shijian = 1000;
        }
//        if(kaishizhandian == 0 && jieshuzhandian == 0) {
//            shijian = 10000;
//        }

        return shijian;
    }

    /**
     * 判断车辆去哪个车站
     *
     * @author 刘健
     */
    private String gotozhandian(List<Zhandian> zhandians, Shebei shebei) {
        int i = 0;
        for (i = 0; i < zhandians.size() - 1; i++) {
            //判断当前点和第一站点，后一站点，以及两站点之间距离
            double ijuli = Getdistance.GetLongDistance(shebei.getShebeiJingdu(), shebei.getShebeiWeidu(), zhandians.get(i).getZhandianJingdu(), zhandians.get(i).getZhandianWeidu());
            double ierjuli = Getdistance.GetLongDistance(shebei.getShebeiJingdu(), shebei.getShebeiWeidu(), zhandians.get(i + 1).getZhandianJingdu(), zhandians.get(i + 1).getZhandianWeidu());
            double zhijianjuli = Getdistance.GetLongDistance(zhandians.get(i).getZhandianJingdu(), zhandians.get(i).getZhandianWeidu(), zhandians.get(i + 1).getZhandianJingdu(), zhandians.get(i + 1).getZhandianWeidu());
            int aa = Integer.parseInt(String.valueOf(ijuli).substring(0, String.valueOf(ijuli).lastIndexOf(".")));
            int bb = Integer.parseInt(String.valueOf(ierjuli).substring(0, String.valueOf(ierjuli).lastIndexOf(".")));
            int cc = Integer.parseInt(String.valueOf(zhijianjuli).substring(0, String.valueOf(zhijianjuli).lastIndexOf(".")));
            if ((aa + bb) <= cc) {
                for (int j = i + 1; j < zhandians.size(); j++) {
                    if (zhandians.get(j).getZhandianYincang() == 1) {
                        return String.valueOf(i + 1) + "," + String.valueOf(j);
                    }
                }

            }
        }
        return "0,0";
    }

    @Override
    public Object getModel() {
        return searchInfo;
    }

    public List<Banche> getBanches() {
        return banches;
    }

    public void setBanches(List<Banche> banches) {
        this.banches = banches;
    }

    public List<Zhandian> getZhandians() {
        return zhandians;
    }

    public void setZhandians(List<Zhandian> zhandians) {
        this.zhandians = zhandians;
    }

    public List<Shebei> getShebeis() {
        return shebeis;
    }

    public void setShebeis(List<Shebei> shebeis) {
        this.shebeis = shebeis;
    }

    public List<Cheliang> getCheliangs() {
        return cheliangs;
    }

    public void setCheliangs(List<Cheliang> cheliangs) {
        this.cheliangs = cheliangs;
    }
}
