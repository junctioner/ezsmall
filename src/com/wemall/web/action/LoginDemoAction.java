package com.wemall.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.ImageViewTools;


@Controller
public class LoginDemoAction {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	
	
	///wemall2/WebRoot/WEB-INF/templates/zh_cn/shop/default/goods_list.html
	@RequestMapping("/admin_add.htm")
	public ModelAndView loginDemo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter" + "/address.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		
		
		
		return mv;
		
	}
	
	
	

}
