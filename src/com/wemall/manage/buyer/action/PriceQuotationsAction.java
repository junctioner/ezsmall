package com.wemall.manage.buyer.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.domain.virtual.SysMap;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.DocumentShare;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.domain.query.ReportQueryObject;
import com.wemall.foundation.service.IDocumentShareService;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IEzsSubstanceService;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

import net.sf.json.JSONObject;

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
	
	@Autowired
	private IDocumentShareService documentShareService;

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
        //返回研究报告的链接
        share(mv);
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
    	String hql="from EzsSubstance bean where bean.deleteStatus=:deleteStatus order by bean.clickRate";
        List<EzsSubstance> ezsSubstances = ezsSubstanceService.query(hql, map, 0, 10);
        mv.addObject("ezsSubstances", ezsSubstances);
        if(ecId!=null&&!"".equals(ecId)){
        	mv.addObject("ecId", Integer.parseInt(ecId));
        }
    	if(childEc!=null&&!"".equals(childEc)){
    		mv.addObject("childEc", Integer.parseInt(childEc));
        }
    	//返回研究报告的链接
        share(mv);
        return mv;
    }
    
    public void share(ModelAndView mv){
    	Map map=new HashMap();
    	map.put("deleteStatus", false);
    	List<EzsColumn> list = this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
    	for (EzsColumn ezsColumn : list) {
			if(ezsColumn.getName().equals("市场调研")){
				mv.addObject("scdy", ezsColumn.getId());
			}else if(ezsColumn.getName().equals("分析预测")){
				mv.addObject("fxyc", ezsColumn.getId());
			}else if(ezsColumn.getName().equals("政策解读")){
				mv.addObject("zcjd", ezsColumn.getId());
			}else if(ezsColumn.getName().equals("专访报道")){
				mv.addObject("zfbd", ezsColumn.getId());
			}
		}
    }
    
    @RequestMapping({"/signContentPage.htm"})
    public ModelAndView signContentPage(String id,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
    	ModelAndView mv = new JModelAndView("signContentPage.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "clickRate",
                orderType);
        qo.setPageSize(10);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
        Map map=new HashMap();
    	map.put("deleteStatus", false);
    	map.put("id", Long.parseLong(id));
    	List<EzsSubstance> list = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    	mv.addObject("ezsSubstance", list.get(0));
    	list.get(0).setClickRate(list.get(0).getClickRate()+1);
    	this.ezsSubstanceService.update(list.get(0));
    	//返回研究报告的链接
        share(mv);
        Map map3=new HashMap();
        map3.put("deleteStatus", false);
        map3.put("id", Long.parseLong(id));
        map3.put("uid", ((User)request.getSession().getAttribute("user")).getId());
    	List<DocumentShare> documentShares = this.documentShareService.query("from DocumentShare bean where bean.deleteStatus=:deleteStatus and bean.e.id=:id and bean.u.id=:uid", map3, -1, -1);
    	if(documentShares!=null&&documentShares.size()>0){
    		mv.addObject("documentShare", documentShares.get(0));
    	}
        return mv;
    }
    
    @RequestMapping({"/giveOrUp.htm"})
    public void giveOrUp(HttpServletRequest request, HttpServletResponse response,PrintWriter out,String id,@RequestParam(value="give",required = false)Integer give,@RequestParam(value="house",required = false)Integer house){
    	boolean flag=false;
    	boolean fl=false;
    	Map map2 = new HashMap();
    	try {
    		Map map=new HashMap();
	    	map.put("deleteStatus", false);
	    	map.put("id", Long.parseLong(id));
	    	DocumentShare documentShare=null;
	    	List<DocumentShare> list = this.documentShareService.query("from DocumentShare bean where bean.deleteStatus=:deleteStatus and bean.e.id=:id", map, -1, -1);
	    	if(list==null||list.size()==0){
	    		documentShare=new DocumentShare();
	    		fl=false;
	    	}else{
	    		documentShare=list.get(0);
	    		fl=true;
	    	}
	    	if(give!=null){
	    		if((documentShare.getGive()==1&&give==1)||(documentShare.getGive()==2&&give==2)){
	    			documentShare.setGive(0);
	    			map2.put("give", give);
	    			map2.put("giveStatus", false);
	    		}else{
	    			documentShare.setGive(give);
	    			map2.put("give", give);
	    			map2.put("giveStatus", true);
	    		}
	    	}
	    	if(house!=null){
	    		if(documentShare.getHouse()==0){
	    			map2.put("houseStatus", false);
	    			documentShare.setHouse(1);
	    		}else{
	    			map2.put("houseStatus", false);
	    			documentShare.setHouse(0);
	    		}
	    	}
	    	if(fl){
	    		User user=(User) request.getSession().getAttribute("user");
	    		documentShare.setU(user);
	    		flag=this.documentShareService.update(documentShare);
	    	}else{
	    		User user=(User) request.getSession().getAttribute("user");
	    		documentShare.setU(user);
	    		documentShare.setAddTime(new Date());
	    		EzsSubstance ezsSubstance=new EzsSubstance();
	    		ezsSubstance.setId(Long.parseLong(id));
	    		documentShare.setE(ezsSubstance);
	    		flag=this.documentShareService.save(documentShare);
	    	}
	    	map2.put("flag", flag);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			out.print(JSONObject.fromObject(map2).toString());
			out.flush();
			out.close();
		}
    }
    
}
