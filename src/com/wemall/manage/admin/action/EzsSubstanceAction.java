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
import com.wemall.core.tools.WebForm;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.domain.SpecialSubject;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IEzsSubstanceService;
import com.wemall.foundation.service.ISpecialSubjectService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class EzsSubstanceAction {

	@Autowired
	private IEzsSubstanceService ezsSubstanceService;
	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    @Autowired
    private IEzsColumnService ezsColumnService; 
    
    @Autowired
    private ISpecialSubjectService specialSubjectService;
    
    @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/ezsSubstance_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/ezsSubstance_list.htm" })
    public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "", params, pList, mv);
        return mv;
    }
    
    @RequestMapping({ "/admin/loadAddEzsSubstance.htm" })
    public ModelAndView loadAddRemark(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mv = new JModelAndView("admin/blue/addEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
    	Map<String, Object> map=new HashMap<String,Object>();
    	map.put("deleteStatus", false);
    	List<EzsColumn> ezsColumns=ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
    	mv.addObject("ezsColumns", ezsColumns);
    	Map<String, Object> map2=new HashMap<String,Object>();
    	map2.put("deleteStatus", false);
    	List<SpecialSubject> specialSubjects=specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus", map2, -1, -1);
    	mv.addObject("specialSubjects", specialSubjects);
    	return mv;
    }
    
    @RequestMapping({ "/admin/addEzsSubstance.htm" })
    public ModelAndView addEzsSubstance(String ecId,String ssId,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        //检查form中是否有enctype="multipart/form-data"
    	 //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
    	WebForm wf = new WebForm();
    	EzsSubstance ezsSubstance = null;
    	ezsSubstance = (EzsSubstance)wf.toPo(request, EzsSubstance.class);
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        List thumbnail=new ArrayList();
        List attachment=new ArrayList();
        List multimediaFiles=new ArrayList();
        List photos=new ArrayList();
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
		                  .getRealPath("/") +
		                  uploadFilePath + File.separator + "ezsSubstance";
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                	Map map = new HashMap();
                    String path=request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator+file.getOriginalFilename();
                    //上传
                    String fileName = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
      		        map = CommUtil.saveFileToServer(request, file.getName(), saveFilePathName,
      		                            fileName, null);
      		        if("a".equals(file.getName()+"")){
      		        	thumbnail.add(map.get("fileName"));
	              	}else if("b".equals(file.getName()+"")){
	              		attachment.add(map.get("fileName"));
	              	}else if("c".equals(file.getName()+"")){
	              		multimediaFiles.add(map.get("fileName"));
	              	}else if("d".equals(file.getName()+"")){
	              		photos.add(map.get("fileName"));
	              	}
                    //file.transferTo(new File(path));
                }
                 
            }
           
        }
        if(thumbnail!=null&&thumbnail.size()>0){
        	ezsSubstance.setThumbnail(StringUtils.join(thumbnail.toArray(),","));
        }
        if(attachment!=null&&attachment.size()>0){
        	ezsSubstance.setAttachment(StringUtils.join(attachment.toArray(),","));
        }
        if(multimediaFiles!=null&&multimediaFiles.size()>0){
        	ezsSubstance.setMultimediaFiles(StringUtils.join(multimediaFiles.toArray(),","));
        }
        if(photos!=null&&photos.size()>0){
        	ezsSubstance.setPhotos(StringUtils.join(photos.toArray(),","));
        }
        EzsColumn ezsColumn=new EzsColumn();
        if(!"".equals(ecId)){
        	ezsColumn.setId(Long.parseLong(ecId));
        	ezsSubstance.setEc(ezsColumn);
        }
        SpecialSubject specialSubject=new SpecialSubject();
        if(!"".equals(ssId)){
        	specialSubject.setId(Long.parseLong(ssId));
        	ezsSubstance.setSs(specialSubject);
        }
        ezsSubstance.setStatus(1);
        ezsSubstance.setStaticStatus(1);
        ezsSubstance.setAddTime(new Date());
        User u=(User) request.getSession().getAttribute("user");
        ezsSubstance.setU(u);
        boolean flag=ezsSubstanceService.save(ezsSubstance);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadEditEzsSubstance.htm" })
    public ModelAndView loadEditEzsSubstance(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map map=new HashMap();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        mv.addObject("ezsSubstance", list.get(0));
        Map<String, Object> map2=new HashMap<String,Object>();
        map2.put("deleteStatus", false);
    	List<EzsColumn> ezsColumns=ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus", map2, -1, -1);
    	mv.addObject("ezsColumns", ezsColumns);
    	Map<String, Object> map3=new HashMap<String,Object>();
    	map3.put("deleteStatus", false);
    	List<SpecialSubject> specialSubjects=specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus", map3, -1, -1);
    	mv.addObject("specialSubjects", specialSubjects);
        return mv;
    }
    
    @RequestMapping({ "/admin/editEzsSubstance.htm" })
    public ModelAndView editSpecialSubject(String ecId,String ssId,String currentPage, String orderBy, String orderType,String columnid,String ssid, HttpServletRequest request, HttpServletResponse response) throws IOException{
    	WebForm wf = new WebForm();
    	EzsSubstance ezsSubstance = null;
    	ezsSubstance = (EzsSubstance)wf.toPo(request, EzsSubstance.class);
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        List thumbnail=new ArrayList();
        List attachment=new ArrayList();
        List multimediaFiles=new ArrayList();
        List photos=new ArrayList();
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
		                  .getRealPath("/") +
		                  uploadFilePath + File.separator + "ezsSubstance";
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                	Map map = new HashMap();
                    String path=request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator+file.getOriginalFilename();
                    //上传
                    String fileName = file.getOriginalFilename() == null ? "" : file.getOriginalFilename();
      		        map = CommUtil.saveFileToServer(request, file.getName(), saveFilePathName,
      		                            fileName, null);
      		        if("a".equals(file.getName()+"")){
      		        	thumbnail.add(map.get("fileName"));
	              	}else if("b".equals(file.getName()+"")){
	              		attachment.add(map.get("fileName"));
	              	}else if("c".equals(file.getName()+"")){
	              		multimediaFiles.add(map.get("fileName"));
	              	}else if("d".equals(file.getName()+"")){
	              		photos.add(map.get("fileName"));
	              	}
                    //file.transferTo(new File(path));
                }
                 
            }
           
        }
        if(thumbnail!=null&&thumbnail.size()>0){
        	ezsSubstance.setThumbnail(StringUtils.join(thumbnail.toArray(),","));
        }
        if(attachment!=null&&attachment.size()>0){
        	ezsSubstance.setAttachment(StringUtils.join(attachment.toArray(),","));
        }
        if(multimediaFiles!=null&&multimediaFiles.size()>0){
        	ezsSubstance.setMultimediaFiles(StringUtils.join(multimediaFiles.toArray(),","));
        }
        if(photos!=null&&photos.size()>0){
        	ezsSubstance.setPhotos(StringUtils.join(photos.toArray(),","));
        }
        EzsColumn ezsColumn=new EzsColumn();
        if(!"".equals(ecId)){
        	ezsColumn.setId(Long.parseLong(ecId));
        	ezsSubstance.setEc(ezsColumn);
        }
        SpecialSubject specialSubject=new SpecialSubject();
        if(!"".equals(ssId)){
        	specialSubject.setId(Long.parseLong(ssId));
        	ezsSubstance.setSs(specialSubject);
        }
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        ezsSubstance2.setAddTime(ezsSubstance.getAddTime());
        ezsSubstance2.setAttachment(!"".equals(ezsSubstance.getAttachment())?ezsSubstance.getAttachment():"");
        ezsSubstance2.setAttribute(ezsSubstance.getAttribute());
        ezsSubstance2.setAuthor(ezsSubstance.getAuthor());
        ezsSubstance2.setBold(ezsSubstance.isBold());
        ezsSubstance2.setContent(!"".equals(ezsSubstance.getContent())?ezsSubstance.getContent():"");
        ezsSubstance2.setDeleteStatus(ezsSubstance.isDeleteStatus());
        ezsSubstance2.setEc(ezsSubstance.getEc());
        ezsSubstance2.setSs(ezsSubstance.getSs());
        boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 加载被物理删除的类
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param request
     * @param response
     * @return
     */
    @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/loadDeleteEzsSubstance.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/loadDeleteEzsSubstance.htm" })
    public ModelAndView loadDeleteEzsSubstance(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "", params, pList, mv);
        return mv;
    }
    
    /**
     * 文档回收钻删除文档
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/deleteTrueEzsSubstance.htm" })
    public ModelAndView deleteTrueEzsSubstance(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	boolean flag=ezsSubstanceService.delete(ezsSubstance.getId());
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 物理删除文档
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/deleteEzsSubstance.htm" })
    public ModelAndView deleteSpecialSubject(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        ezsSubstance2.setDeleteStatus(true);
    	boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 文档审核
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/loadCheckEzsSubstance.htm" })
    public ModelAndView loadCheckEzsSubstance(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	boolean flag=ezsSubstanceService.delete(ezsSubstance.getId());
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/loadReturnEzsSubstance.htm" })
    public ModelAndView loadReturnEzsSubstance(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", true);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        ezsSubstance2.setDeleteStatus(false);
    	boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, orderBy,
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
	
}
