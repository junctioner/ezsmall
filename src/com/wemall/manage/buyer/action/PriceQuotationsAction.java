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
import com.wemall.foundation.domain.query.EzsSubstanceQueryObject;
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
    public ModelAndView report(HttpServletRequest request, HttpServletResponse response, String currentPage,String pId){
    	ModelAndView mv = new JModelAndView("priceQuotations.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
    	EzsSubstanceQueryObject rqo = new EzsSubstanceQueryObject(currentPage, mv, null,null);
        IPageList pList = this.ezsSubstanceService.list(rqo);
        CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
        Map map=new HashMap();
    	map.put("deleteStatus", false);
        List<Remark> list=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
        mv.addObject("remarks", list);
        //返回研究报告的链接
        share(mv);
        map.clear();
        if(null==pId){
    		pId="12";
    	}
    	map.put("pId", Long.parseLong(pId));
    	map.put("deleteStatus", false);
    	//取4条数据
    	List<EzsColumn> list2 = this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.parentEzsColumn.id=:pId order by id", map, 0, 5);
    	for (int i = 0; i < list2.size(); i++) {
    		mv.addObject("ezsColumn"+i, list2.get(i));
		}        
        return mv;
    }
    
    @RequestMapping({"/priceQuotations2.htm"})
    public ModelAndView report2(HttpServletRequest request, HttpServletResponse response, String currentPage,String pId){
        ModelAndView mv = new JModelAndView("priceQuotations3.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);

        Map map=new HashMap();
    	map.put("deleteStatus", false);   
    	List<EzsSubstance> objs = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus order by bean.id desc ", map, -1, -1);
        mv.addObject("objs", objs);
        //返回研究报告的链接
        map.clear();
        if(null==pId){
    		pId="11";
    	}
    	map.put("pId", Long.parseLong(pId));
    	map.put("deleteStatus", false);
    	//取4条数据
    	List<EzsColumn> list2 = this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.parentEzsColumn.id=:pId order by id", map, 0, 4);
    	for (int i = 0; i < list2.size(); i++) {
    		mv.addObject("ezsColumn"+i, list2.get(i));
		}
        return mv;
    }
    /***
     * 
     * 帮助中心-列表
     * @throws UnsupportedEncodingException
     */
    @RequestMapping({"/helpCenter.htm"})
    public ModelAndView helpCenter(String childEc,String ecId,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response,String pId) throws UnsupportedEncodingException{
    	ModelAndView mv = new JModelAndView("help_center_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
    	Map map=new HashMap(); 
    	//帮助中心的ID
    	if(null==pId){
    		pId="19";
    	}
    	map.put("pId", Long.parseLong(pId));
    	map.put("deleteStatus", false);
    	//取4条数据
    	List<EzsColumn> list = this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.parentEzsColumn.id=:pId order by id", map, 0, 4);
    	//取三级栏目
    	List<EzsColumn> ezss = null;
    	map.clear();   	
    	map.put("deleteStatus", false);
    	for (int i = 0; i < list.size(); i++) {
    		mv.addObject("ezsColumn"+i, list.get(i));
    		map.put("pId", list.get(i).getId());
    		ezss =this.ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.parentEzsColumn.id=:pId order by id", map, -1, -1);
    		mv.addObject("ezss"+i, ezss);
    	}
    	return mv;
    }
    /**
     * 异步获取文章和内容
     */
   
   @RequestMapping("/helpCenterContent.htm")
   public ModelAndView helpCenterContent(String id,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
	    ModelAndView mv = new JModelAndView("help_center_content.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
	    try {
	    	String url = this.configService.getSysConfig().getAddress();
	        if ((url == null) || (url.equals(""))){
	            url = CommUtil.getURL(request);
	        }
	    	EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",null);
	    	qo.setPageSize(3);
	        if(id!=null&&!"".equals(id)){
	        	qo.addQuery("obj.ec.id",new SysMap("id",Long.parseLong(id)),"=");
	        }
	    	IPageList pList = this.ezsSubstanceService.list(qo);
	        CommUtil.saveIPageList2ModelAndView(url + "/helpCenterContent.htm", "", "", pList, mv);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return mv;
    }
   
   /**
    * 异步获取单个文章的内容
    */
  
  @RequestMapping({ "/helpCenterDetailed.htm" })
  public ModelAndView helpCenterDetailed(String id, HttpServletRequest request, HttpServletResponse response){
	    response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
	    ModelAndView mv = new JModelAndView("help_center_detailed.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
	    try {
	    	Map map=new HashMap(); 
	    	map.put("id", Long.parseLong(id));
	    	map.put("deleteStatus", false);
	    	//获取对应id的文章
	    	List<EzsSubstance> objs = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id ", map, 0, 1);
		    mv.addObject("ezssubstance", objs.get(0)); 
	    } catch (Exception e) {
			e.printStackTrace();
		}		
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
        EzsSubstanceQueryObject  qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
        qo.setPageSize(2);
        if(ecId!=null&&!"".equals(ecId)){
        	mv.addObject("ecId",ecId);
        	qo.addQuery("obj.ec.id",new SysMap("id",Long.parseLong(ecId)),"=");
        }
        if(childEc!=null&&!"".equals(childEc.trim())){
        	qo.addQuery("obj.childEc.id",new SysMap("id",Long.parseLong(childEc.trim())),"=");
        }
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/changePage.htm", "",
                params, pList, mv);
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
    	//取点赞数量最多的前10条
        List<DocumentShare> dcs = this.documentShareService.query("from DocumentShare bean where bean.deleteStatus=:deleteStatus ORDER BY give desc", map, 0, 10);
        mv.addObject("dcs", dcs);
    	//返回研究报告的链接
        //share(mv);
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
    public ModelAndView signContentPage(String id,String ecId,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
    	ModelAndView mv = new JModelAndView("signContentPage.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
    	Map map=new HashMap();
    	map.put("deleteStatus", false);  
    	//取点击前10的栏目
    	List<EzsSubstance> objs = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus order by clickRate desc ", map, 0, 10);
        mv.addObject("objs", objs);
        //取点赞数量最多的前10条
        List<EzsSubstance> dcs = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus order by clickLike desc ", map, 0, 10);
        mv.addObject("dcs", dcs);
        map.clear();
    	map.put("deleteStatus", false);
    	map.put("id", Long.parseLong(id));
    	List<EzsSubstance> list = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    	mv.addObject("ezsSubstance", list.get(0));
    	//查询上一条
    	List<EzsSubstance> up = null;
    	//查询下一条
    	List<EzsSubstance> down = null;
    	map.clear();
    	map.put("deleteStatus", false);
    	map.put("id", Long.parseLong(id));
    	if(("").equals(ecId)||null==ecId){
    		 up = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id>:id  ORDER BY bean.id", map, 0, 1);    		    	
	    	 down = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id <:id  ORDER BY bean.id desc", map, 0, 1);
    	}else{
	    	 map.put("ecId", Long.parseLong(ecId));
	    	 up = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id>:id and bean.ec.id =:ecId ORDER BY bean.id", map, 0, 1);    		    	
	    	 down = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id <:id and bean.ec.id =:ecId ORDER BY bean.id desc", map, 0, 1);
    	}
    	if(!up.isEmpty()){
        	mv.addObject("ezsSubstanceUp", up.get(0));
        }
    	if(!down.isEmpty()){    		
    		mv.addObject("ezsSubstanceDown", down.get(0));
    	}
    	//点击量加1
    	list.get(0).setClickRate(list.get(0).getClickRate()+1);
    	this.ezsSubstanceService.update(list.get(0));
    	map.clear();
        map.put("deleteStatus", false);
        map.put("id", Long.parseLong(id));
    	List<DocumentShare> documentShares = this.documentShareService.query("from DocumentShare bean where bean.deleteStatus=:deleteStatus and bean.e.id=:id", map, -1, -1);
    	if(documentShares!=null&&documentShares.size()>0){
    		mv.addObject("documentShare", documentShares.get(0));
    	}
    	mv.addObject("ecId", ecId);
        return mv;
    }
    
    @RequestMapping({"/giveOrUp.htm"})
    public void giveOrUp(HttpServletRequest request, HttpServletResponse response,PrintWriter out,String id,@RequestParam(value="give",required = false)Integer give,@RequestParam(value="house",required = false)Integer house){
    	Map map=new HashMap();
    	map.put("deleteStatus", false);
    	map.put("id", Long.parseLong(id));
    	List<EzsSubstance> ezs = this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    	boolean flag=false;
    	boolean fl=false;
    	Map map2 = new HashMap();
    	try {
    		map.clear();
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
	    			if(give==1){
		    			//点赞的数量减1
		    			     ezs.get(0).setClickLike(ezs.get(0).getClickLike()-1);
		    		}else if(give==2){
		    			//点踩的数量减1	
		    				 ezs.get(0).setClickRrample(ezs.get(0).getClickRrample()-1);
		    		}
	    	    	this.ezsSubstanceService.update(ezs.get(0));
	    		}else{
	    			documentShare.setGive(give);
	    			map2.put("give", give);
	    			map2.put("giveStatus", true);
	    			if(give==1){
	    			//点赞的数量加1
	    			     ezs.get(0).setClickLike(ezs.get(0).getClickLike()+1);
	    			}else if(give==2){
	    			//点踩的数量加1	
	    				 ezs.get(0).setClickRrample(ezs.get(0).getClickRrample()+1);
	    			}
	    	    	this.ezsSubstanceService.update(ezs.get(0));
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
			e.printStackTrace();
		} finally {
			out.print(JSONObject.fromObject(map2).toString());
			out.flush();
			out.close();
		}
    }
    
}
