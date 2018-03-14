package com.wemall.view.web.action;

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
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.view.web.tools.AreaViewTools;

@Controller
public class SelfViewAction {
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private AreaViewTools areaViewTools;
	@Autowired
	private IGoodsClassService goodsClassService;
	@Autowired
	private IGoodsService goodsService;

	@RequestMapping("/zysc.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("zysc.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
		// 设置为PC访问
		mv.addObject("areaViewTools", this.areaViewTools);
		request.getSession().setAttribute("wemall_view_type", "pc");
		Map params = new HashMap();
		params.put("display", Boolean.valueOf(true));
		List gcs = this.goodsClassService.query(
				"select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc",
				params, 0, 15);
		mv.addObject("gcs", gcs);
		params.clear();
		// 优品商品
		params.put("goods_status", Integer.valueOf(0));
		params.put("goods_recommend", Boolean.valueOf(true));
		List<Goods> store_reommend_goods_list = this.goodsService.query(
				"select obj from Goods obj where obj.goods_status=:goods_status and obj.goods_recommend =:goods_recommend order by obj.goods_click desc",
				params, 0, 4);
		mv.addObject("store_reommend_goods_list", store_reommend_goods_list);
		// 8、点击数最多:人气商品
		params.clear();
		params.put("goods_status", Integer.valueOf(0));
		List hot_goods_list = this.goodsService.query(
				"select obj from Goods obj where obj.goods_status=:goods_status order by obj.goods_click desc", params,
				0, 24);
		mv.addObject("hots", hot_goods_list);
		// 5、随机生成推荐商品 猜您喜欢
		List store_guess_goods = new ArrayList();
		Random rand = new Random();
		int recommend_goods_random = rand.nextInt(7);
		int begin = recommend_goods_random * 7;
		if (begin > store_reommend_goods_list.size() - 1) {
			begin = 0;
		}
		int maxsize = begin + 7;
		if (maxsize > store_reommend_goods_list.size()) {
			begin -= maxsize - store_reommend_goods_list.size();
			maxsize--;
		}
		for (int i = 0; i < store_reommend_goods_list.size(); i++) {
			if ((i >= begin) && (i < maxsize)) {
				store_guess_goods.add((Goods) store_reommend_goods_list.get(i));
			}
		}
		mv.addObject("cais", store_guess_goods);
		return mv;
	}
}
