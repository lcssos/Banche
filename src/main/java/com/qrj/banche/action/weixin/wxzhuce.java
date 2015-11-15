package com.qrj.banche.action.weixin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qrj.banche.entity.Wxuser;
import com.qrj.banche.repository.WxuserMapper;
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

@Component("wxzhuce")
@Scope("prototype")
public class wxzhuce extends ActionSupport implements ModelDriven<Object> {
    private SearchInfo searchInfo = new SearchInfo();

    @Resource
    private WxuserMapper wxuserMapper;

    private File upload;

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = dateFormat.format(calendar.getTime());
        String prefix = "";
        String lujing = "";
        if (searchInfo.getWxfilename().length() > 0) {
            prefix = searchInfo.getWxfilename().substring(searchInfo.getWxfilename().lastIndexOf("."));
            lujing = request.getSession().getServletContext().getRealPath("/upload");
            String yuantulujing = lujing + "/weixin/user/yuan/" + time + prefix;
            InputStream is = new FileInputStream(upload);
            OutputStream os = new FileOutputStream(yuantulujing);
            byte buffer[] = new byte[8192];
            int count = 0;
            while ((count = is.read(buffer)) > 0) {
                os.write(buffer, 0, count);
            }
            os.close();
            is.close();

            Thumbnails.of(yuantulujing).size(256, 256).keepAspectRatio(false).toFile(lujing + "/weixin/user/256/" + time + prefix);
        }
        Wxuser wxuser = new Wxuser();
        wxuser.setWxuserUsername(searchInfo.getWxusername());
        wxuser.setWxuserPassword(searchInfo.getWxuserpassword());
        wxuser.setWxuserTele(searchInfo.getWxusertele());
        if (searchInfo.getWxfilename().length() > 0) {
            wxuser.setWxuserTouxiang(lujing + "/weixin/user/256/" + time + prefix);
        }
        wxuserMapper.insert(wxuser);
        return "success";
    }

    public wxzhuce() {

    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    @Override
    public Object getModel() {
        return searchInfo;
    }
}
