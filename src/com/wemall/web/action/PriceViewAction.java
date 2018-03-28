package com.wemall.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/**
 * @author wangxiao
 * 价格行情
 */
@Controller
public class PriceViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;

	@RequestMapping("/price.htm")
	public ModelAndView price(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("price.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
	
	
		return mv;
	}
}
