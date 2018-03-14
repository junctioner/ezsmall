package com.wemall.manage.buyer.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.domain.virtual.SysMap;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.domain.query.ReportQueryObject;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IEzsSubstanceService;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class PriceQuotationsAction {

	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
	@Autowired
	private IEzsSubstanceService ezsSubstanceService;
	
	@Autowired
	private IRemarkService remarkService;
	
	@Autowired
	private IEzsColumnService ezsColumnService;

    //@SecurityMapping(display = false, rsequence = 0, title = "买家举报列表", value = "priceQuotations.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
    @RequestMapping({"/priceQuotations.htm"})
    public ModelAndView report(HttpServletRequest request, HttpServletResponse response, String currentPage){
        ModelAndView mv = new JModelAndView(
            "priceQuotations.html", this.configService
            .getSysConfig(),
            this.userConfigService.getUserConfig(), 1, request, response);
        ReportQueryObject rqo = new ReportQueryObject(currentPage, mv, null,
                null);
/*        rqo.addQuery("obj.user.id",
                     new SysMap("user_id",
                                SecurityUserHolder.getCurrentUser().getId()), "=");*/
        IPageList pList = this.ezsSubstanceService.list(rqo);
        CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
        Map map=new HashMap();
    	map.put("deleteStatus", false);
        List<Remark> list=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
        mv.addObject("remarks", list);
        return mv;
    }
    
    @RequestMapping({"/changePage.htm"})
    public ModelAndView changePage(String childEc,String ecId,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
    	ModelAndView mv = new JModelAndView("priceQuotationsList.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "id",
                orderType);
        qo.setPageSize(2);
        if(ecId!=null&&!"".equals(ecId)){
        	qo.addQuery("obj.ec.id",new SysMap("id",Long.parseLong(ecId)),"=");
        }
        if(childEc!=null&&!"".equals(childEc.trim())){
        	qo.addQuery("obj.childEc.id",new SysMap("id",Long.parseLong(childEc.trim())),"=");
        }
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
        Map map=new HashMap();
    	map.put("deleteStatus", false);
    	String me="";
    	if(ecId!=null&&!"".equals(ecId)){
    		map.put("id", Long.parseLong(ecId));
    		me="and bean.ec.id=:id";
        }
    	if(childEc!=null&&!"".equals(childEc.trim())){
    		map.put("id", Long.parseLong(childEc.trim()));
    		me="and bean.childEc.id=:id";
        }
    	String hql="from EzsSubstance bean where bean.deleteStatus=:deleteStatus "+me+"order by bean.clickRate";
        List<EzsSubstance> ezsSubstances = ezsSubstanceService.query(hql, map, 0, 10);
        mv.addObject("ezsSubstances", ezsSubstances);
        if(ecId!=null&&!"".equals(ecId)){
        	mv.addObject("ecId", Integer.parseInt(ecId));
        }
    	if(childEc!=null&&!"".equals(childEc)){
    		mv.addObject("childEc", Integer.parseInt(childEc));
        }
    	Map map2=new HashMap();
    	map2.put("deleteStatus", false);
    	map2.put("name", "市场调研");
    	List<EzsColumn> list = this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.name=:name", map2, -1, -1);
        return mv;
    }
    
}
