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

	@RequestMapping("/admin/match_list.htm")
	public ModelAndView sampleManage(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new JModelAndView("/admin/blue/order/match_order_list.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
//		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> map1= new HashMap<String, Object>();
//		Map<String,Object> map2= new HashMap<String, Object>();
//		
//		map1.put("fenlei", "ppt塑料片");
//		map1.put("bianhao", "12345");
//		map1.put("danjia", "15"); 
//		map1.put("state", "1"); 
//		map1.put("num", "5");
//		map1.put("wuliu", "10");
//		map1.put("ad", "xds");
//		map1.put("ad", 1);
//		
//		map2.put("fenlei", "ppt塑料片");
//		map2.put("bianhao", "12345");
//		map2.put("danjia", "15"); 
//		map2.put("state", "1"); 
//		map2.put("num", "5");
//		map2.put("wuliu", "10");
//		map2.put("ad", "xds");
//		
//		list.add(map1);
//		list.add(map2);
//		mv.addObject("lists", list);
		return mv;
	
	}
}
