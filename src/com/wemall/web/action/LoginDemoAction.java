package com.wemall.web.action;

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
	
	
	@RequestMapping("/vm")
	public String loginDemo() {
//		ModelAndView mv = new JModelAndView("login.html", this.configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
		
		System.out.println(123);
		
		return "news";
		
	}
	
	
	

}
