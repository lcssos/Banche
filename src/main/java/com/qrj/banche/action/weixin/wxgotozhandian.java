package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Cheliang;
import com.qrj.banche.entity.Shebeilishi;
import com.qrj.banche.entity.Zhandian;
import com.qrj.banche.repository.CheliangMapper;
import com.qrj.banche.repository.ShebeilishiMapper;
import com.qrj.banche.repository.ZhandianMapper;
import com.qrj.banche.util.Getdistance;
import com.qrj.banche.vo.SearchInfo;
import org.apache.struts2.ServletActionContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("wxgotozhandian")
public class wxgotozhandian extends ActionSupport
        implements ModelDriven<Object>
{
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private CheliangMapper cheliangMapper;

//    @Resource
//    private ZhandianMapper zhandianMapper;

    @Resource
    private ShebeilishiMapper shebeilishiMapper;

    private List<Cheliang> cheliangs;
    private List<Zhandian> zhandians;
    private List<Shebeilishi> shebeilishis;

    public String execute() throws Exception { HttpServletRequest request = ServletActionContext.getRequest();
        return null; }

    @Scheduled(cron="0/25 * * * * ?")
    public void changgotozhandian()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        Date now = new Date();
        Date afterDate = new Date(now.getTime() - 25000);
        String thtime = sdf.format(afterDate);
        List shebeis = shebeilishiMapper.findhuodong(thtime);
        for (int z = 0; z < shebeis.size(); z++) {
            this.shebeilishis = shebeilishiMapper.finddayushebeilishishijianandshebeiid(thtime, Long.valueOf((String)shebeis.get(z)).longValue());
            if (this.shebeilishis.size() > 1) {
                this.cheliangs = cheliangMapper.findByshebeiid(Long.valueOf((String)shebeis.get(z)).longValue());
                if (this.cheliangs.size() > 0) {
                    Cheliang cheliang = (Cheliang)this.cheliangs.get(0);
                    //todo
//                    this.zhandians = zhandianMapper.findByBancheId(cheliang.getBancheId());
                    changwangfan(cheliang, this.zhandians);
                    if (cheliang.getCheliangWangfan().intValue() == 0) {
                        double yidong1 = Getdistance.GetLongDistance(((Shebeilishi) this.shebeilishis.get(0)).getShebeilishiShebeijingdu().doubleValue(), ((Shebeilishi) this.shebeilishis.get(0)).getShebeilishiShebeiweidu().doubleValue(), ((Zhandian) this.zhandians.get(cheliang.getCheliangCurrentzhandian().intValue() - 1)).getZhandianJingdu().doubleValue(), ((Zhandian) this.zhandians.get(cheliang.getCheliangGotozhandian().intValue() - 1)).getZhandianWeidu().doubleValue());
                        double yidong2 = Getdistance.GetLongDistance(((Shebeilishi)this.shebeilishis.get(1)).getShebeilishiShebeijingdu().doubleValue(), ((Shebeilishi)this.shebeilishis.get(1)).getShebeilishiShebeiweidu().doubleValue(), ((Zhandian)this.zhandians.get(cheliang.getCheliangGotozhandian().intValue() - 1)).getZhandianJingdu().doubleValue(), ((Zhandian)this.zhandians.get(cheliang.getCheliangGotozhandian().intValue() - 1)).getZhandianWeidu().doubleValue());
                       if (yidong1 > 100D) {
                           if ((cheliang.getCheliangCurrentzhandian() + 1) < zhandians.size()) {
                               cheliang.setCheliangGotozhandian(cheliang.getCheliangCurrentzhandian() + 1);
                               cheliangMapper.updateByPrimaryKeySelective(cheliang);
                           }
                       }
                        if (yidong2 < 100D) {
                            cheliang.setCheliangCurrentzhandian(cheliang.getCheliangGotozhandian());
                            cheliangMapper.updateByPrimaryKeySelective(cheliang);
                        }
                    }
                }
            }
        }
    }

    public void changwangfan(Cheliang cheliang, List<Zhandian> zhandians)
    {
        boolean timechang = false;

        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd");
        String time = dateFormat.format(calendar.getTime());

        String[] nowtimes = time.split(":");
        String[] wangfantimes = cheliang.getCheliangWangfantime().split(":");
        if (Integer.valueOf(wangfantimes[0]).intValue() >= Integer.valueOf(nowtimes[0]).intValue()) {
            if (Integer.valueOf(wangfantimes[1]).intValue() >= Integer.valueOf(nowtimes[1]).intValue()) {
                if (Integer.valueOf(wangfantimes[2]).intValue() >= Integer.valueOf(nowtimes[2]).intValue())
                    timechang = false;
                else
                    timechang = true;
            }
            else
                timechang = true;
        }
        else {
            timechang = true;
        }
        List shebeilishis = shebeilishiMapper.findByshebeilishishijianandshebeiid(time, cheliang.getShebeiId().longValue());
        if (shebeilishis.size() > 0) {
            int thegps = 0;
            for (int i = 0; i < shebeilishis.size(); i++) {
                String[] times = ((Shebeilishi)shebeilishis.get(i)).getShebeilishiShebeishijian().split(":");
                if ((Integer.valueOf(times[3]).intValue() > 5) && (Integer.valueOf(times[4]).intValue() > 30)) {
                    thegps = i;
                }
            }
            double diyitiao = Getdistance.GetLongDistance(((Shebeilishi)shebeilishis.get(thegps)).getShebeilishiShebeijingdu().doubleValue(), ((Shebeilishi)shebeilishis.get(thegps)).getShebeilishiShebeiweidu().doubleValue(), ((Zhandian)zhandians.get(0)).getZhandianJingdu().doubleValue(), ((Zhandian)zhandians.get(0)).getZhandianWeidu().doubleValue());
            double diertiao = Getdistance.GetLongDistance(((Shebeilishi)shebeilishis.get(thegps)).getShebeilishiShebeijingdu().doubleValue(), ((Shebeilishi)shebeilishis.get(thegps)).getShebeilishiShebeiweidu().doubleValue(), ((Zhandian)zhandians.get(zhandians.size() - 1)).getZhandianJingdu().doubleValue(), ((Zhandian)zhandians.get(zhandians.size() - 1)).getZhandianWeidu().doubleValue());
            if (timechang == true)
            {
                if (diyitiao > diertiao) {
                    if (diyitiao - diertiao < 1000.0D) {
                        System.out.println("a1");
                        cheliang.setCheliangWangfan(Integer.valueOf(0));
                    } else {
                        System.out.println("a2");
                        cheliang.setCheliangWangfan(Integer.valueOf(1));
                    }
                } else { System.out.println("a3");
                    cheliang.setCheliangWangfan(Integer.valueOf(0));
                }
                System.out.println("a");
                cheliang.setCheliangCurrentzhandian(Integer.valueOf(1));
                cheliang.setCheliangGotozhandian(Integer.valueOf(1));
                cheliang.setCheliangWangfantime(time);
                cheliangMapper.updateByPrimaryKeySelective(cheliang);
            } else {
                if ((cheliang.getCheliangWangfan().intValue() == 0) && (diertiao < 200.0D)) {
                    System.out.println("车辆" + cheliang.getCheliangChepai() +"变更为返程");
                    cheliang.setCheliangWangfan(Integer.valueOf(1));
                    cheliang.setCheliangCurrentzhandian(Integer.valueOf(1));
                    cheliang.setCheliangGotozhandian(Integer.valueOf(1));
                    cheliang.setCheliangWangfantime(time);
                    cheliangMapper.updateByPrimaryKeySelective(cheliang);
                }
                if ((cheliang.getCheliangWangfan().intValue() == 1) && (diyitiao < 200.0D)) {
                    System.out.println("车辆" + cheliang.getCheliangChepai() +"变更为去程");
                    cheliang.setCheliangWangfan(Integer.valueOf(0));
                    cheliang.setCheliangCurrentzhandian(Integer.valueOf(1));
                    cheliang.setCheliangGotozhandian(Integer.valueOf(1));
                    cheliang.setCheliangWangfantime(time);
                    cheliangMapper.updateByPrimaryKeySelective(cheliang);
                }
            }
        }
    }

    public Object getModel()
    {
        return this.searchInfo;
    }
}