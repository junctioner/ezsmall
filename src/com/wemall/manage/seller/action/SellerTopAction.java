package com.wemall.manage.seller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class SellerTopAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	
	
	
	@RequestMapping("/seller/seller_top.htm")
	public ModelAndView buyer_top(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("/default/seller/seller_top.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}
	@RequestMapping("/seller/seller_info_left.htm")
	public ModelAndView buyer_info_left(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("/default/seller/seller_info_left.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}
	@RequestMapping("/seller/seller_link.htm")
	public ModelAndView buyer_link(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("/default/seller/seller_link.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}
}
