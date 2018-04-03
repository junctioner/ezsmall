package com.wemall.web.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.domain.GoodsAuditProcess;
import com.wemall.foundation.service.GoodsAuditProcessService;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.ImageViewTools;

@Controller
public class Login {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private ImageViewTools imageViewTools;
<<<<<<< HEAD
	@Autowired
	private GoodsAuditProcessService goodsAuditProcessService;
	@Autowired
	private IGoodsService iGoodsService;
=======
>>>>>>> refs/remotes/origin/master

	@RequestMapping({ "/hello" })
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, String url) {
		ModelAndView mv = new JModelAndView("hello.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 2, request, response);
		mv.addObject("msg", 123);
		return mv;
	}

	@RequestMapping({ "/admin/goods_brand_list.htm" })
	public ModelAndView admin_goods_brand_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_brand_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}

	@RequestMapping({ "/admin/goods_list.htm" })
	public ModelAndView admin_goods_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("liulan", "1000");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "8");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "10");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping({ "/admin/goods_type_list.htm" })
	public ModelAndView admin_goods_type_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_type_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}

	@RequestMapping({ "/admin/goods_spec_list.htm" })
	public ModelAndView admin_goods_spec_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_spec_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}

	@RequestMapping({ "/admin/goods_floor_list.htm" })
	public ModelAndView admin_goods_floor_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_floor_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}

	@RequestMapping({ "/admin/goods_supp.htm" })
	public ModelAndView admin_goods_supplier_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_supp_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
