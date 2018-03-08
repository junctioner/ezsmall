package com.wemall.manage.admin.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.tools.CommUtil;
import com.wemall.core.tools.WebForm;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.CrmContacts;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.domain.GoodsClassStaple;
import com.wemall.foundation.domain.GoodsType;
import com.wemall.foundation.domain.query.GoodsClassQueryObject;
import com.wemall.foundation.service.ICrmConsumerService;
import com.wemall.foundation.service.ICrmContactsService;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/**
 * 客户管理控制器
 */
@Controller
public class CustomerManageAction {
	
	   @Autowired
	    private ISysConfigService configService;

	    @Autowired
	    private IUserConfigService userConfigService;
	    @Autowired
	    private  IGoodsClassService goodsClassService;
	    
	    @Autowired
	    private ICrmConsumerService  crmConsumerService;
	    @Autowired
	    private  ICrmContactsService crmContactsService;
	
	 @SecurityMapping(display = false, rsequence = 0, title = "商品分类列表", value = "/admin/crm_t_list.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class1", rgroup = "商品q")
	    @RequestMapping({"/admin/crm_t_list.htm"})
	    public ModelAndView crm_t_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType){
	        ModelAndView mv = new JModelAndView("admin/blue/crm_t_list.html",
	                                            this.configService.getSysConfig(),
	                                            this.userConfigService.getUserConfig(), 0, request, response);
	        GoodsClassQueryObject qo = new GoodsClassQueryObject(currentPage, mv,
	                "id", "asc");
	    qo.addQuery("obj.deleteStatus = 0 ", null);
	        WebForm wf = new WebForm();
	        wf.toQueryPo(request, qo, GoodsClass.class, mv);
	        IPageList pList = this.crmContactsService.list(qo);
	        String url = this.configService.getSysConfig().getAddress();
	        if ((url == null) || (url.equals(""))){
	            url = CommUtil.getURL(request);
	        }
	        CommUtil.saveIPageList2ModelAndView(
	            url + "/admin/crm_t_list.htm", "", "", pList, mv);
	            

//	        mv.addObject("crmConsumer", this.crmConsumerService.getCrmConsumerList());
	        
	        return mv;
	    }
	 
	  @SecurityMapping(display = false, rsequence = 0, title = "商品分类批量删除", value = "/admin/goods_class_del.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class", rgroup = "商品")
	    @RequestMapping({"/admin/crm_t_del.htm"})
	    public String crm_t_del(HttpServletRequest request, String id, String currentPage){
	                    this.crmContactsService.delete( Long.valueOf(id));
	                                
	        return "redirect:crm_t_list.htm?currentPage=" + currentPage;
	    }
	  
	
	 
	 
	    @SecurityMapping(display = false, rsequence = 0, title = "客户编辑", value = "/admin/crm_t_edit.htm*", rtype = "admin", rname = "客户管理", rcode = "goods_class", rgroup = "商品")
	    @RequestMapping({"/admin/crm_t_edit.htm"})
	    public ModelAndView crm_t_edit(HttpServletRequest request, HttpServletResponse response, String id, String currentPage){
	        ModelAndView mv = new JModelAndView("admin/blue/crm_t_edit.html",
	                                            this.configService.getSysConfig(),
	                                            this.userConfigService.getUserConfig(), 0, request, response);
	        if ((id != null) && (!id.equals(""))){
	        	CrmContacts crmContacts = this.crmContactsService.getObjById(
	                                        Long.valueOf(Long.parseLong(id)));
	            mv.addObject("obj", crmContacts);
	            CrmConsumer  crmConsumer=null;
	        if(crmContacts.getConsumer()!=null){
	        	  crmConsumer=	this.crmConsumerService.getObjById(crmContacts.getConsumer().getId());
	        }
	            mv.addObject("gts",crmConsumer);
	            mv.addObject("currentPage", currentPage);
	            mv.addObject("edit", Boolean.valueOf(true));
	        }

	        return mv;
	    }
	    @SecurityMapping(display = false, rsequence = 0, title = "客户保存", value = "/admin/crm_t_save.htm*", rtype = "admin", rname = "客户管理", rcode = "", rgroup = "客户")
	    @RequestMapping({"/admin/crm_t_save.htm"})
	    public ModelAndView crm_t_save(HttpServletRequest request, HttpServletResponse response, String id, CrmContacts crmContacts){
	        WebForm wf = new WebForm();
	        GoodsClass goodsClass = null;
	      
	        if (id.equals(""))
	            this.crmContactsService.save(crmContacts);
	       else{
	            this.crmContactsService.update(crmContacts);
	        }
	        ModelAndView mv = new JModelAndView("admin/blue/success.html",
	                                            this.configService.getSysConfig(),
	                                            this.userConfigService.getUserConfig(), 0, request, response);
	        mv.addObject("op_title", "客户保存成功");
	

	        return mv;
	    }
	    
	    
		 @SecurityMapping(display = false, rsequence = 0, title = "商品分类列表", value = "/admin/crm_t_list.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class1", rgroup = "商品q")
		    @RequestMapping({"/admin/crm_down_list.htm"})
		    public ModelAndView crm_down_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType){
		        ModelAndView mv = new JModelAndView("admin/blue/crm_down_list.html",
		                                            this.configService.getSysConfig(),
		                                            this.userConfigService.getUserConfig(), 0, request, response);
		        GoodsClassQueryObject qo = new GoodsClassQueryObject(currentPage, mv,
		                "id", "asc");
		     //   qo.addQuery("obj.parent.id is null", null);
		        WebForm wf = new WebForm();
		        wf.toQueryPo(request, qo, GoodsClass.class, mv);
		        IPageList pList = this.crmConsumerService.list(qo);
		        String url = this.configService.getSysConfig().getAddress();
		        if ((url == null) || (url.equals(""))){
		            url = CommUtil.getURL(request);
		        }
		        CommUtil.saveIPageList2ModelAndView(
		            url + "/admin/crm_down_list.htm", "", "", pList, mv);
		            

//		        mv.addObject("crmConsumer", this.crmConsumerService.getCrmConsumerList());
		        
		        return mv;
		    }
		 
		 
		 /**
			 * 模板下载   wangxiao
			 * @param request
			 * @param response
			 */
		    @RequestMapping({"/admin/dtemplateDown.htm"})
		   public void dtemplateDown(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
				 String path = session.getServletContext().getRealPath("/") + "/WEB-INF/dtemplate/客户导入模板.xlsx";
					//	String path = "C:/Users/wangxiao/Desktop/SIM卡信息20170306172813.xls";
				 try {
				      File file = new File(path);
				      String filename = file.getName();
				      InputStream fis = new BufferedInputStream(new FileInputStream(path));
				      byte[] buffer = new byte[fis.available()];
				      fis.read(buffer);
				      fis.close();
				      response.reset();
				      //设置文件名
				      String agent = request.getHeader("User-Agent");
				      boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
					  // 解决IE下面问题
				      if (isMSIE) {
				    	  filename = URLEncoder.encode(filename, "UTF-8");
				      } else {
				    	  filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
				      }
				      response.setHeader("Content-disposition", "attachment;filename=" + filename);
				      response.addHeader("Content-Length", "" + file.length());
				      OutputStream os = new BufferedOutputStream(response.getOutputStream());
				      response.setContentType("application/octet-stream");
				      os.write(buffer);
				      os.flush();
				      os.close();
				    } catch (IOException ex) {
				      ex.printStackTrace();
				    }
				   
				
			}
		    
		    @RequestMapping("/admin/uploadFile.htm")
			public ModelAndView uploadFile(HttpServletRequest request,HttpServletResponse response, PrintWriter out,HttpSession session) {
		    	  ModelAndView mv = new JModelAndView("admin/blue/crm_down_list.html",
                          this.configService.getSysConfig(),
                          this.userConfigService.getUserConfig(), 0, request, response);
			
					String outPath = File.separator+"FileUpload"+File.separator+"temp"+File.separator;
					String saveFilePath = CommUtil.getRealPath(request, outPath);
				/*	Map uploadFile = CommUtil.saveFileToServer(request, "importFile",saveFilePath, null, null);
					File file = new File(uploadFile.get("path").toString());*/
					 mv.addObject("op_title", "客户保存成功");
						

				        return mv;
		    }
		    
			 @SecurityMapping(display = false, rsequence = 0, title = "商品分类列表", value = "/admin/crm_audit_list.htm*", rtype = "admin", rname = "分类管理", rcode = "goods_class1", rgroup = "商品q")
			    @RequestMapping({"/admin/crm_audit_list.htm"})
			    public ModelAndView crm_audit_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType){
			        ModelAndView mv = new JModelAndView("admin/blue/crm_audit_list.html",
			                                            this.configService.getSysConfig(),
			                                            this.userConfigService.getUserConfig(), 0, request, response);
			        GoodsClassQueryObject qo = new GoodsClassQueryObject(currentPage, mv,
			                "id", "asc");
			     //   qo.addQuery("obj.parent.id is null", null);
			        WebForm wf = new WebForm();
			        wf.toQueryPo(request, qo, GoodsClass.class, mv);
			        IPageList pList = this.crmConsumerService.list(qo);
			        String url = this.configService.getSysConfig().getAddress();
			        if ((url == null) || (url.equals(""))){
			            url = CommUtil.getURL(request);
			        }
			        CommUtil.saveIPageList2ModelAndView(
			            url + "/admin/crm_audit_list.htm", "", "", pList, mv);
			            

//			        mv.addObject("crmConsumer", this.crmConsumerService.getCrmConsumerList());
			        
			        return mv;
			    }

}




