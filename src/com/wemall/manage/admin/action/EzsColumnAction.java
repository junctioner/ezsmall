package com.wemall.manage.admin.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.domain.GoodsSpecification;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.IGoodsSpecificationService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class EzsColumnAction {
	
	@Autowired
	private IEzsColumnService ezsColumnService;
	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    @Autowired
    private IGoodsSpecificationService goodsSpecificationService;
    
    @Autowired
    private IGoodsClassService goodsClassService;
	
	@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/ezsColumn_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/ezsColumn_list.htm" })
    public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        List<EzsColumn> list = ezsColumnService.getAllEzsColumn();
        mv.addObject("ezsColumnList", list);
        return mv;
    }
    
    //@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/loadAddEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/loadAddEzsColumn.htm" })
    public ModelAndView loadAddEzsColumn(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/addColumn.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        List<GoodsSpecification> list= goodsSpecificationService.query("from GoodsSpecification bean where bean.deleteStatus =:deleteStatus", map, -1, -1);
        mv.addObject("goodsSpecifications", list);
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("deleteStatus", false);
        map2.put("level", 2);
        List<GoodsClass> list2 = goodsClassService.query("from GoodsClass bean where bean.deleteStatus=:deleteStatus and bean.level=:level", map2, -1, -1);
        mv.addObject("goodsClasss", list2);
        return mv;
    }
    
    //@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/addEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/addEzsColumn.htm" })
    public ModelAndView addEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response){
        String prepareColumn=request.getParameter("prepareColumn");
        String [] prepare = StringUtils.split(prepareColumn, ",");
        List<GoodsSpecification> list=new ArrayList<GoodsSpecification>();
        for (String string : prepare) {
        	GoodsSpecification gif=new GoodsSpecification();
        	gif.setId(Long.parseLong(string));
        	System.out.println(string);
        	list.add(gif);
		}
        column.setAddTime(new Date());
        column.setGsps(list);
        column.setPrepareColumn(null);
        boolean flag=ezsColumnService.save(column);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            List<EzsColumn> li = ezsColumnService.getAllEzsColumn();
            mv.addObject("ezsColumnList", li);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadEditEzsColumn.htm" })
    public ModelAndView loadEditEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        List<GoodsSpecification> list= goodsSpecificationService.query("from GoodsSpecification bean where bean.deleteStatus =:deleteStatus", map, -1, -1);
        mv.addObject("goodsSpecifications", list);
        Map<String,Object> map2=new HashMap<String,Object>();
        map2.put("deleteStatus", false);
        map2.put("level", 2);
        List<GoodsClass> list2 = goodsClassService.query("from GoodsClass bean where bean.deleteStatus=:deleteStatus and bean.level=:level", map2, -1, -1);
        mv.addObject("goodsClasss", list2);
        Map<String,Object> map3=new HashMap<String,Object>();
        map3.put("deleteStatus", false);
        map3.put("id", column.getId());
        List<EzsColumn> list3=ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map3, -1, -1);
        mv.addObject("ezsColumn", list3.get(0));
        return mv;
    }
    
    @RequestMapping({ "/admin/editColumn.htm" })
    public ModelAndView editColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response){
        String prepareColumn=request.getParameter("prepareColumn");
        String [] prepare = StringUtils.split(prepareColumn, ",");
        List<GoodsSpecification> list=new ArrayList<GoodsSpecification>();
        for (String string : prepare) {
        	GoodsSpecification gif=new GoodsSpecification();
        	gif.setId(Long.parseLong(string));
        	list.add(gif);
		}
        column.setGsps(list);
        column.setPrepareColumn(null);
        boolean flag=ezsColumnService.update(column);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            List<EzsColumn> li = ezsColumnService.getAllEzsColumn();
            mv.addObject("ezsColumnList", li);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadViewEzsColumn.htm" })
    public ModelAndView loadViewEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }
    
    @RequestMapping({ "/admin/loadSeeEzsColumn.htm" })
    public ModelAndView loadSeeEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }

}
