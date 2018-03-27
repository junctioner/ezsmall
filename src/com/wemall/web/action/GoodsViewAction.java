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

@Controller
public class GoodsViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;

	@RequestMapping("/goods.htm")
	public ModelAndView goods(String id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("default" + "/store_goods.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		Goods obj = this.goodsService.getObjById(Long.valueOf(Long.parseLong(id)));
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/store_goods.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		if (obj.getStatus() == 2) {
			obj.setClick(obj.getClick() + 1);
			if (obj.getUser() != null && obj.getUser().getStore() != null&& obj.getUser().getStore().getStatus() == 2) {
				mv.addObject("obj", obj);
				//评论列表
				
			} else {
				mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
				if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
					mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
				}
				mv.addObject("op_title", "店铺未开通，拒绝访问");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
		} else {
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
			if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
				mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
			}
			mv.addObject("op_title", "该商品未上架，不允许查看");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		return mv;
	}
}
