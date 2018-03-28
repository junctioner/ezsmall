package com.wemall.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * 商品详情页面
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
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
		if(obj!=null){
			if (obj.getStatus() == 2) {
				obj.setClick(obj.getClick() + 1);
				if (obj.getUser() != null && obj.getUser().getStore() != null
						&& obj.getUser().getStore().getStatus() == 2) {
					mv.addObject("obj", obj);
					Map<String, Object> paramMap = new HashMap<String, Object>();
					// 优品推荐
					paramMap.put("deleteStatus", false);
					paramMap.put("stroeid", obj.getUser().getStore().getId());
					paramMap.put("recommend", Boolean.valueOf(true));
					List<Goods> goods_reommend_list = goodsService.query(
							"select obj from Goods obj where obj.deleteStatus =:deleteStatus and obj.user.store.id =:stroeid and obj.recommend =:recommend",
							paramMap, 0, 4);
					mv.addObject("goods_reommend_list", goods_reommend_list);
				} else {
					mv = new JModelAndView("error.html", this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request, response);
					if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
						mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
								this.userConfigService.getUserConfig(), 1, request, response);
					}
					mv.addObject("op_title", "店铺未开通，拒绝访问");
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
				}
			} else {
				mv = new JModelAndView("error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
				if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
					mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
							this.userConfigService.getUserConfig(), 1, request, response);
				}
				mv.addObject("op_title", "该商品未上架，不允许查看");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
		}else{
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
				mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
			}
			mv.addObject("op_title", "该商品在商城中尚未找到！");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}
		return mv;
	}

}
