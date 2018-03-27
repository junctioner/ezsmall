package com.wemall.manage.seller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.security.support.SecurityUserHolder;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class GoodsSellerAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;

	/**
	 * 商品立即购买
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/good_buy.htm")
	public ModelAndView new_buy(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("default" + "/good_buy.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/good_buy.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		User user = SecurityUserHolder.getCurrentUser();
		Goods obj = goodsService.getObjById(CommUtil.null2Long(id));
		if (user != null) {
			if (user.getId() == obj.getUser().getId()) {
				mv = new JModelAndView("error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
				mv.addObject("op_title", "不能购买自家商品！");
				mv.addObject("url", CommUtil.getURL(request) + "/goods_" + id + ".htm");
			} else {
				mv.addObject("obj", obj);
			}
		} else {
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			mv.addObject("op_title", "尚未登陆系统，请您登陆后在操作！！");
			mv.addObject("url", CommUtil.getURL(request) + "/user/login.htm");
		}
		return mv;
	}

	/**
	 * 样品购买
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/sample_buy.htm")
	public ModelAndView sample_buy(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("default" + "/sample_buy.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/sample_buy.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		User user = SecurityUserHolder.getCurrentUser();
		Goods obj = goodsService.getObjById(CommUtil.null2Long(id));
		if (user != null) {
			if (user.getId() == obj.getUser().getId()) {
				mv = new JModelAndView("error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
				mv.addObject("op_title", "不能购买自家样品样品商品！");
				mv.addObject("url", CommUtil.getURL(request) + "/goods_" + id + ".htm");
			} else {
				mv.addObject("obj", obj);
			}
		} else {
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			mv.addObject("op_title", "尚未登陆系统，请您登陆后在操作！！");
			mv.addObject("url", CommUtil.getURL(request) + "/user/login.htm");
		}
		return mv;
	}
}
