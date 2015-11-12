package com.qrj.banche.vo;


public class SearchInfo {
    /* 登陆页面login.jsp传来的值 */
    private String username;
    private String password;

    /* 首页index.jsp传来的值*/
    private int tuichu;

    /*新增班车页面addbanche.jsp传来的值*/
    private String addbanchename;
    private String addbanchejianjie;
    private String addbanchejiange;
    private String addbanchequancheng;
    private String addbancheyunxingtime;
    private String addbanchetime;
    private int addbanchestatus;
    private String checkedsd;

    /*新增设备页面addshebei.jsp传来的值*/
    private long addsheibeiid;
    private int addshebeizhuangtai;
    private String addshebeishoujihao;

    /*新增车辆页面addcheliang.jsp传来的值*/
    private String addchepai;
    private String addchexing;
    private int addcheling;
    private int addzuoweishu;
    private String addjiashiyuan;
    private String addtele;
    private String addcheliangzhaopian;
    private long addclshebeiid;
    private int addclbancheid;

    /*新增公司用户页面addgongsi.jsp传来的值*/
    private String addcomdetname;
    private String addcomdetjianjie;
    private String addcomdetaddress;
    private String addcompanylxname;
    private String addcompanylxtele;
    private String addcompanyname;
    private String addcompanypass;

    /*管理设备页面changshebei.jsp传来的值*/
    private int searchshebei;
    private long searchsheibeiid;
    private int searchshebeizhuangtai;
    private long deleteshebeiid;
    private int updatestatus;

    /*管理站点页面changzhandian.jsp传来的值*/
    private int searchzhandian;
    private int searchbanche;
    private String searchbanchename;
    private int searchbanchezhuangtai;
    private int xiugaibancheid;

    /*站点列表页面listzhandian.jsp传来的值*/
    private int xiugaizhandianid;
    private int deletezhandianid;

    /* 修改站点页面xiugaizhandian.jsp传来的值*/
    private String xiugaizhandianname;
    private int xiugaizhandianyincang;
    private int xiugaizhandianxuhao;
    private int xiugaizhandianstatus;
    private String xiugaizhandianjingdu;
    private String xiugaizhandianweidu;
    private int xiugaizhandianbancheid;
    private String zdfilename;

    /*管理车辆页面changcheliang.jsp传来的值*/
    private int searchcheliang;
    private String searchclchepai;
    private long searchclshebeiid;
    private String xiugaiclchepai;
    private int deletecheliangid;

    /*修改车辆页面xiugaicheliang.jsp传来的值*/
    private int xiugaicheliangid;
    private String xiugaichepai;
    private String xiugaichexing;
    private int xiugaicheling;
    private int xiugaizuoweishu;
    private String xiugaijiashiyuan;
    private String xiugaicltele;
    private String xiugaicheliangzhaopian;
    private long xiugaiclshebeiid;
    private int xiugaiclbancheid;
    private String clfilename;

    /*管理班车页面changbanche.jsp传来的值*/
    private int searchform;
    private int xiugaibanchestatus;

    /*班车修改页面listbanche.jsp传来的值*/
    private String xiugaibanchename;
    private String xiugaibanchejianjie;
    private String xiugaibanchejiange;
    private String xiugaibanchequancheng;
    private String xiugaibancheyunxing;
    private String xiugaibanchetime;
    private int xiugaibczhuangtai;
    private String xiugaibcstartday;
    private String xiugaibcstarttime;
    private String xiugaibcendday;
    private String xiugaibcendtime;

    /*管理公司页面changcompany.jsp传来的值*/
    private int searchcompany;
    private String searchcomdetname;
    private int xiugaicomdetid;

    /*修改公司页面listcompany.jsp传来的值*/
    private String xiugaicomdetname;
    private String xiugaicomdetjianjie;
    private String xiugaicomdetxiugairess;
    private String xiugaicompanylxname;
    private String xiugaicompanylxtele;
    private String xiugaicompanyname;
    private String xiugaicompanypass;

    /*前台页面weixin/zhanshi2.jsp传来的值*/
    private int fujinxianlu;
    private int xianluid;
    private String wxsearchbanche;
    private String wxopenId;


