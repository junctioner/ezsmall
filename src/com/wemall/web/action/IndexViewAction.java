package com.wemall.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Dict;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.service.IDictService;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.AreaViewTools;
import com.wemall.web.tools.NavViewTools;

/**
 * 商城首页控制器
 * 
 * @author 刘恒福
 *
 */
@Controller
public class IndexViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsClassService goodsClassService;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	private AreaViewTools areaViewTools;
	@Autowired
	private IDictService dictService;
	@Autowired
	private IGoodsService goodsService;

	@RequestMapping({ "/close.htm" })
	public ModelAndView wapclose(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("close.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/close.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}

		return mv;
	}

	@RequestMapping("/index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("index.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		mv.addObject("areaViewTools", areaViewTools);
		mv.addObject("navTools", navTools);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteStatus", Boolean.valueOf(false));
		// 物料类型
		List gcs = this.goodsClassService.query(
				"select obj from GoodsClass obj where obj.parent.id is null and obj.deleteStatus=:deleteStatus order by obj.sequence asc",
				params, -1, -1);
		mv.addObject("gcs", gcs);
		// 颜色
		params.clear();
		params.put("color", "EZS_COLOR");
		params.put("deleteStatus", Boolean.valueOf(false));
		List<Dict> colors = dictService.query(
				"select obj from Dict obj where obj.parent.code =:color and deleteStatus =:deleteStatus order by obj.sequence asc",
				params, -1, -1);
		mv.addObject("colors", colors);
		// 状态
		params.clear();
		params.put("form", "EZS_FORM");
		params.put("deleteStatus", Boolean.valueOf(false));
		List<Dict> forms = dictService.query(
				"select obj from Dict obj where obj.parent.code =:form and deleteStatus =:deleteStatus order by obj.sequence asc",
				params, -1, -1);
		mv.addObject("forms", forms);
		// 默认商品
		params.clear();
		params.put("deleteStatus", Boolean.valueOf(false));
		params.put("status", 2);
		List<Goods> goods = goodsService.query(
				"select obj from Goods obj where obj.deleteStatus =:deleteStatus and obj.status=:status order by obj.addTime asc", params, 0,
				24);
		mv.addObject("goods", goods);
		// 优质推荐
		params.clear();
		params.put("deleteStatus", Boolean.valueOf(false));
		params.put("recommend", Boolean.valueOf(true));
		params.put("status", 2);
		List<Goods> goods_reommend_list = goodsService.query(
				"select obj from Goods obj where obj.deleteStatus =:deleteStatus and obj.recommend=:recommend and obj.status=:status order by obj.addTime asc",
				params, 0, 4);
		mv.addObject("goods_reommend_list", goods_reommend_list);
		// 猜你喜欢商品
		List<Goods> store_guess_goods = new ArrayList<Goods>();
		Random rand = new Random();
		int recommend_goods_random = rand.nextInt(7);
		int begin = recommend_goods_random * 7;
		if (begin > store_guess_goods.size() - 1) {
			begin = 0;
		}
		int maxsize = begin + 7;
		if (maxsize > store_guess_goods.size()) {
			begin -= maxsize - store_guess_goods.size();
			maxsize--;
		}
		for (int i = 0; i < store_guess_goods.size(); i++) {
			if ((i >= begin) && (i < maxsize)) {
				store_guess_goods.add((Goods) store_guess_goods.get(i));
			}
		}
		mv.addObject("guess_goods", store_guess_goods);
		return mv;
	}

	@RequestMapping("/top.htm")
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("top.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		mv.addObject("total_price", 0.0);
		mv.addObject("cart", null);
		return mv;
	}

	/**
	 * 横着的导航栏
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({ "/nav.htm" })
	public ModelAndView nav(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("nav.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		mv.addObject("navTools", this.navTools);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteStatus", Boolean.valueOf(false));
		List gcs = this.goodsClassService.query(
				"select obj from GoodsClass obj where obj.parent.id is null and obj.deleteStatus=:deleteStatus order by obj.sequence asc",
				params, -1, -1);
		mv.addObject("gcs", gcs);
		return mv;
	}

	@RequestMapping({ "/head.htm" })
	public ModelAndView head(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("head.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String type = CommUtil.null2String(request.getAttribute("type"));
		mv.addObject("type", type.equals("") ? "goods" : type);
		return mv;
	}

	@RequestMapping({ "/footer.htm" })
	public ModelAndView footer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("footer.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/footer.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		mv.addObject("navTools", this.navTools);

		return mv;
	}
}
