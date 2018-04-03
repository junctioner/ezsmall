package com.wemall.manage.order.action;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;
import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.domain.SampleTest;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class MatchOrderAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;

	/**
	 * 撮合订单列表
	 * 
	 * @param 孙世林
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("/admin/match_list.htm")
	public ModelAndView sampleManage(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new JModelAndView("/admin/blue/order/match_order_list.html",
				this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		Map<String, Object> map5 = new HashMap<String, Object>();
		Map<String, Object> map6 = new HashMap<String, Object>();
		map1.put("check_order", "tj34242342344");
		map1.put("order", "tj34242342344");
		map1.put("price", "-1000");
		map1.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map1.put("buyer_name", "dongkengxincheng");
		map1.put("buyer_phone", "13333333333");
		map1.put("apply_man", "张三");
		map1.put("status", "待审核");
		map1.put("date", "2017-12-20  19:32:00");
		map1.put("check", "审核");

		map2.put("check_order", "tj34242342345");
		map2.put("order", "tj34242342345");
		map2.put("price", "-1000");
		map2.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map2.put("buyer_name", "dongkengxincheng");
		map2.put("buyer_phone", "14444444444");
		map2.put("apply_man", "李四");
		map2.put("status", "待审核");
		map2.put("date", "2017-12-20  19:32:00");
		map2.put("check", "审核");

		map3.put("check_order", "tj34242342345");
		map3.put("order", "tj34242342345");
		map3.put("price", "-1000");
		map3.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map3.put("buyer_name", "dongkengxincheng");
		map3.put("buyer_phone", "14444444444");
		map3.put("apply_man", "李四");
		map3.put("status", "审核通过");
		map3.put("approve_man", "lisa");
		map3.put("date_apply", "2017-12-20  19:32:00");
		map3.put("date_approve", "2017-12-20  19:32:00");
		map3.put("check", "查看");

		map4.put("check_order", "tj34242342344");
		map4.put("order", "tj34242342344");
		map4.put("price", "-1000");
		map4.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map4.put("buyer_name", "dongkengxincheng");
		map4.put("buyer_phone", "13333333333");
		map4.put("apply_man", "张三");
		map4.put("status", "审核通过");
		map4.put("approve_man", "lisa");
		map4.put("date_apply", "2017-12-20  19:32:00");
		map4.put("date_approve", "2017-12-20  19:32:00");
		map4.put("check", "查看");

		map6.put("check_order", "tj34242342345");
		map6.put("order", "tj34242342345");
		map6.put("price", "-1000");
		map6.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map6.put("buyer_name", "dongkengxincheng");
		map6.put("buyer_phone", "14444444444");
		map6.put("apply_man", "李四");
		map6.put("status", "审核不通过");
		map6.put("approve_man", "lisa");
		map6.put("date_apply", "2017-12-20  19:32:00");
		map6.put("date_approve", "2017-12-20  19:32:00");
		map6.put("check", "查看");

		map5.put("check_order", "tj34242342344");
		map5.put("order", "tj34242342344");
		map5.put("price", "-1000");
		map5.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map5.put("buyer_name", "dongkengxincheng");
		map5.put("buyer_phone", "13333333333");
		map5.put("apply_man", "张三");
		map5.put("status", "审核不通过");
		map5.put("approve_man", "lisa");
		map5.put("date_apply", "2017-12-20  19:32:00");
		map5.put("date_approve", "2017-12-20  19:32:00");
		map5.put("check", "查看");

		list.add(map1);
		list.add(map2);
		list1.add(map3);
		list1.add(map4);
		list2.add(map5);
		list2.add(map6);
		mv.addObject("list", list);
		mv.addObject("list1", list1);
		mv.addObject("list2", list2);

		return mv;

	}
	@RequestMapping("/admin/match_list_pass.htm")
	public ModelAndView sampleManage_pass(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new JModelAndView("/admin/blue/order/match_order_list_pass.html",
				this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		Map<String, Object> map5 = new HashMap<String, Object>();
		Map<String, Object> map6 = new HashMap<String, Object>();
		map1.put("check_order", "tj34242342344");
		map1.put("order", "tj34242342344");
		map1.put("price", "-1000");
		map1.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map1.put("buyer_name", "dongkengxincheng");
		map1.put("buyer_phone", "13333333333");
		map1.put("apply_man", "张三");
		map1.put("status", "待审核");
		map1.put("date", "2017-12-20  19:32:00");
		map1.put("check", "审核");

		map2.put("check_order", "tj34242342345");
		map2.put("order", "tj34242342345");
		map2.put("price", "-1000");
		map2.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map2.put("buyer_name", "dongkengxincheng");
		map2.put("buyer_phone", "14444444444");
		map2.put("apply_man", "李四");
		map2.put("status", "待审核");
		map2.put("date", "2017-12-20  19:32:00");
		map2.put("check", "审核");

		map3.put("check_order", "tj34242342345");
		map3.put("order", "tj34242342345");
		map3.put("price", "-1000");
		map3.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map3.put("buyer_name", "dongkengxincheng");
		map3.put("buyer_phone", "14444444444");
		map3.put("apply_man", "李四");
		map3.put("status", "审核通过");
		map3.put("approve_man", "lisa");
		map3.put("date_apply", "2017-12-20  19:32:00");
		map3.put("date_approve", "2017-12-20  19:32:00");
		map3.put("check", "查看");

		map4.put("check_order", "tj34242342344");
		map4.put("order", "tj34242342344");
		map4.put("price", "-1000");
		map4.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map4.put("buyer_name", "dongkengxincheng");
		map4.put("buyer_phone", "13333333333");
		map4.put("apply_man", "张三");
		map4.put("status", "审核通过");
		map4.put("approve_man", "lisa");
		map4.put("date_apply", "2017-12-20  19:32:00");
		map4.put("date_approve", "2017-12-20  19:32:00");
		map4.put("check", "查看");

		map6.put("check_order", "tj34242342345");
		map6.put("order", "tj34242342345");
		map6.put("price", "-1000");
		map6.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map6.put("buyer_name", "dongkengxincheng");
		map6.put("buyer_phone", "14444444444");
		map6.put("apply_man", "李四");
		map6.put("status", "审核不通过");
		map6.put("approve_man", "lisa");
		map6.put("date_apply", "2017-12-20  19:32:00");
		map6.put("date_approve", "2017-12-20  19:32:00");
		map6.put("check", "查看");

		map5.put("check_order", "tj34242342344");
		map5.put("order", "tj34242342344");
		map5.put("price", "-1000");
		map5.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map5.put("buyer_name", "dongkengxincheng");
		map5.put("buyer_phone", "13333333333");
		map5.put("apply_man", "张三");
		map5.put("status", "审核不通过");
		map5.put("approve_man", "lisa");
		map5.put("date_apply", "2017-12-20  19:32:00");
		map5.put("date_approve", "2017-12-20  19:32:00");
		map5.put("check", "查看");

		list.add(map1);
		list.add(map2);
		list1.add(map3);
		list1.add(map4);
		list2.add(map5);
		list2.add(map6);
		mv.addObject("list", list);
		mv.addObject("list1", list1);
		mv.addObject("list2", list2);

		return mv;

	}
	@RequestMapping("/admin/match_list_not.htm")
	public ModelAndView sampleManage_not(String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mv = new JModelAndView("/admin/blue/order/match_order_list_not.html",
				this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		Map<String, Object> map4 = new HashMap<String, Object>();
		Map<String, Object> map5 = new HashMap<String, Object>();
		Map<String, Object> map6 = new HashMap<String, Object>();
		map1.put("check_order", "tj34242342344");
		map1.put("order", "tj34242342344");
		map1.put("price", "-1000");
		map1.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map1.put("buyer_name", "dongkengxincheng");
		map1.put("buyer_phone", "13333333333");
		map1.put("apply_man", "张三");
		map1.put("status", "待审核");
		map1.put("date", "2017-12-20  19:32:00");
		map1.put("check", "审核");

		map2.put("check_order", "tj34242342345");
		map2.put("order", "tj34242342345");
		map2.put("price", "-1000");
		map2.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map2.put("buyer_name", "dongkengxincheng");
		map2.put("buyer_phone", "14444444444");
		map2.put("apply_man", "李四");
		map2.put("status", "待审核");
		map2.put("date", "2017-12-20  19:32:00");
		map2.put("check", "审核");

		map3.put("check_order", "tj34242342345");
		map3.put("order", "tj34242342345");
		map3.put("price", "-1000");
		map3.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map3.put("buyer_name", "dongkengxincheng");
		map3.put("buyer_phone", "14444444444");
		map3.put("apply_man", "李四");
		map3.put("status", "审核通过");
		map3.put("approve_man", "lisa");
		map3.put("date_apply", "2017-12-20  19:32:00");
		map3.put("date_approve", "2017-12-20  19:32:00");
		map3.put("check", "查看");

		map4.put("check_order", "tj34242342344");
		map4.put("order", "tj34242342344");
		map4.put("price", "-1000");
		map4.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map4.put("buyer_name", "dongkengxincheng");
		map4.put("buyer_phone", "13333333333");
		map4.put("apply_man", "张三");
		map4.put("status", "审核通过");
		map4.put("approve_man", "lisa");
		map4.put("date_apply", "2017-12-20  19:32:00");
		map4.put("date_approve", "2017-12-20  19:32:00");
		map4.put("check", "查看");

		map6.put("check_order", "tj34242342345");
		map6.put("order", "tj34242342345");
		map6.put("price", "-1000");
		map6.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map6.put("buyer_name", "dongkengxincheng");
		map6.put("buyer_phone", "14444444444");
		map6.put("apply_man", "李四");
		map6.put("status", "审核不通过");
		map6.put("approve_man", "lisa");
		map6.put("date_apply", "2017-12-20  19:32:00");
		map6.put("date_approve", "2017-12-20  19:32:00");
		map6.put("check", "查看");

		map5.put("check_order", "tj34242342344");
		map5.put("order", "tj34242342344");
		map5.put("price", "-1000");
		map5.put("buyer_enterprise", "东莞市东坑鑫成塑胶加工店");
		map5.put("buyer_name", "dongkengxincheng");
		map5.put("buyer_phone", "13333333333");
		map5.put("apply_man", "张三");
		map5.put("status", "审核不通过");
		map5.put("approve_man", "lisa");
		map5.put("date_apply", "2017-12-20  19:32:00");
		map5.put("date_approve", "2017-12-20  19:32:00");
		map5.put("check", "查看");

		list.add(map1);
		list.add(map2);
		list1.add(map3);
		list1.add(map4);
		list2.add(map5);
		list2.add(map6);
		mv.addObject("list", list);
		mv.addObject("list1", list1);
		mv.addObject("list2", list2);

		return mv;

	}
}
