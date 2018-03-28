package com.wemall.manage.admin.action;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.SpecialSubject;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.domain.query.EzsColumnQueryObject;
import com.wemall.foundation.domain.query.EzsSubstanceQueryObject;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IEzsSubstanceService;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISpecialSubjectService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class EzsSubstanceAction {
	
	@Autowired
	private IRemarkService remarkService;

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
    public ModelAndView admin_list(String name,String userName,String publicTime,String ec,String userId,String status,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        ModelAndView mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
    	Map<String, Object> map=new HashMap<String,Object>();
    	map.put("deleteStatus", false);
    	List<EzsColumn> ezsColumns=ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus", map, -1, -1);
    	mv.addObject("ezsColumns", ezsColumns);
        String params = "";
        EzsColumnQueryObject qo = new EzsColumnQueryObject(currentPage, mv, "id",orderType);
        if(userId!=null&&!"".equals(userId)){
        	qo.addQuery("obj.u.id",new SysMap("id",((User) request.getSession().getAttribute("user")).getId()),"=");
        }
        if(status!=null&&!"".equals(status)){
        	qo.addQuery("obj.status",new SysMap("status",Integer.parseInt(status)),"=");
        }
        if(name!=null&&!"".equals(name)){
        	name=new String(name.trim().getBytes("ISO-8859-1"), "UTF-8");
        	qo.addQuery("obj.name",new SysMap("name", "%" +
        			name.trim() + "%"), "like");
        	mv.addObject("name", name);
        }
        if(userName!=null&&!"".equals(userName)){
        	qo.addQuery("obj.u.userName",new SysMap("userName", "%" +
        			userName.trim() + "%"), "like");
        	mv.addObject("userName", userName);
        }
        if(publicTime!=null&&!"".equals(publicTime)){
        	qo.addQuery("obj.publicTime",new SysMap("publicTime",getPastDate(Integer.parseInt(publicTime))),">");
        	mv.addObject("publicTime", Integer.parseInt(publicTime));
        }
        if(ec!=null&&!"".equals(ec)){
        	qo.addQuery("obj.ec.id",new SysMap("id",Long.parseLong(ec)),"=");
        	mv.addObject("ecId", Long.parseLong(ec));
        }
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "", params, pList, mv);
        return mv;
    }
    
    /**
      * 获取过去第几天的日期(- 操作) 或者 未来 第几天的日期( + 操作)
      *
      * @param past
      * @return
      */
	 public static Date getPastDate(int past) {
	     Calendar calendar = Calendar.getInstance();
	     calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
	     Date today = calendar.getTime();
	     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String result = format.format(today);
	     return today;
	 }
    
	 /**
	  * 加载新增文档的页面
	  * @param currentPage
	  * @param orderBy
	  * @param orderType
	  * @param request
	  * @param response
	  * @return
	  */
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
    	Map map3=new HashMap();
    	map3.put("deleteStatus", false);
        List<Remark> list=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map3, -1, -1);
        mv.addObject("remarks", list);
    	return mv;
    }
    
    /**
     * 新增文档
     * @param ecId
     * @param ssId
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param request
     * @param response
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping({ "/admin/addEzsSubstance.htm" })
    public ModelAndView addEzsSubstance(String childEcId,String ecId,String ssId,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
        //检查form中是否有enctype="multipart/form-data"
    	 //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
    	WebForm wf = new WebForm();
    	EzsSubstance ezsSubstance = null;
    	ezsSubstance = (EzsSubstance)wf.toPo(request, EzsSubstance.class);
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List thumbnail=new ArrayList();
        List attachment=new ArrayList();
        List multimediaFiles=new ArrayList();
        List photos=new ArrayList();
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
		                  .getRealPath("/") +
		                  uploadFilePath + File.separator + "ezsSubstance";
		//判断 request 是否有文件上传,即多部分请求...  
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
                    String fileName = file.getOriginalFilename();
                    if(fileName!=null&&!"".equals(fileName)){
                    	fileName=UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
                    }
      		        //map = CommUtil.saveFileToServer(request, file.getName(), saveFilePathName,fileName, null);
      		        if("a".equals(file.getName()+"")){
      		        	thumbnail.add(fileName);
	              	}else if("b".equals(file.getName()+"")){
	              		attachment.add(fileName);
	              	}else if("c".equals(file.getName()+"")){
	              		multimediaFiles.add(fileName);
	              	}else if("d".equals(file.getName()+"")){
	              		photos.add(fileName);
	              	}
      		        if(fileName!=null&&!"".equals(fileName)){
      		        	upload(saveFilePathName,fileName,file);
      		        }
                    //file.transferTo(new File(saveFilePathName+File.separator+fileName));
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
        if(!"".equals(ecId)&&null!=ecId){
        	ezsColumn.setId(Long.parseLong(ecId));
        	ezsSubstance.setEc(ezsColumn);
        }
        EzsColumn ezsColumn2=new EzsColumn();
        if(!"".equals(childEcId)&&null!=childEcId){
        	ezsColumn2.setId(Long.parseLong(childEcId));
        	ezsSubstance.setChildEc(ezsColumn2);
        }
        SpecialSubject specialSubject=new SpecialSubject();
        if(!"".equals(ssId)&&null!=ssId){
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
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    public void upload(String saveFilePathName,String fileName,MultipartFile file) throws IOException{
    	File path = new File(saveFilePathName);
        if (!path.exists()){
            path.mkdir();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        DataOutputStream out = new DataOutputStream(
            new FileOutputStream(saveFilePathName + File.separator + fileName));
        InputStream is = null;
        try {
            is = file.getInputStream();
            byte[] buffer = new byte[1024];
            while (is.read(buffer) > 0)
                out.write(buffer);
        } catch (IOException exception){
            exception.printStackTrace();
        } finally {
            if (is != null){
                is.close();
            }
            if (out != null){
                out.close();
            }
        }
    }
    
    /**
     * 加载修改文档的页面
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
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
    	Map map4=new HashMap();
    	map4.put("deleteStatus", false);
        List<Remark> list4=this.remarkService.query("from Remark bean where bean.deleteStatus=:deleteStatus", map4, -1, -1);
        mv.addObject("remarks", list4);
        return mv;
    }
    
    /**
     * 修改文档
     * @param ecId
     * @param ssId
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param columnid
     * @param ssid
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
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
                    String fileName = file.getOriginalFilename();
                    if(fileName!=null&&!"".equals(fileName)){
                    	fileName=UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
                    }
      		        //map = CommUtil.saveFileToServer(request, file.getName(), saveFilePathName,fileName, null);
      		        if("a".equals(file.getName()+"")){
      		        	thumbnail.add(fileName);
	              	}else if("b".equals(file.getName()+"")){
	              		attachment.add(fileName);
	              	}else if("c".equals(file.getName()+"")){
	              		multimediaFiles.add(fileName);
	              	}else if("d".equals(file.getName()+"")){
	              		photos.add(fileName);
	              	}
      		        if(fileName!=null&&!"".equals(fileName)){
      		        	upload(saveFilePathName,fileName,file);
      		        }
                    //file.transferTo(new File(saveFilePathName+File.separator+fileName));
                }
                 
            }
           
        }
		Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        if(thumbnail!=null&&thumbnail.size()>0){
        	ezsSubstance.setThumbnail(StringUtils.join(thumbnail.toArray(),","));
        	String string=ezsSubstance2.getThumbnail();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()&&file.isFile()){
					file.delete();
				}
			}
        }
        if(attachment!=null&&attachment.size()>0){
        	ezsSubstance.setAttachment(StringUtils.join(attachment.toArray(),","));
        	String string=ezsSubstance2.getAttachment();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()&&file.isFile()){
					file.delete();
				}
			}
        }
        if(multimediaFiles!=null&&multimediaFiles.size()>0){
        	ezsSubstance.setMultimediaFiles(StringUtils.join(multimediaFiles.toArray(),","));
        	String string=ezsSubstance2.getMultimediaFiles();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()&&file.isFile()){
					file.delete();
				}
			}
        }
        if(photos!=null&&photos.size()>0){
        	ezsSubstance.setPhotos(StringUtils.join(photos.toArray(),","));
        	String string=ezsSubstance2.getPhotos();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()&&file.isFile()){
					file.delete();
				}
			}
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
        ezsSubstance2.setThumbnail(!"".equals(ezsSubstance.getThumbnail())?ezsSubstance.getThumbnail():(!"".equals(ezsSubstance2.getThumbnail())?ezsSubstance2.getThumbnail():""));
        ezsSubstance2.setAttachment(!"".equals(ezsSubstance.getAttachment())?ezsSubstance.getAttachment():(!"".equals(ezsSubstance2.getAttachment())?ezsSubstance2.getAttachment():""));
        ezsSubstance2.setMultimediaFiles(!"".equals(ezsSubstance2.getMultimediaFiles())?ezsSubstance.getMultimediaFiles():(!"".equals(ezsSubstance2.getMultimediaFiles())?ezsSubstance2.getMultimediaFiles():""));
        ezsSubstance2.setPhotos(!"".equals(ezsSubstance.getPhotos())?ezsSubstance.getPhotos():(!"".equals(ezsSubstance2.getPhotos())?ezsSubstance2.getPhotos():""));
        ezsSubstance2.setAttribute(ezsSubstance.getAttribute());
        ezsSubstance2.setAuthor(ezsSubstance.getAuthor());
        ezsSubstance2.setBold(ezsSubstance.isBold());
        ezsSubstance2.setContent(!"".equals(ezsSubstance.getContent())?ezsSubstance.getContent():"");
        ezsSubstance2.setDeleteStatus(ezsSubstance.isDeleteStatus());
        ezsSubstance2.setEc(ezsSubstance.getEc());
        ezsSubstance2.setSs(ezsSubstance.getSs());
        ezsSubstance2.setRemarkValue(ezsSubstance.getRemarkValue());
        boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
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
        EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, orderBy, orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "", params, pList, mv);
        return mv;
    }
    
    /**
     * 文档回收站删除实际文档
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
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
                .getRealPath("/") +
                uploadFilePath + File.separator + "ezsSubstance";
    	if(ezsSubstance2!=null&&!"".equals(ezsSubstance2.getThumbnail())){
        	String string=ezsSubstance2.getThumbnail();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(ezsSubstance2!=null&&!"".equals(ezsSubstance2.getAttachment())){
        	String string=ezsSubstance2.getAttachment();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(ezsSubstance2!=null&&!"".equals(ezsSubstance2.getMultimediaFiles())){
        	String string=ezsSubstance2.getMultimediaFiles();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(ezsSubstance2!=null&&!"".equals(ezsSubstance2.getPhotos())){
        	String string=ezsSubstance2.getPhotos();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	boolean flag=ezsSubstanceService.delete(ezsSubstance.getId());
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
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
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id", orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 加载文档审核页面
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
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        ModelAndView mv=null;
        if(ezsSubstance2!=null){
            mv = new JModelAndView("admin/blue/ezsSubstance_sign.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            mv.addObject("ezsSubstance", ezsSubstance2);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 审核文档
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/checkEzsSubstance.htm" })
    public ModelAndView checkEzsSubstance(String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        ezsSubstance2.setStatus(2);
        boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "", params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 文档回收站中的还原
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/loadReturnEzsSubstance.htm" })
    public ModelAndView loadReturnEzsSubstance(String status,String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String,Object>();
    	if(status!=null&&!"".equals(status)){
        	map.put("deleteStatus", false);
        }else{
        	map.put("deleteStatus", true);
        }
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        if(status!=null&&!"".equals(status)){
        	ezsSubstance2.setStatus(3);
        }else{
        	ezsSubstance2.setDeleteStatus(false);
        }
    	boolean flag=ezsSubstanceService.update(ezsSubstance2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/deleteEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
            IPageList pList = this.ezsSubstanceService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/loadDeleteEzsSubstance.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    /**
     * 加载移动,复制,保存固顶的页面
     * @param status
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/loadMoveEzsSubstance.htm" })
    public ModelAndView loadMoveEzsSubstance(String span,String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=null;
        mv = new JModelAndView("admin/blue/moveEzsSubstance.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", ezsSubstance.getId());
        List<EzsSubstance> list=this.ezsSubstanceService.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        EzsSubstance ezsSubstance2 = list.get(0);
        mv.addObject("ezsSubstance", ezsSubstance2);
    	Map<String, Object> map2=new HashMap<String,Object>();
    	map2.put("deleteStatus", false);
    	List<EzsColumn> ezsColumns=ezsColumnService.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus", map2, -1, -1);
    	mv.addObject("ezsColumns", ezsColumns);
    	if(span!=null&&!"".equals(span)){
    		mv.addObject("span", Integer.parseInt(span));
    	}
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, orderBy,orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",true),"=");
        IPageList pList = this.ezsSubstanceService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
                                            params, pList, mv);
        return mv;
    }
    
    /**
     * 移动,复制,保存固顶
     * @param span
     * @param ecId
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param ezsSubstance
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({ "/admin/moveEzsSubstance.htm" })
    public ModelAndView moveEzsSubstance(String span,String ecId,String currentPage, String orderBy, String orderType,EzsSubstance ezsSubstance, HttpServletRequest request, HttpServletResponse response){
    	    boolean flag=false;	
    	    if(span!=null&&"1".equals(span)){//移动
    	    	Map<String, Object> map = new HashMap<String, Object>();
    			map.put("deleteStatus", false);
    			map.put("id", ezsSubstance.getId());
    			List<EzsSubstance> list = this.ezsSubstanceService
    					.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    			EzsSubstance ezsSubstance2 = list.get(0);
    			EzsColumn ezsColumn = new EzsColumn();
    			ezsColumn.setId(!"".equals(ecId) ? Long.parseLong(ecId) : ezsSubstance2.getEc().getId());
    			ezsSubstance2.setEc(ezsColumn);
    		    flag = this.ezsSubstanceService.update(ezsSubstance2);
    	    }else if(span!=null&&"2".equals(span)){//复制
    	    	Map<String, Object> map = new HashMap<String, Object>();
    			map.put("deleteStatus", false);
    			map.put("id", ezsSubstance.getId());
    			List<EzsSubstance> list = this.ezsSubstanceService
    					.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    			EzsSubstance ezsSubstance2 = list.get(0);
    			EzsSubstance ezsSubstance3=new EzsSubstance();
    			EzsColumn ezsColumn = new EzsColumn();
    			ezsColumn.setId(!"".equals(ecId) ? Long.parseLong(ecId) : ezsSubstance2.getEc().getId());
    			ezsSubstance3.setEc(ezsColumn);
    			ezsSubstance3.setAttachment(ezsSubstance2.getAttachment());
    			ezsSubstance3.setAddTime(new Date());
    			ezsSubstance3.setAttribute(ezsSubstance2.getAttribute());
    			ezsSubstance3.setAuthor(ezsSubstance2.getAuthor());
    			ezsSubstance3.setBold(ezsSubstance2.isBold());
    			ezsSubstance3.setClickRate(ezsSubstance2.getClickRate());
    			ezsSubstance3.setContent(ezsSubstance2.getContent());
    			ezsSubstance3.setDeleteStatus(ezsSubstance2.isDeleteStatus());
    			ezsSubstance3.setFixedTime(ezsSubstance2.getFixedTime());
    			ezsSubstance3.setKeyWord(ezsSubstance2.getKeyWord());
    			ezsSubstance3.setLinkPort(ezsSubstance2.isLinkPort());
    			ezsSubstance3.setLinkUrl(ezsSubstance2.getLinkUrl());
    			ezsSubstance3.setMeta(ezsSubstance2.getMeta());
    			ezsSubstance3.setMultimediaFiles(ezsSubstance2.getMultimediaFiles());
    			ezsSubstance3.setName(ezsSubstance2.getName());
    			ezsSubstance3.setOrigin(ezsSubstance2.getOrigin());
    			ezsSubstance3.setOriginUrl(ezsSubstance2.getOriginUrl());
    			ezsSubstance3.setPcView(ezsSubstance2.isPcView());
    			ezsSubstance3.setPhotos(ezsSubstance2.getPhotos());
    			ezsSubstance3.setPublicTime(ezsSubstance2.getPublicTime());
    			ezsSubstance3.setRemarkValue(ezsSubstance2.getRemarkValue());
    			ezsSubstance3.setSs(ezsSubstance2.getSs());
    			ezsSubstance3.setStaticStatus(ezsSubstance2.getStaticStatus());
    			ezsSubstance3.setStatus(1);
    			ezsSubstance3.setSubheading(ezsSubstance2.getSubheading());
    			ezsSubstance3.setTagTitle(ezsSubstance2.getTagTitle());
    			ezsSubstance3.setThumbnail(ezsSubstance2.getThumbnail());
    			ezsSubstance3.setTitleColor(ezsSubstance2.getTitleColor());
    			ezsSubstance3.setU(ezsSubstance2.getU());
    		    flag = this.ezsSubstanceService.save(ezsSubstance3);
    	    }else if(span!=null&&"3".equals(span)){//固定
    	    	Map<String, Object> map = new HashMap<String, Object>();
    			map.put("deleteStatus", false);
    			map.put("id", ezsSubstance.getId());
    			List<EzsSubstance> list = this.ezsSubstanceService
    					.query("from EzsSubstance bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
    			EzsSubstance ezsSubstance2 = list.get(0);
    			ezsSubstance2.setFixedTime(ezsSubstance.getFixedTime());
    		    flag = this.ezsSubstanceService.update(ezsSubstance2);
    	    }
		    ModelAndView mv=null;
		    if(flag){
	            mv = new JModelAndView("admin/blue/ezsSubstance_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
	            String url = this.configService.getSysConfig().getAddress();
	            if ((url == null) || (url.equals(""))){
	                url = CommUtil.getURL(request);
	            }
	            String params = "";
	            EzsSubstanceQueryObject qo = new EzsSubstanceQueryObject(currentPage, mv, "id",orderType);
	            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
	            IPageList pList = this.ezsSubstanceService.list(qo);
	            CommUtil.saveIPageList2ModelAndView(url + "/admin/ezsSubstance_list.htm", "",
	                                                params, pList, mv);
	        }
	        return mv;
        
    }
	
}
