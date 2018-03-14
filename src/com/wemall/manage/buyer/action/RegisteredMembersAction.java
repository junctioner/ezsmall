package com.wemall.manage.buyer.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.wemall.core.tools.Md5Encrypt;
import com.wemall.core.tools.WebForm;
import com.wemall.foundation.domain.Album;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.CrmContacts;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.domain.IntegralLog;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.SpecialSubject;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.domain.query.CouponQueryObject;
import com.wemall.foundation.service.IAlbumService;
import com.wemall.foundation.service.IAreaService;
import com.wemall.foundation.service.ICrmConsumerService;
import com.wemall.foundation.service.ICrmContactsService;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IEzsSubstanceService;
import com.wemall.foundation.service.IIntegralLogService;
import com.wemall.foundation.service.IMainBusinessService;
import com.wemall.foundation.service.IRoleService;
import com.wemall.foundation.service.ISpecialSubjectService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.foundation.service.IUserService;
import com.wemall.uc.api.UCClient;
import com.wemall.uc.api.UCTools;

@Controller
public class RegisteredMembersAction {


	
	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    @Autowired
    private ICrmConsumerService iCrmConsumerService;
    
    @Autowired
    private ICrmContactsService iCrmContactsService;
    
    @Autowired
    private IAreaService areaService;
    
    @Autowired
    private IRoleService roleService;
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IIntegralLogService integralLogService;
    
    @Autowired
    private IAlbumService albumService;
    
    @Autowired
    private UCTools ucTools;
    
    
    @Autowired
    private IMainBusinessService mainBusinessService;
    
    
    /**
     * 会员注册页面
     */
    @SecurityMapping(display = false, rsequence = 0, title = "huiyuan", value = "/admin/ezsSubstance_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
    @RequestMapping({ "/buyer/register.htm" })
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
         ModelAndView mv = new JModelAndView("registeredMembers.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
         List areas = this.areaService.query("select obj from Area obj where obj.parent.id is null", null,-1, -1);
         mv.addObject("areas", areas);
         List mainbusiness = this.mainBusinessService.query("from MainBusiness", null, -1, -1);
         mv.addObject("mainbusiness", mainbusiness);
         return mv;
    }  
    
     /**
      * 验证码的验证
      */
    @RequestMapping({ "/buyer/verify.htm" })
    public void verify(PrintWriter out,String verification,String tel,HttpServletRequest request){
    	String result = "0";
		try {
			 // 手机号就是用户名，用户名不能重复
	        Map params = new HashMap();
	        params.put("userName", tel);
	        List users = this.userService.query("select obj from User obj where obj.userName=:userName", params, -1, -1);
	        if ((users != null) && (users.size() > 0)){
	        	result = "1";
	        }
	        
	        if(result.equals("0")){
	        	// 判断验证码
				String verify_code = request.getSession().getAttribute("verify_code").toString();
				if (!verification.equalsIgnoreCase(verify_code)) {
					result = "2";
				}
	        }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.print(result);
			out.flush();
			out.close();
		}	
    } 
    
    /**
     * 注册会员添加到数据库
     */
    @RequestMapping({ "/buyer/addMember.htm" })
    public void addMember(HttpServletRequest request,HttpServletResponse response,String ent_name,String platform_type,String oper_address,String per_subject,String main_business,String userName,String sex,String phoneNum,String emailNum,String tel,String pwd) {
    	
    	try {
    		 //企业
             CrmConsumer consumer = new CrmConsumer();
             consumer.setEnt_name(ent_name);
             consumer.setPlatform_type(platform_type);
             consumer.setOper_address(oper_address);
             consumer.setPer_subject(per_subject);
             consumer.setMain_business(main_business);
             this.iCrmConsumerService.save(consumer);
             //员工
             CrmContacts crmContacts = new CrmContacts();
             crmContacts.setTruename(userName);
             crmContacts.setSex(sex);
             crmContacts.setMobile(tel);
             crmContacts.setTelephone(phoneNum);
             crmContacts.setEmail(emailNum);
             crmContacts.setAddress(oper_address);
             crmContacts.setConsumer(consumer);
             this.iCrmContactsService.save(crmContacts);
             
             Map params = new HashMap();
             User user = new User();
             //手机号作为登陆用户名
             user.setUserName(tel);
             user.setAddTime(new Date());
             user.setEmail(emailNum);
             user.setPassword(Md5Encrypt.md5(pwd).toLowerCase());
            
             if(platform_type.equals("买家")){
            	 user.setUserRole("BUYER");
                 params.put("type", "BUYER");
             }else{
            	 user.setUserRole("BUYER_SELLER");
                 params.put("type", "SELLER");
             }
             List roles = this.roleService.query("select obj from Role obj where obj.type=:type", params, -1, -1);
             user.getRoles().addAll(roles);
             // 如果系统开启积分功能，则给会员新增积分
             if (this.configService.getSysConfig().isIntegral()){
                 user.setIntegral(this.configService.getSysConfig().getMemberRegister());
                 this.userService.save(user);
                 IntegralLog log = new IntegralLog();
                 log.setAddTime(new Date());
                 log.setContent("用户注册增加" + this.configService.getSysConfig().getMemberRegister() + "分");
                 log.setIntegral(this.configService.getSysConfig().getMemberRegister());
                 log.setIntegral_user(user);
                 log.setType("reg");
                 this.integralLogService.save(log);
             }else{
                 this.userService.save(user);
             }
             
             // 设置相册
             Album album = new Album();
             album.setAddTime(new Date());
             album.setAlbum_default(true);
             album.setAlbum_name("默认相册");
             album.setAlbum_sequence(-10000);
             album.setUser(user);
             this.albumService.save(album);
             request.getSession(false).removeAttribute("verify_code");
             //UC会员同步
             
             if (this.configService.getSysConfig().isUc_bbs()){
                 UCClient client = new UCClient();
                 String ret = client.uc_user_register(tel, user.getPassword(), emailNum);
                 int uid = Integer.parseInt(ret);
                 if (uid <= 0){
                     if (uid == -1)
                         System.out.print("用户名不合法");
                    else if (uid == -2)
                         System.out.print("包含要允许注册的词语");
                    else if (uid == -3)
                         System.out.print("用户名已经存在");
                    else if (uid == -4)
                         System.out.print("Email 格式有误");
                    else if (uid == -5)
                         System.out.print("Email 不允许注册");
                    else if (uid == -6)
                         System.out.print("该 Email 已经被注册");
                     else
                         System.out.print("未定义");
                 }else{
                	 this.ucTools.active_user(tel, user.getPassword(), emailNum);
                 }
             }
             //重定向
			 response.sendRedirect(request.getContextPath()+"/wemall_login.htm?username=" +CommUtil.encode(tel) + "&password=" + pwd + "&encode=true");			 
			 
		} catch (IOException e) {
			 e.printStackTrace();
		}         
    }  
	
}