<<<<<<< HEAD
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 540);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		mv.addObject("list", listByGoodsAuditProcess);
		return mv;
	}

	@RequestMapping({ "/admin/goods_outline.htm" })
	public ModelAndView admin_goods_outline(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_outline.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}

		return mv;
	}

	@RequestMapping({ "/admin/goods_self.htm" })
	public ModelAndView admin_goods_self_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

	}

	@RequestMapping("/admin/updateSupplier.htm")
	public ModelAndView updateSupplier(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateSupplier.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	
	@RequestMapping("/admin/updateTerrace.htm")
	public ModelAndView updateTerrace(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateTerrace.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	
	@RequestMapping("/admin/goods_self_audi.htm")
	public ModelAndView admin_goods_self_audi(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_audi.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

		
		
		
		
		
	}
	
	@RequestMapping("/admin/goods_self_pric.htm")
	public ModelAndView admin_goods_self_pric(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_pric.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("liulan", "1000");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "8");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "10");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/admin/updateaudi.htm")
	public ModelAndView admin_updateaudi(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateaudi.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	@RequestMapping("/admin/priclook.htm")
	public ModelAndView admin_priclook(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/priclook.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

		
	}
	
	@RequestMapping("/admin/Review_the_view.htm")
	public ModelAndView admin_Review_the_view(HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/Review_the_view.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 540);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		mv.addObject("list", listByGoodsAuditProcess);
		
		return mv;

	}
	@RequestMapping("/admin/supp_inspection.htm")
	public ModelAndView admin_Review_the_view1(HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_inspection.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 541);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		mv.addObject("list", listByGoodsAuditProcess);
		
		return mv;

	}
	@RequestMapping("/admin/supp_inspection.htm")
	public ModelAndView admin_Review_the_view2(HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_inspection.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 541);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		mv.addObject("list", listByGoodsAuditProcess);
		
		return mv;

	}
	
	@RequestMapping("/admin/review_look.htm")
	public ModelAndView review_loo(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/review_look.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
=======
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("liulan", "1000");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "8");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "10");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping({ "/admin/goods_outline.htm" })
	public ModelAndView admin_goods_outline(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_outline.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}

		return mv;
	}

	@RequestMapping({ "/admin/goods_self.htm" })
	public ModelAndView admin_goods_self_list(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_list.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

	}

	@RequestMapping("/admin/updateSupplier.htm")
	public ModelAndView updateSupplier(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateSupplier.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	
	@RequestMapping("/admin/updateTerrace.htm")
	public ModelAndView updateTerrace(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateTerrace.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	
	@RequestMapping("/admin/goods_self_audi.htm")
	public ModelAndView admin_goods_self_audi(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_audi.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

		
		
		
		
		
	}
	
	@RequestMapping("/admin/goods_self_pric.htm")
	public ModelAndView admin_goods_self_pric(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/goods_self_pric.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	@RequestMapping("/admin/updateaudi.htm")
	public ModelAndView admin_updateaudi(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/updateaudi.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	@RequestMapping("/admin/priclook.htm")
	public ModelAndView admin_priclook(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/priclook.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");

		Map<String, String> map2 = new HashMap<String, String>();

		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");

		Map<String, String> map3 = new HashMap<String, String>();

		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");

		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;

		
	}
>>>>>>> refs/remotes/origin/master

}
	@RequestMapping("/admin/review_flat.htm")
	public ModelAndView review_self(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/review_flat.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
		
	}
	
	@RequestMapping("/admin/supp_inspection1.htm")
	public ModelAndView supp_inspection(Long id, String style,
			String content,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_inspection.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		System.out.println(id);
		Goods objById = iGoodsService.getObjById(id);
		if("2".equals(style)) {
			objById.setStatus(544);
			boolean update = iGoodsService.update(objById);
			if(update) {
				
				
			}
			
		}else {
			
			objById.setStatus(541);
			boolean update = iGoodsService.update(objById);
			if(update) {
				
				
			}
			
			
			
			
		}
		
		return mv;
	}
	
	

	@RequestMapping("/admin/supp_updateinspection.htm")
	public ModelAndView supp_updateinspection(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_updateinspection.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
		
	}
	
	@RequestMapping("/admin/supp_updateTerrace.htm")
	public ModelAndView supp_updateTerrace(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_updateTerrace.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
		
	}
	
	@RequestMapping("/admin/supp_pricing.htm")
	public ModelAndView admin_supp_pricing(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_pricing.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("fenlei", "ppt塑料片");
		map.put("shuiliaopian", "塑料片");
		map.put("gongyigshang", "海天酱油供应商");
		map.put("gongyingjia", "5000");
		map.put("xiaoshoujia", "6000");
		map.put("kucun", "100");
		map.put("zhuangtai", "100");
		map.put("riqi", "2018-3-31");
		map.put("paixu", "5");
		map.put("liulan", "1000");
		map.put("liuyangpin", "500");
		
		Map<String, String> map2 = new HashMap<String, String>();
		
		map2.put("fenlei", "ppt塑料片");
		map2.put("shuiliaopian", "塑料片");
		map2.put("gongyigshang", "海天酱油供应商");
		map2.put("gongyingjia", "5000");
		map2.put("xiaoshoujia", "6000");
		map2.put("kucun", "100");
		map2.put("zhuangtai", "100");
		map2.put("riqi", "2018-3-31");
		map2.put("paixu", "5");
		map2.put("liulan", "1000");
		map2.put("liuyangpin", "500");
		
		Map<String, String> map3 = new HashMap<String, String>();
		
		map3.put("fenlei", "ppt塑料片");
		map3.put("shuiliaopian", "塑料片");
		map3.put("gongyigshang", "海天酱油供应商");
		map3.put("gongyingjia", "5000");
		map3.put("xiaoshoujia", "6000");
		map3.put("kucun", "100");
		map3.put("zhuangtai", "100");
		map3.put("riqi", "2018-3-31");
		map3.put("paixu", "5");
		map3.put("liulan", "1000");
		map3.put("liuyangpin", "500");
		
		list.add(map);
		list.add(map2);
		list.add(map3);
		mv.addObject("list", list);
		return mv;
		
	}
	
	@RequestMapping("/admin/Unapprove.htm")
	public ModelAndView Unapprove(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/Unapprove.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 544);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		mv.addObject("list", listByGoodsAuditProcess);
		return mv;
		
	}
	

	@RequestMapping("/admin/supp_pricing_look.htm")
	public ModelAndView aupp_pricing_look(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_pricing_look.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
	
	@RequestMapping("/admin/supp_flat_look.htm")
	public ModelAndView supp_flat_look(String name, String userName,
			String publicTime, String ec, String userId, String status,
			String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response)
					throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("admin/blue/supp_flat_look.html",
				this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		return mv;
	}
	
}