    /*前台注册页面weixin/zhuce.jsp传来的值*/
    private String wxusername;
    private String wxuserpassword;
    private String wxusertele;

    /*前台页面传来的值 关注*/
    private int guanzhuwxuserid;
    private int guanzhubancheid;
    private String wxfilename;

    /*页面searchguiji.jsp传来的值*/
    private String startday;
    private String starttime;
    private String endday;
    private String endtime;
    private String chepai;

    /*页面bancheshow.jsp传来的值*/
    private int checi;
    private String wxchepai;

    /*wxjsdingweiajax.js传来的值*/
    private double wxjsjingdu;
    private double wxjsweidu;

    public double getWxjsjingdu() {
        return wxjsjingdu;
    }

    public void setWxjsjingdu(double wxjsjingdu) {
        this.wxjsjingdu = wxjsjingdu;
    }

    public double getWxjsweidu() {
        return wxjsweidu;
    }

    public void setWxjsweidu(double wxjsweidu) {
        this.wxjsweidu = wxjsweidu;
    }

    public String getXiugaibcstartday() {
        return xiugaibcstartday;
    }

    public void setXiugaibcstartday(String xiugaibcstartday) {
        this.xiugaibcstartday = xiugaibcstartday;
    }

    public String getXiugaibcstarttime() {
        return xiugaibcstarttime;
    }

    public void setXiugaibcstarttime(String xiugaibcstarttime) {
        this.xiugaibcstarttime = xiugaibcstarttime;
    }

    public String getXiugaibcendday() {
        return xiugaibcendday;
    }

    public void setXiugaibcendday(String xiugaibcendday) {
        this.xiugaibcendday = xiugaibcendday;
    }

    public String getXiugaibcendtime() {
        return xiugaibcendtime;
    }

    public void setXiugaibcendtime(String xiugaibcendtime) {
        this.xiugaibcendtime = xiugaibcendtime;
    }

    public String getWxchepai() {
        return wxchepai;
    }

    public void setWxchepai(String wxchepai) {
        this.wxchepai = wxchepai;
    }

    public int getCheci() {
        return checi;
    }

    public void setCheci(int checi) {
        this.checi = checi;
    }

    public String getWxopenId() {
        return wxopenId;
    }

    public void setWxopenId(String wxopenId) {
        this.wxopenId = wxopenId;
    }

    public String getChepai() {
        return chepai;
    }

