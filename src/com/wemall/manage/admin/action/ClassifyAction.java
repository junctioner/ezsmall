package com.wemall.manage.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.domain.virtual.SysMap;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Classify;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.service.IClassifyService;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;


@Controller
public class ClassifyAction {
	
	@Autowired
	private IClassifyService classifyService;
	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    @Autowired
    private IRemarkService remarkService;
    
    @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/remark_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/classify_list.htm" })
    public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/classify_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.classifyService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/classify_list.htm", "",
                                            params, pList, mv);
        return mv;
    }
    
    @RequestMapping({ "/admin/loadAddClassify.htm" })
    public ModelAndView loadAddRemark(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mv = new JModelAndView("admin/blue/addClassify.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
    	Map<String, Object> map=new HashMap<String,Object>();
    	map.put("deleteStatus", false);
    	List<Remark> list=remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
    	mv.addObject("list", list);
    	return mv;
    }
    
    @RequestMapping({ "/admin/addClassify.htm" })
    public ModelAndView addSpecialSubject(String currentPage, String orderBy, String orderType,Classify classify, HttpServletRequest request, HttpServletResponse response,String classid) throws IllegalStateException, IOException{
    	Remark remark=new Remark();
    	remark.setId(Long.parseLong(classid));
    	classify.setRe(remark);
    	classify.setAddTime(new Date());
        boolean flag=classifyService.save(classify);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/classify_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.classifyService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/classify_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadEditClassify_list.htm" })
    public ModelAndView loadEditSpecialSubject(String currentPage, String orderBy, String orderType,Classify classify, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editClassify.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map map=new HashMap();
        map.put("deleteStatus", false);
        map.put("id", classify.getId());
        List<Classify> list=this.classifyService.query("from Classify bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        mv.addObject("classify", list.get(0));
        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("deleteStatus", false);
    	List<Remark> list2=remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map2, -1, -1);
    	mv.addObject("list", list2);
        return mv;
    }
    
    @RequestMapping({ "/admin/editClassify.htm" })
    public ModelAndView editSpecialSubject(String currentPage, String orderBy, String orderType,Classify classify, String classid,HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", classify.getId());
        List<Classify> list=this.classifyService.query("from Classify bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        Classify classify2 = list.get(0);
        classify2.setName(classify.getName());
        classify2.setRe(classify.getRe());
        classify2.setRemarkValue(classify.getRemarkValue());
        classify2.setTitle(!"".equals(classify.getTitle())?classify.getTitle():"");
        Remark remark=new Remark();
        remark.setId(Long.parseLong(classid));
        classify2.setRe(remark);
        boolean flag=classifyService.update(classify2);
        ModelAndView mv=null;
        if(flag){
        	mv = new JModelAndView("admin/blue/classify_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.classifyService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/classify_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/deleteClassify.htm" })
    public ModelAndView deleteSpecialSubject(String currentPage, String orderBy, String orderType,Classify classify, HttpServletRequest request, HttpServletResponse response){
    	boolean flag=classifyService.delete(classify.getId());
        ModelAndView mv=null;
        if(flag){
        	mv = new JModelAndView("admin/blue/classify_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.classifyService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/classify_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/getClassify.htm" })
    public ModelAndView getClassify(Classify classify, HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mv = new JModelAndView("admin/blue/classifyValue.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
		Map map = new HashMap();
		map.put("deleteStatus", false);
		map.put("id", classify.getId());
		mv.addObject("list", this.classifyService.query(
				"from Classify bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1));
		return mv;
        
    }

}
