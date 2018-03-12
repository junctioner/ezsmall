package com.wemall.manage.admin.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.domain.virtual.SysMap;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class RemarkAction {
	
	@Autowired
	private IRemarkService remarkService;
	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/remark_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/remark_list.htm" })
    public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/remark_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.remarkService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/remark_list.htm", "", params, pList, mv);
        return mv;
    }
    
    @RequestMapping({ "/admin/loadAddRemark.htm" })
    public ModelAndView loadAddRemark(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mv = new JModelAndView("admin/blue/addRemark.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }
    
    @RequestMapping({ "/admin/addRemark.htm" })
    public ModelAndView addSpecialSubject(String currentPage, String orderBy, String orderType,Remark remark, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        //检查form中是否有enctype="multipart/form-data"
    	remark.setAddTime(new Date());
        boolean flag=remarkService.save(remark);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/remark_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.remarkService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/remark_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadEditRemark.htm" })
    public ModelAndView loadEditSpecialSubject(String currentPage, String orderBy, String orderType,Remark remark, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editRemark.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map map=new HashMap();
        map.put("deleteStatus", false);
        map.put("id", remark.getId());
        List<Remark> list=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        mv.addObject("remark", list.get(0));
        return mv;
    }
    
    @RequestMapping({ "/admin/editRemark.htm" })
    public ModelAndView editSpecialSubject(String currentPage, String orderBy, String orderType,Remark remark, HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", remark.getId());
        List<Remark> list=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        Remark remark2 = list.get(0);
        remark2.setName(remark.getName());
        remark2.setTitle(!"".equals(remark.getTitle())?remark.getTitle():"");
        boolean flag=remarkService.update(remark2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/remark_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.remarkService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/remark_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/deleteRemark.htm" })
    public ModelAndView deleteSpecialSubject(String currentPage, String orderBy, String orderType,Remark remark, HttpServletRequest request, HttpServletResponse response){
    	boolean flag=remarkService.delete(remark.getId());
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/remark_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.remarkService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/remark_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }

}
