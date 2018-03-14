package com.wemall.manage.admin.action;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.domain.SpecialSubject;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.service.ISpecialSubjectService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class SpecialSubjectAction {
	@Autowired
	private ISpecialSubjectService specialSubjectService;
	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
	
	@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/ezsColumn_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/specialSubject_list.htm" })
    public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/specialSubject_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        /*Map<String,Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        if(currentPage!=null&&!"".equals(currentPage)){
        	List<SpecialSubject> list = specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus", map, 0, 10);
        	mv.addObject("specialSubjectList", list);

        }else{
        	List<SpecialSubject> list = specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus", map, Integer.parseInt(currentPage), 10);
        	mv.addObject("specialSubjectList", list);
        }*/
        
        
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))){
            url = CommUtil.getURL(request);
        }
        String params = "";
        CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "orderid",
        		orderType);
        qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
        /*if (!CommUtil.null2String(coupon_begin_time).equals("")){
            qo.addQuery("obj.coupon_begin_time",
                        new SysMap("coupon_begin_time",
                                   CommUtil.formatDate(coupon_begin_time)), ">=");
        }
        if (!CommUtil.null2String(coupon_end_time).equals("")){
            qo.addQuery("obj.coupon_end_time",
                        new SysMap("coupon_end_time",
                                   CommUtil.formatDate(coupon_end_time)), "<=");
        }*/
        IPageList pList = this.specialSubjectService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/admin/specialSubject_list.htm", "",
                                            params, pList, mv);
        return mv;
    }
    
    //@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/loadAddEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/loadAddSpecialSubject.htm" })
    public ModelAndView loadAddEzsColumn(String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/addSpecialSubject.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }
    
    //@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/addEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/admin/addSpecialSubject.htm" })
    public ModelAndView addSpecialSubject(String currentPage, String orderBy, String orderType,SpecialSubject specialSubject, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
    	 //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        List pcTitlePhoto=new ArrayList();
        List phoneTitlePhoto=new ArrayList();
        List pcContentPhoto=new ArrayList();
        List phoneContentPhoto=new ArrayList();
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
		                  .getRealPath("/") +
		                  uploadFilePath + File.separator + "specialSubject";
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
      		        	pcTitlePhoto.add(fileName);
	              	}else if("b".equals(file.getName()+"")){
	              		phoneTitlePhoto.add(fileName);
	              	}else if("c".equals(file.getName()+"")){
	              		pcContentPhoto.add(fileName);
	              	}else if("d".equals(file.getName()+"")){
	              		phoneContentPhoto.add(fileName);
	              	}
      		        if(fileName!=null&&!"".equals(fileName)){
      		        	upload(saveFilePathName,fileName,file);
      		        }
                    //file.transferTo(new File(saveFilePathName+File.separator+fileName));
                }
                 
            }
           
        }
        if(pcTitlePhoto!=null&&pcTitlePhoto.size()>0){
        	specialSubject.setPcTitlePhoto(StringUtils.join(pcTitlePhoto.toArray(),","));
        }
        if(phoneTitlePhoto!=null&&phoneTitlePhoto.size()>0){
        	specialSubject.setPhoneTitlePhoto(StringUtils.join(phoneTitlePhoto.toArray(),","));
        }
        if(pcContentPhoto!=null&&pcContentPhoto.size()>0){
        	specialSubject.setPcContentPhoto(StringUtils.join(pcContentPhoto.toArray(),","));
        }
        if(phoneContentPhoto!=null&&phoneContentPhoto.size()>0){
        	specialSubject.setPhoneContentPhoto(StringUtils.join(phoneContentPhoto.toArray(),","));
        }
        specialSubject.setAddTime(new Date());
        boolean flag=specialSubjectService.save(specialSubject);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/specialSubject_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "orderid",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            /*if (!CommUtil.null2String(coupon_begin_time).equals("")){
                qo.addQuery("obj.coupon_begin_time",
                            new SysMap("coupon_begin_time",
                                       CommUtil.formatDate(coupon_begin_time)), ">=");
            }
            if (!CommUtil.null2String(coupon_end_time).equals("")){
                qo.addQuery("obj.coupon_end_time",
                            new SysMap("coupon_end_time",
                                       CommUtil.formatDate(coupon_end_time)), "<=");
            }*/
            IPageList pList = this.specialSubjectService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/specialSubject_list.htm", "",
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
    
    @RequestMapping({ "/admin/loadEditSpecialSubject.htm" })
    public ModelAndView loadEditSpecialSubject(String currentPage, String orderBy, String orderType,SpecialSubject specialSubject, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("admin/blue/editSpecialSubject.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map map=new HashMap();
        map.put("deleteStatus", false);
        map.put("id", specialSubject.getId());
        List<SpecialSubject> list=this.specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        mv.addObject("specialSubject", list.get(0));
        return mv;
    }
    
    @RequestMapping({ "/admin/editSpecialSubject.htm" })
    public ModelAndView editSpecialSubject(String currentPage, String orderBy, String orderType,SpecialSubject specialSubject, HttpServletRequest request, HttpServletResponse response) throws IOException{
        //检查form中是否有enctype="multipart/form-data"
    	CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        List pcTitlePhoto=new ArrayList();
        List phoneTitlePhoto=new ArrayList();
        List pcContentPhoto=new ArrayList();
        List phoneContentPhoto=new ArrayList();
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
		                  .getRealPath("/") +
		                  uploadFilePath + File.separator + "specialSubject";
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
      		        	pcTitlePhoto.add(fileName);
	              	}else if("b".equals(file.getName()+"")){
	              		phoneTitlePhoto.add(fileName);
	              	}else if("c".equals(file.getName()+"")){
	              		pcContentPhoto.add(fileName);
	              	}else if("d".equals(file.getName()+"")){
	              		phoneContentPhoto.add(fileName);
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
        map.put("id", specialSubject.getId());
        List<SpecialSubject> list=this.specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        SpecialSubject specialSubject2 = list.get(0);
        if(pcTitlePhoto!=null&&pcTitlePhoto.size()>0){
        	specialSubject.setPcTitlePhoto(StringUtils.join(pcTitlePhoto.toArray(),","));
        	String string=specialSubject2.getPcTitlePhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
        if(phoneTitlePhoto!=null&&phoneTitlePhoto.size()>0){
        	specialSubject.setPhoneTitlePhoto(StringUtils.join(phoneTitlePhoto.toArray(),","));
        	String string=specialSubject2.getPhoneTitlePhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
        if(pcContentPhoto!=null&&pcContentPhoto.size()>0){
        	specialSubject.setPcContentPhoto(StringUtils.join(pcContentPhoto.toArray(),","));
        	String string=specialSubject2.getPcContentPhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
        if(phoneContentPhoto!=null&&phoneContentPhoto.size()>0){
        	specialSubject.setPhoneContentPhoto(StringUtils.join(phoneContentPhoto.toArray(),","));
        	String string=specialSubject2.getPhoneContentPhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
        specialSubject2.setAbbreviation(!"".equals(specialSubject.getAbbreviation())?specialSubject.getAbbreviation():"");
        specialSubject2.setAddTime(specialSubject.getAddTime());
        specialSubject2.setColTemplate(!"".equals(specialSubject.getColTemplate())?specialSubject.getColTemplate():"");
        specialSubject2.setDeleteStatus(specialSubject.isDeleteStatus());
        specialSubject2.setDescription(!"".equals(specialSubject.getDescription())?specialSubject.getDescription():"");
        specialSubject2.setId(specialSubject.getId());
        specialSubject2.setKeyWord(!"".equals(specialSubject.getKeyWord())?specialSubject.getKeyWord():"");
        specialSubject2.setName(!"".equals(specialSubject.getName())?specialSubject.getName():"");
        specialSubject2.setOrderid(!"".equals(specialSubject.getOrderid())?specialSubject.getOrderid():1);
        specialSubject2.setPcContentPhoto(!"".equals(specialSubject.getPcContentPhoto())?specialSubject.getPcContentPhoto():(!"".equals(specialSubject2.getPcContentPhoto())?specialSubject2.getPcContentPhoto():""));
        specialSubject2.setPcTitlePhoto(!"".equals(specialSubject.getPcTitlePhoto())?specialSubject.getPcTitlePhoto():(!"".equals(specialSubject2.getPcTitlePhoto())?specialSubject2.getPcTitlePhoto():""));
        specialSubject2.setPhoneContentPhoto(!"".equals(specialSubject.getPhoneContentPhoto())?specialSubject.getPhoneContentPhoto():(!"".equals(specialSubject2.getPhoneContentPhoto())?specialSubject2.getPhoneContentPhoto():""));
        specialSubject2.setPhoneTitlePhoto(!"".equals(specialSubject.getPhoneTitlePhoto())?specialSubject.getPhoneTitlePhoto():(!"".equals(specialSubject2.getPhoneTitlePhoto())?specialSubject2.getPhoneTitlePhoto():""));
        specialSubject2.setPhoTemplate(!"".equals(specialSubject.getPhoTemplate())?specialSubject.getPhoTemplate():"");
        specialSubject2.setRecommend(specialSubject.isRecommend());
        boolean flag=specialSubjectService.update(specialSubject2);
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/specialSubject_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "orderid",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            /*if (!CommUtil.null2String(coupon_begin_time).equals("")){
                qo.addQuery("obj.coupon_begin_time",
                            new SysMap("coupon_begin_time",
                                       CommUtil.formatDate(coupon_begin_time)), ">=");
            }
            if (!CommUtil.null2String(coupon_end_time).equals("")){
                qo.addQuery("obj.coupon_end_time",
                            new SysMap("coupon_end_time",
                                       CommUtil.formatDate(coupon_end_time)), "<=");
            }*/
            IPageList pList = this.specialSubjectService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/specialSubject_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
    @RequestMapping({ "/admin/deleteSpecialSubject.htm" })
    public ModelAndView deleteSpecialSubject(String currentPage, String orderBy, String orderType,SpecialSubject specialSubject, HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String,Object>();
        map.put("deleteStatus", false);
        map.put("id", specialSubject.getId());
        List<SpecialSubject> list=this.specialSubjectService.query("from SpecialSubject bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map, -1, -1);
        SpecialSubject specialSubject2 = list.get(0);
        String uploadFilePath = this.configService.getSysConfig()
                .getUploadFilePath();
		String saveFilePathName = request.getSession().getServletContext()
                .getRealPath("/") +
                uploadFilePath + File.separator + "ezsSubstance";
    	if(specialSubject2!=null&&!"".equals(specialSubject2.getPcContentPhoto())){
        	String string=specialSubject2.getPcContentPhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(specialSubject2!=null&&!"".equals(specialSubject2.getPcTitlePhoto())){
        	String string=specialSubject2.getPcTitlePhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(specialSubject2!=null&&!"".equals(specialSubject2.getPhoneContentPhoto())){
        	String string=specialSubject2.getPhoneContentPhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	if(specialSubject2!=null&&!"".equals(specialSubject2.getPhoneTitlePhoto())){
        	String string=specialSubject2.getPhoneTitlePhoto();
        	String [] strings=string.split(",");
        	for (String string2 : strings) {
				File file = new File(saveFilePathName+File.separator+string2);
				if(file.exists()){
					file.delete();
				}
			}
        }
    	boolean flag=specialSubjectService.delete(specialSubject.getId());
        ModelAndView mv=null;
        if(flag){
            mv = new JModelAndView("admin/blue/specialSubject_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))){
                url = CommUtil.getURL(request);
            }
            String params = "";
            CouponQueryObject qo = new CouponQueryObject(currentPage, mv, "orderid",
                    orderType);
            qo.addQuery("obj.deleteStatus",new SysMap("deleteStatus",false),"=");
            /*if (!CommUtil.null2String(coupon_begin_time).equals("")){
                qo.addQuery("obj.coupon_begin_time",
                            new SysMap("coupon_begin_time",
                                       CommUtil.formatDate(coupon_begin_time)), ">=");
            }
            if (!CommUtil.null2String(coupon_end_time).equals("")){
                qo.addQuery("obj.coupon_end_time",
                            new SysMap("coupon_end_time",
                                       CommUtil.formatDate(coupon_end_time)), "<=");
            }*/
            IPageList pList = this.specialSubjectService.list(qo);
            CommUtil.saveIPageList2ModelAndView(url + "/admin/specialSubject_list.htm", "",
                                                params, pList, mv);
        }
        return mv;
    }
    
}
