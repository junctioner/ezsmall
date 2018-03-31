package com.wemall.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
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
import com.wemall.foundation.domain.GoodsCart;
import com.wemall.foundation.domain.StoreCart;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.service.IGoodsCartService;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.IStoreCartService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.foundation.service.IUserService;

@Controller
public class CartViewAction {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IStoreCartService storeCartService;
	@Autowired
	private IGoodsCartService goodsCartService;

	@RequestMapping("/add_goodscart.htm")
	public ModelAndView add_goodscart(HttpServletRequest request, HttpServletResponse response, String id,String count) {
		ModelAndView mv = new JModelAndView("default"+"/add_goods_cart.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/add_goods_cart.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
		}
		String buy_type = CommUtil.match_goods;
		List<StoreCart> cart = new ArrayList<StoreCart>();// 购物车对象
		List<StoreCart> user_cart = new ArrayList<StoreCart>();// 买家登录状态下的购物车
		List<StoreCart> cookie_cart = new ArrayList<StoreCart>();// 买家未登录状态下的购物车
		String cart_session_id = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cart_session_id")) {
					cart_session_id = CommUtil.null2String(cookie.getValue());
				}
			}
		}
		if (cart_session_id.equals("")) {
			cart_session_id = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("cart_session_id", cart_session_id);
			cookie.setDomain(CommUtil.generic_domain(request));
			response.addCookie(cookie);
		}
		User user = null;
		if (SecurityUserHolder.getCurrentUser() != null) {
			user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		
		if (user != null) {
			// 买家已登陆
			if (!cart_session_id.equals("")) {
				if (user.getStore() != null) {
					params.clear();
					params.put("cart_session_id", cart_session_id);
					params.put("user_id", user.getId());
					params.put("sc_status", Integer.valueOf(0));
					params.put("store_id", user.getStore().getId());
					List<StoreCart> store_cookie_cart = this.storeCartService.query(
							"select obj from StoreCart obj where (obj.cart_session_id=:cart_session_id or obj.user.id=:user_id) and obj.sc_status=:sc_status and obj.store.id=:store_id",
							params, -1, -1);
					//清除自己商城的商品
					this.storeCartService.deleteStoreCart(store_cookie_cart);
				}
				params.clear();
				params.put("cart_session_id", cart_session_id);
				params.put("sc_status", Integer.valueOf(0));
				cookie_cart = this.storeCartService.query(
						"select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status",
						params, -1, -1);

				params.clear();
				params.put("user_id", user.getId());
				params.put("sc_status", Integer.valueOf(0));
				user_cart = this.storeCartService.query(
						"select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params,
						-1, -1);
			} else {
				params.clear();
				params.put("user_id", user.getId());
				params.put("sc_status", Integer.valueOf(0));
				user_cart = this.storeCartService.query(
						"select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params,
						-1, -1);
			}
		} else if (!cart_session_id.equals("")) {// 买家尚未登陆
			params.clear();
			params.put("cart_session_id", cart_session_id);
			params.put("sc_status", Integer.valueOf(0));
			cookie_cart = this.storeCartService.query(
					"select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status",
					params, -1, -1);
		}
		// 遍历买家登录状态下的购物车，并将购物车内容添加到cart对象里
		for (StoreCart sc12 : user_cart) {
			boolean sc_add = true;
			for (StoreCart sc1 : cart) {
				if (sc1.getStore().getId().equals(sc12.getStore().getId())) {
					sc_add = false;
				}
			}
			if (sc_add) {
				cart.add(sc12);
			}
		}
		// 遍历买家未登录状态下的购物车，并将购物车内容添加到cart对象里
		for (StoreCart sc11 : cookie_cart) {
			boolean sc_add = true;
			for (StoreCart sc1 : cart) {
				if (sc11.getStore().getId().equals(sc1.getStore().getId())) {
					sc_add = false;
					for (GoodsCart gc : sc1.getGcs()) {
						gc.setSc(sc1);
						this.goodsCartService.update(gc);
					}
					this.storeCartService.delete(sc1.getId());
				}
			}
			if (sc_add) {
				cart.add(sc11);
			}
		}
		boolean add = true;// 是否加入购物车的标志位
		double total_price = 0.0D;
		int total_count = 0;
		// 遍历购物车明细，判断用户已有购物车内是否包含当前所选规格的商品。如果包含，则
		for (StoreCart sc1 : cart) {
			for (GoodsCart gc : sc1.getGcs()) {
				if (gc.getGoods().getId().toString().equals(id)) {
					add = false;
				}
			}
		}
		GoodsCart obj = null;
		if (add) {
			// 买家当前所选规格的商品可以添加到购物车
			Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
			if (goods.getUser().getUserRole().indexOf("ADMIN") != -1) {
				buy_type = CommUtil.self_goods;
			}
			// 判断是更新购物车还是新增购物车，一个卖家一条购物车记录
			String type = "save";// 更新购物车内商品或新增加商品到购物车的标志位
			StoreCart sc33 = new StoreCart();
			// 遍历购物车，检查当前买家所选规格商品的店铺是否存在。如果存在，则更新购物车记录，否则新增购物车记录
			for (StoreCart sc1 : cart) {
				if (sc1.getStore().getId().equals(goods.getUser().getStore().getId())) {
					sc33 = sc1;
					type = "update";
					break;
				}
			}
			sc33.setStore(goods.getUser().getStore());
			if (type.equals("save")) {
				sc33.setAddTime(new Date());
				this.storeCartService.save(sc33);
			} else {
				this.storeCartService.update(sc33);
			}
			// 处理购物车明细
			obj = new GoodsCart();
			obj.setAddTime(new Date());
			obj.setCart_type(buy_type);
			obj.setPrice(goods.getPrice());
			obj.setCount(1);
			obj.setGoods(goods);
			obj.setSc(sc33);
			this.goodsCartService.save(obj);
			double cart_total_price = 0.0D;
			for (GoodsCart gc1 : sc33.getGcs()) {
				cart_total_price = cart_total_price + CommUtil.null2Double(gc1.getPrice()) * gc1.getCount();
			}
			sc33.setTotal_price(BigDecimal.valueOf(cart_total_price));
			if (user == null)
				sc33.setCart_session_id(cart_session_id);
			else {
				sc33.setUser(user);
			}

			// 再次更新购物车
			if (((String) type).equals("save")) {
				sc33.setAddTime(new Date());
				this.storeCartService.save(sc33);
			} else {
				this.storeCartService.update(sc33);
			}
			boolean cart_add = true;
			for (StoreCart sc1 : cart) {
				if (sc1.getStore().getId().equals(sc33.getStore().getId())) {
					cart_add = false;
				}
			}
			if (cart_add) {
				cart.add(sc33);
			}
		}
		// 计算购物车内商品总价
		  for(StoreCart sc1:cart){
			  total_count += sc1.getGcs().size();
			  for(GoodsCart gc1:sc1.getGcs()){
				  total_price = total_price + CommUtil.mul(gc1.getPrice(), Integer.valueOf(gc1.getCount()));
			  }
		  }
	     mv.addObject("total_count", total_count);
	     mv.addObject("total_price", total_price);
	     mv.addObject("cart", cart);
		return mv;
	}
}