    public void setChepai(String chepai) {
        this.chepai = chepai;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getZdfilename() {
        return zdfilename;
    }

    public void setZdfilename(String zdfilename) {
        this.zdfilename = zdfilename;
    }

    public String getClfilename() {
        return clfilename;
    }

    public void setClfilename(String clfilename) {
        this.clfilename = clfilename;
    }

    public String getWxfilename() {
        return wxfilename;
    }

    public void setWxfilename(String wxfilename) {
        this.wxfilename = wxfilename;
    }

    public int getGuanzhuwxuserid() {
        return guanzhuwxuserid;
    }

    public void setGuanzhuwxuserid(int guanzhuwxuserid) {
        this.guanzhuwxuserid = guanzhuwxuserid;
    }

    public int getGuanzhubancheid() {
        return guanzhubancheid;
    }

    public void setGuanzhubancheid(int guanzhubancheid) {
        this.guanzhubancheid = guanzhubancheid;
    }

    public String getWxusername() {
        return wxusername;
    }

    public void setWxusername(String wxusername) {
        this.wxusername = wxusername;
    }

    public String getWxuserpassword() {
        return wxuserpassword;
    }

    public void setWxuserpassword(String wxuserpassword) {
        this.wxuserpassword = wxuserpassword;
    }

    public String getWxusertele() {
        return wxusertele;
    }

    public void setWxusertele(String wxusertele) {
        this.wxusertele = wxusertele;
    }

    public String getWxsearchbanche() {
        return wxsearchbanche;
    }

    public void setWxsearchbanche(String wxsearchbanche) {
        this.wxsearchbanche = wxsearchbanche;
    }

    public int getXianluid() {
        return xianluid;
    }

    public void setXianluid(int xianluid) {
        this.xianluid = xianluid;
    }

    public int getFujinxianlu() {
        return fujinxianlu;
    }

    public void setFujinxianlu(int fujinxianlu) {
        this.fujinxianlu = fujinxianlu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTuichu() {
        return tuichu;
    }

    public void setTuichu(int tuichu) {
        this.tuichu = tuichu;
    }

    public String getAddbanchename() {
        return addbanchename;
    }

    public void setAddbanchename(String addbanchename) {
        this.addbanchename = addbanchename;
    }

    public String getAddbanchejianjie() {
        return addbanchejianjie;
    }

    public void setAddbanchejianjie(String addbanchejianjie) {
        this.addbanchejianjie = addbanchejianjie;
    }

    public String getAddbanchejiange() {
        return addbanchejiange;
    }

    public void setAddbanchejiange(String addbanchejiange) {
        this.addbanchejiange = addbanchejiange;
    }

    public String getAddbanchequancheng() {
        return addbanchequancheng;
    }

    public void setAddbanchequancheng(String addbanchequancheng) {
        this.addbanchequancheng = addbanchequancheng;
    }

    public String getAddbancheyunxingtime() {
        return addbancheyunxingtime;
    }

    public void setAddbancheyunxingtime(String addbancheyunxingtime) {
        this.addbancheyunxingtime = addbancheyunxingtime;
    }

    public String getAddbanchetime() {
        return addbanchetime;
    }

    public void setAddbanchetime(String addbanchetime) {
        this.addbanchetime = addbanchetime;
    }

    public int getAddbanchestatus() {
        return addbanchestatus;
    }

    public void setAddbanchestatus(int addbanchestatus) {
        this.addbanchestatus = addbanchestatus;
    }

    public String getCheckedsd() {
        return checkedsd;
    }

    public void setCheckedsd(String checkedsd) {
        this.checkedsd = checkedsd;
    }

    public long getAddsheibeiid() {
        return addsheibeiid;
    }

    public void setAddsheibeiid(long addsheibeiid) {
        this.addsheibeiid = addsheibeiid;
    }

    public int getAddshebeizhuangtai() {
        return addshebeizhuangtai;
    }

    public void setAddshebeizhuangtai(int addshebeizhuangtai) {
        this.addshebeizhuangtai = addshebeizhuangtai;
    }

    public String getAddshebeishoujihao() {
        return addshebeishoujihao;
    }

    public void setAddshebeishoujihao(String addshebeishoujihao) {
        this.addshebeishoujihao = addshebeishoujihao;
    }

    public String getAddchepai() {
        return addchepai;
    }

    public void setAddchepai(String addchepai) {
        this.addchepai = addchepai;
    }

    public String getAddchexing() {
        return addchexing;
    }

    public void setAddchexing(String addchexing) {
        this.addchexing = addchexing;
    }

    public int getAddcheling() {
        return addcheling;
    }

    public void setAddcheling(int addcheling) {
        this.addcheling = addcheling;
    }

    public int getAddzuoweishu() {
        return addzuoweishu;
    }

    public void setAddzuoweishu(int addzuoweishu) {
        this.addzuoweishu = addzuoweishu;
    }

    public String getAddjiashiyuan() {
        return addjiashiyuan;
    }

    public void setAddjiashiyuan(String addjiashiyuan) {
        this.addjiashiyuan = addjiashiyuan;
    }

    public String getAddtele() {
        return addtele;
    }

    public void setAddtele(String addtele) {
        this.addtele = addtele;
    }

    public String getAddcheliangzhaopian() {
        return addcheliangzhaopian;
    }

    public void setAddcheliangzhaopian(String addcheliangzhaopian) {
        this.addcheliangzhaopian = addcheliangzhaopian;
    }

    public long getAddclshebeiid() {
        return addclshebeiid;
    }

    public void setAddclshebeiid(long addclshebeiid) {
        this.addclshebeiid = addclshebeiid;
    }

    public int getAddclbancheid() {
        return addclbancheid;
    }

    public void setAddclbancheid(int addclbancheid) {
        this.addclbancheid = addclbancheid;
    }

    public String getAddcomdetname() {
        return addcomdetname;
    }

    public void setAddcomdetname(String addcomdetname) {
        this.addcomdetname = addcomdetname;
    }

    public String getAddcomdetjianjie() {
        return addcomdetjianjie;
    }

    public void setAddcomdetjianjie(String addcomdetjianjie) {
        this.addcomdetjianjie = addcomdetjianjie;
    }

    public String getAddcomdetaddress() {
        return addcomdetaddress;
    }

    public void setAddcomdetaddress(String addcomdetaddress) {
        this.addcomdetaddress = addcomdetaddress;
    }

    public String getAddcompanylxname() {
        return addcompanylxname;
    }

    public void setAddcompanylxname(String addcompanylxname) {
        this.addcompanylxname = addcompanylxname;
    }

    public String getAddcompanylxtele() {
        return addcompanylxtele;
    }

    public void setAddcompanylxtele(String addcompanylxtele) {
        this.addcompanylxtele = addcompanylxtele;
    }

    public String getAddcompanyname() {
        return addcompanyname;
    }

    public void setAddcompanyname(String addcompanyname) {
        this.addcompanyname = addcompanyname;
    }

    public String getAddcompanypass() {
        return addcompanypass;
    }

    public void setAddcompanypass(String addcompanypass) {
        this.addcompanypass = addcompanypass;
    }

    public int getSearchshebei() {
        return searchshebei;
    }

    public void setSearchshebei(int searchshebei) {
        this.searchshebei = searchshebei;
    }

    public long getSearchsheibeiid() {
        return searchsheibeiid;
    }

    public void setSearchsheibeiid(long searchsheibeiid) {
        this.searchsheibeiid = searchsheibeiid;
    }

    public int getSearchshebeizhuangtai() {
        return searchshebeizhuangtai;
    }

    public void setSearchshebeizhuangtai(int searchshebeizhuangtai) {
        this.searchshebeizhuangtai = searchshebeizhuangtai;
    }

    public long getDeleteshebeiid() {
        return deleteshebeiid;
    }

    public void setDeleteshebeiid(long deleteshebeiid) {
        this.deleteshebeiid = deleteshebeiid;
    }

    public int getUpdatestatus() {
        return updatestatus;
    }

    public void setUpdatestatus(int updatestatus) {
        this.updatestatus = updatestatus;
    }

    public int getSearchzhandian() {
        return searchzhandian;
    }

    public void setSearchzhandian(int searchzhandian) {
        this.searchzhandian = searchzhandian;
    }

    public int getSearchbanche() {
        return searchbanche;
    }

    public void setSearchbanche(int searchbanche) {
        this.searchbanche = searchbanche;
    }

    public String getSearchbanchename() {
        return searchbanchename;
    }

    public void setSearchbanchename(String searchbanchename) {
        this.searchbanchename = searchbanchename;
    }

    public int getSearchbanchezhuangtai() {
        return searchbanchezhuangtai;
    }

    public void setSearchbanchezhuangtai(int searchbanchezhuangtai) {
        this.searchbanchezhuangtai = searchbanchezhuangtai;
    }

    public int getXiugaibancheid() {
        return xiugaibancheid;
    }

    public void setXiugaibancheid(int xiugaibancheid) {
        this.xiugaibancheid = xiugaibancheid;
    }

    public int getXiugaizhandianid() {
        return xiugaizhandianid;
    }

    public void setXiugaizhandianid(int xiugaizhandianid) {
        this.xiugaizhandianid = xiugaizhandianid;
    }

    public int getDeletezhandianid() {
        return deletezhandianid;
    }

    public void setDeletezhandianid(int deletezhandianid) {
        this.deletezhandianid = deletezhandianid;
    }

    public String getXiugaizhandianname() {
        return xiugaizhandianname;
    }

    public void setXiugaizhandianname(String xiugaizhandianname) {
        this.xiugaizhandianname = xiugaizhandianname;
    }

    public int getXiugaizhandianyincang() {
        return xiugaizhandianyincang;
    }

    public void setXiugaizhandianyincang(int xiugaizhandianyincang) {
        this.xiugaizhandianyincang = xiugaizhandianyincang;
    }

    public int getXiugaizhandianxuhao() {
        return xiugaizhandianxuhao;
    }

    public void setXiugaizhandianxuhao(int xiugaizhandianxuhao) {
        this.xiugaizhandianxuhao = xiugaizhandianxuhao;
    }

    public int getXiugaizhandianstatus() {
        return xiugaizhandianstatus;
    }

    public void setXiugaizhandianstatus(int xiugaizhandianstatus) {
        this.xiugaizhandianstatus = xiugaizhandianstatus;
    }

    public String getXiugaizhandianjingdu() {
        return xiugaizhandianjingdu;
    }

    public void setXiugaizhandianjingdu(String xiugaizhandianjingdu) {
        this.xiugaizhandianjingdu = xiugaizhandianjingdu;
    }

    public String getXiugaizhandianweidu() {
        return xiugaizhandianweidu;
    }

    public void setXiugaizhandianweidu(String xiugaizhandianweidu) {
        this.xiugaizhandianweidu = xiugaizhandianweidu;
    }

    public int getXiugaizhandianbancheid() {
        return xiugaizhandianbancheid;
    }

    public void setXiugaizhandianbancheid(int xiugaizhandianbancheid) {
        this.xiugaizhandianbancheid = xiugaizhandianbancheid;
    }

    public int getSearchcheliang() {
        return searchcheliang;
    }

    public void setSearchcheliang(int searchcheliang) {
        this.searchcheliang = searchcheliang;
    }

    public String getSearchclchepai() {
        return searchclchepai;
    }

    public void setSearchclchepai(String searchclchepai) {
        this.searchclchepai = searchclchepai;
    }

    public long getSearchclshebeiid() {
        return searchclshebeiid;
    }

    public void setSearchclshebeiid(long searchclshebeiid) {
        this.searchclshebeiid = searchclshebeiid;
    }

    public String getXiugaiclchepai() {
        return xiugaiclchepai;
    }

    public void setXiugaiclchepai(String xiugaiclchepai) {
        this.xiugaiclchepai = xiugaiclchepai;
    }

    public int getDeletecheliangid() {
        return deletecheliangid;
    }

    public void setDeletecheliangid(int deletecheliangid) {
        this.deletecheliangid = deletecheliangid;
    }

    public int getXiugaicheliangid() {
        return xiugaicheliangid;
    }

    public void setXiugaicheliangid(int xiugaicheliangid) {
        this.xiugaicheliangid = xiugaicheliangid;
    }

    public String getXiugaichepai() {
        return xiugaichepai;
    }

    public void setXiugaichepai(String xiugaichepai) {
        this.xiugaichepai = xiugaichepai;
    }

    public String getXiugaichexing() {
        return xiugaichexing;
    }

    public void setXiugaichexing(String xiugaichexing) {
        this.xiugaichexing = xiugaichexing;
    }

    public int getXiugaicheling() {
        return xiugaicheling;
    }

    public void setXiugaicheling(int xiugaicheling) {
        this.xiugaicheling = xiugaicheling;
    }

    public int getXiugaizuoweishu() {
        return xiugaizuoweishu;
    }

    public void setXiugaizuoweishu(int xiugaizuoweishu) {
        this.xiugaizuoweishu = xiugaizuoweishu;
    }

    public String getXiugaijiashiyuan() {
        return xiugaijiashiyuan;
    }

    public void setXiugaijiashiyuan(String xiugaijiashiyuan) {
        this.xiugaijiashiyuan = xiugaijiashiyuan;
    }

    public String getXiugaicltele() {
        return xiugaicltele;
    }

    public void setXiugaicltele(String xiugaicltele) {
        this.xiugaicltele = xiugaicltele;
    }

    public String getXiugaicheliangzhaopian() {
        return xiugaicheliangzhaopian;
    }

    public void setXiugaicheliangzhaopian(String xiugaicheliangzhaopian) {
        this.xiugaicheliangzhaopian = xiugaicheliangzhaopian;
    }

    public long getXiugaiclshebeiid() {
        return xiugaiclshebeiid;
    }

    public void setXiugaiclshebeiid(long xiugaiclshebeiid) {
        this.xiugaiclshebeiid = xiugaiclshebeiid;
    }

    public int getXiugaiclbancheid() {
        return xiugaiclbancheid;
    }

    public void setXiugaiclbancheid(int xiugaiclbancheid) {
        this.xiugaiclbancheid = xiugaiclbancheid;
    }

    public int getSearchform() {
        return searchform;
    }

    public void setSearchform(int searchform) {
        this.searchform = searchform;
    }

    public int getXiugaibanchestatus() {
        return xiugaibanchestatus;
    }

    public void setXiugaibanchestatus(int xiugaibanchestatus) {
        this.xiugaibanchestatus = xiugaibanchestatus;
    }

    public String getXiugaibanchename() {
        return xiugaibanchename;
    }

    public void setXiugaibanchename(String xiugaibanchename) {
        this.xiugaibanchename = xiugaibanchename;
    }

    public String getXiugaibanchejianjie() {
        return xiugaibanchejianjie;
    }

    public void setXiugaibanchejianjie(String xiugaibanchejianjie) {
        this.xiugaibanchejianjie = xiugaibanchejianjie;
    }

    public String getXiugaibanchejiange() {
        return xiugaibanchejiange;
    }

    public void setXiugaibanchejiange(String xiugaibanchejiange) {
        this.xiugaibanchejiange = xiugaibanchejiange;
    }

    public String getXiugaibanchequancheng() {
        return xiugaibanchequancheng;
    }

    public void setXiugaibanchequancheng(String xiugaibanchequancheng) {
        this.xiugaibanchequancheng = xiugaibanchequancheng;
    }

    public String getXiugaibancheyunxing() {
        return xiugaibancheyunxing;
    }

    public void setXiugaibancheyunxing(String xiugaibancheyunxing) {
        this.xiugaibancheyunxing = xiugaibancheyunxing;
    }

    public String getXiugaibanchetime() {
        return xiugaibanchetime;
    }

    public void setXiugaibanchetime(String xiugaibanchetime) {
        this.xiugaibanchetime = xiugaibanchetime;
    }

    public int getXiugaibczhuangtai() {
        return xiugaibczhuangtai;
    }

    public void setXiugaibczhuangtai(int xiugaibczhuangtai) {
        this.xiugaibczhuangtai = xiugaibczhuangtai;
    }

    public int getSearchcompany() {
        return searchcompany;
    }

    public void setSearchcompany(int searchcompany) {
        this.searchcompany = searchcompany;
    }

    public String getSearchcomdetname() {
        return searchcomdetname;
    }

    public void setSearchcomdetname(String searchcomdetname) {
        this.searchcomdetname = searchcomdetname;
    }

    public int getXiugaicomdetid() {
        return xiugaicomdetid;
    }

    public void setXiugaicomdetid(int xiugaicomdetid) {
        this.xiugaicomdetid = xiugaicomdetid;
    }

    public String getXiugaicomdetname() {
        return xiugaicomdetname;
    }

    public void setXiugaicomdetname(String xiugaicomdetname) {
        this.xiugaicomdetname = xiugaicomdetname;
    }

    public String getXiugaicomdetjianjie() {
        return xiugaicomdetjianjie;
    }

    public void setXiugaicomdetjianjie(String xiugaicomdetjianjie) {
        this.xiugaicomdetjianjie = xiugaicomdetjianjie;
    }

    public String getXiugaicomdetxiugairess() {
        return xiugaicomdetxiugairess;
    }

    public void setXiugaicomdetxiugairess(String xiugaicomdetxiugairess) {
        this.xiugaicomdetxiugairess = xiugaicomdetxiugairess;
    }

    public String getXiugaicompanylxname() {
        return xiugaicompanylxname;
    }

    public void setXiugaicompanylxname(String xiugaicompanylxname) {
        this.xiugaicompanylxname = xiugaicompanylxname;
    }

    public String getXiugaicompanylxtele() {
        return xiugaicompanylxtele;
    }

    public void setXiugaicompanylxtele(String xiugaicompanylxtele) {
        this.xiugaicompanylxtele = xiugaicompanylxtele;
    }

    public String getXiugaicompanyname() {
        return xiugaicompanyname;
    }

    public void setXiugaicompanyname(String xiugaicompanyname) {
        this.xiugaicompanyname = xiugaicompanyname;
    }

    public String getXiugaicompanypass() {
        return xiugaicompanypass;
    }

    public void setXiugaicompanypass(String xiugaicompanypass) {
        this.xiugaicompanypass = xiugaicompanypass;
    }

}