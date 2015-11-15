package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.*;
import com.qrj.banche.repository.*;
import com.qrj.banche.util.Getdistance;
import com.qrj.banche.vo.Fujinzd;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component("wxzhandian")
@Scope("prototype")
public class wxzhandian extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private ZhandianMapper zhandianMapper;

    @Resource
    private CheliangMapper cheliangMapper;

    @Resource
    private ShebeilishiMapper shebeilishiMapper;

    @Resource
    private ShebeiMapper shebeiMapper;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private BancheMapper bancheMapper;
    @Resource
    private ComdetMapper comdetMapper;

    @Resource
    private FunctionMapper functionMapper;



    private List<Zhandian> zhandians;

    private List<Cheliang> cheliangs;

    private List<Comdet> comdets;

    private int userzhandian = 0;

    private int zhandiancha;

    private int dzshijian = 0;

    private int[] strs = new int[2] ;

    private Map map;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        //TODO 查询车辆信息，有用的是当前站点，算出和用户所在地差几站（可以前台），到站时间
        // TODO 处理预计时间看当前时间和预计时间，超过就下一个预计时间，都超过就不显示
        if (searchInfo.getSearchform() == 3) {
            zhandians = zhandianMapper.findByZhandianId(searchInfo.getXiugaizhandianid());
            Document document = DocumentHelper.createDocument();
            Element rootelement = document.addElement("Message");
            Element imageelement = rootelement.addElement("image");
            if (zhandians.get(0).getZhandianImage() == null) {
                imageelement.addText("");
            } else {
                imageelement.addText(zhandians.get(0).getZhandianImage());
            }
            Element miaoshuelement = rootelement.addElement("dizhi");
            miaoshuelement.addText(zhandians.get(0).getZhandianDizhi());
            returnxml(document);
            return null;
        }
        if (this.searchInfo.getCheci() != 0)
        {
            this.zhandians = zhandianMapper.findByBancheIdandyincang(this.searchInfo.getXiugaibancheid(), 1);
            String ss = "";
            for (Zhandian zhandian : this.zhandians) {
                zhandian.setZhandianYuji(zhandian.getZhandianYuji().replaceAll("：", ":"));
                if (zhandian.getZhandianYuji().contains("，")) {
                    ss = ss + zhandian.getZhandianYuji().split("，")[(this.searchInfo.getCheci() - 1)] + ",";
                }
                else if (zhandian.getZhandianYuji().split(",").length <= this.searchInfo.getCheci() - 1)
                    ss = ss + "无预计,";
                else {
                    ss = ss + zhandian.getZhandianYuji().split(",")[(this.searchInfo.getCheci() - 1)] + ",";
                }
            }
            Document document = DocumentHelper.createDocument();
            Element rootelement = document.addElement("Message");
            Element yujielement = rootelement.addElement("Yuji");
            yujielement.addText(ss);
            returnxml(document);
            return null;
        }

        //todo
        List<Fujinzd> list;
        if (((String)request.getSession().getAttribute("openId")) == null || ((String) request.getSession().getAttribute("openId")).equals("")) {
        list = functionMapper.callfujinzd(10,"ol-XJwr-LwhyQcHFnfxQQkyl4v5o",searchInfo.getXiugaibancheid());
        } else {
            list = functionMapper.callfujinzd(5, (String)request.getSession().getAttribute("openId"), searchInfo.getXiugaibancheid());

        }
        if (list.size() > 0) {
            userzhandian = (Integer) list.get(0).getZhandianXuhao();
        } else {
            userzhandian = 2;
        }
        zhandians = zhandianMapper.findByBancheIdandyincang(searchInfo.getXiugaibancheid(), 1);
        cheliangs = cheliangMapper.findByBancheid(searchInfo.getXiugaibancheid());
        if (cheliangs.size() > 0) {
            this.comdets = comdetMapper.findBycomdetId(((Cheliang) this.cheliangs.get(0)).getComdetId().intValue());
        dzshijian = daozhanshijian(cheliangs.get(0), cheliangs.get(0).getShebeiId(), zhandians);

        } else {
            List<Banche> banches = bancheMapper.findByBancheId(this.searchInfo.getXiugaibancheid());
            this.comdets = comdetMapper.findBycomdetId(banches.get(0).getComdetId().intValue());
            dzshijian = 100;
        }
        String[] yuji = null;
        if (zhandians.get(0).getZhandianYuji().contains("，")) {
            yuji = zhandians.get(0).getZhandianYuji().split("，");
        } else {
            yuji = zhandians.get(0).getZhandianYuji().split(",");
        }
        for (String s : yuji) {
            if (s.length() == 4) {
                s = "0" + s;
            }
        }
        map = new LinkedHashMap<String,String>();
        for (int i = 0; i < yuji.length; i++) {
            if (cheliangs.size() > 0) {
            if (i<cheliangs.size()){
            map.put(yuji[i],cheliangs.get(i).getCheliangChepai());}
            else {
            map.put(yuji[i],cheliangs.get(0).getCheliangChepai());
            }}
            else {
                map.put(yuji[i],"暂无车辆");
            }
        }

        return "success";
    }

    public wxzhandian() {

    }

    @Override
    public Object getModel() {
        return searchInfo;
    }




    /**
     * 计算车辆到站时间
     *
     * @author 刘健
     */
    private int daozhanshijian(Cheliang cheliang, long shebeiid, List<Zhandian> zhandians) {
        List<Shebei> theshebei = shebeiMapper.findByshebeiId(shebeiid);
        Shebei shebei = theshebei.get(0);
        List<Zhandian> thezhandian;
        //出发
        thezhandian = zhandians;
        //获取设备最后5条GPS数据
        List<Shebeilishi> the5lishi = shebeilishiMapper.findByshebeiidthelast5(shebeiid);
        int sudu = 0;
        for (int i = 0; i < the5lishi.size(); i++) {
            //最后5条平均速度
            sudu = sudu + the5lishi.get(i).getShebeilishiShebeisudu();
        }

//        String kaishiandjieshuzhandian = gotozhandian(thezhandian, shebei);
//        int kaishizhandian = Integer.valueOf(kaishiandjieshuzhandian.split(",")[0]);
//        int jieshuzhandian = Integer.valueOf(kaishiandjieshuzhandian.split(",")[1]);
        int kaishizhandian = cheliang.getCheliangCurrentzhandian();
        int jieshuzhandian = cheliang.getCheliangGotozhandian();
        strs[0] = kaishizhandian;
        strs[1] = jieshuzhandian;
        jieshuzhandian = userzhandian;
        zhandiancha = jieshuzhandian -kaishizhandian;
        //计算所在位置
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

    public List<Zhandian> getZhandians() {
        return zhandians;
    }

    public void setZhandians(List<Zhandian> zhandians) {
        this.zhandians = zhandians;
    }

    public List<Cheliang> getCheliangs() {
        return cheliangs;
    }

    public void setCheliangs(List<Cheliang> cheliangs) {
        this.cheliangs = cheliangs;
    }

    public List<Comdet> getComdets() {
        return comdets;
    }

    public void setComdets(List<Comdet> comdets) {
        this.comdets = comdets;
    }

    public int getDzshijian() {
        return dzshijian;
    }

    public void setDzshijian(int dzshijian) {
        this.dzshijian = dzshijian;
    }

    public int getZhandiancha() {
        return zhandiancha;
    }

    public void setZhandiancha(int zhandiancha) {
        this.zhandiancha = zhandiancha;
    }

    public int getUserzhandian() {
        return userzhandian;
    }

    public void setUserzhandian(int userzhandian) {
        this.userzhandian = userzhandian;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int[] getStrs() {
        return strs;
    }

    public void setStrs(int[] strs) {
        this.strs = strs;
    }

}
