package com.wemall.web.action;

import java.math.BigDecimal;
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
import com.wemall.foundation.domain.Area;
import com.wemall.foundation.domain.Dict;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.service.IAreaService;
import com.wemall.foundation.service.IDictService;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.AreaViewTools;
import com.wemall.web.tools.NavViewTools;

@Controller
public class GoodsViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private AreaViewTools areaViewTools;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	private IGoodsClassService goodsClassService;
	@Autowired
	private IAreaService areaService; 

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
		if (obj != null) {
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
					if ((wemall_view_type != null) && (!wemall_view_type.equals(""))
							&& (wemall_view_type.equals("wap"))) {
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
		} else {
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

	@RequestMapping("/sreach.htm")
	public ModelAndView sreach(HttpServletRequest request, HttpServletResponse response, String goodclass, String area,
			String color, String form, String sreachtype, String mixPrice, String maxPrice, String keyword) {
		ModelAndView mv = new JModelAndView("goods_sreach.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/goods_sreach.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		mv.addObject("areaViewTools", areaViewTools);
		mv.addObject("navTools", navTools);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteStatus", Boolean.valueOf(false));
		// 物料类型
		List<GoodsClass> gcs = this.goodsClassService.query(
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
		// 查询结果数据
		params.clear();
		params.put("deleteStatus", Boolean.valueOf(false));
		params.put("status", 2);
		StringBuffer hql = new StringBuffer("select obj from Goods obj where obj.deleteStatus =:deleteStatus and obj.status=:status ");
		if (keyword != null && !"".equals(keyword)) {
			hql.append(" and obj.name like :name ");
			params.put("name", "%"+keyword+"%");
			mv.addObject("keyword", keyword);
		}if(goodclass!=null&&!"".equals(goodclass)){
			List<Long> goodsclassid = CommUtil.getByids(goodclass);
			hql.append(" and obj.goodClass.parent.id in (:goodsclassid) ");
			params.put("goodsclassid", goodsclassid);
			mv.addObject("goodsclassid", goodsclassid);
		}if(area!=null&&!"".equals(area)){
			List<Long> regionid = CommUtil.getByids(area);
			hql.append(" and obj.region.parent.parent.id in (:regionid) ");
			params.put("regionid", regionid);
			mv.addObject("regionid", regionid);
			mv.addObject("areas", getAreasByParentAll());
		}if(color!=null&&!"".equals(color)){
			List<Long> colorid = CommUtil.getByids(color);
			hql.append(" and obj.color.id in (:colorid) ");
			params.put("colorid", colorid);
			mv.addObject("colorid", colorid);
		}if(form!=null&&!"".equals(form)){
			List<Long> formid = CommUtil.getByids(form);
			hql.append(" and obj.form.id in(:formid) ");
			params.put("formid", CommUtil.getByids(form));
			mv.addObject("formid", formid);
		}
		if("default".equals(sreachtype)){
			hql.append("order by obj.addTime asc");
			mv.addObject("sreachtype", "default");
		}
		if ("price".equals(sreachtype)) {
			// 价格
			hql.append("and obj.price>=:mixPrice and obj.price<=:maxPrice order by obj.price asc");
			params.put("mixPrice", BigDecimal.valueOf(CommUtil.null2Double(mixPrice)));
			params.put("maxPrice", BigDecimal.valueOf(CommUtil.null2Double(maxPrice)));
			mv.addObject("sreachtype", "price");
			mv.addObject("mixPrice", mixPrice);
			mv.addObject("maxPrice", maxPrice);
		}if ("stock".equals(sreachtype)) {
			// 库存
			hql.append("order by obj.inventory asc");
			mv.addObject("sreachtype", "stock");
		}
		List<Goods> goods = goodsService.query(hql.toString(),params, 0, 24);
		mv.addObject("goods", goods);
		// 优质推荐
		params.clear();
		params.put("deleteStatus", Boolean.valueOf(false));
		params.put("recommend", Boolean.valueOf(true));
		List<Goods> goods_reommend_list = goodsService.query(
				"select obj from Goods obj where obj.deleteStatus =:deleteStatus and obj.recommend=:recommend order by obj.addTime asc",
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

	private List<Area> getAreasByParentAll() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deleteStatus", Boolean.valueOf(false));
		StringBuffer hql = new StringBuffer("select obj from Area obj where deleteStatus =:deleteStatus and obj.parent.id is null");
		return areaService.query(hql.toString(), paramMap, -1, -1);
	}
}
