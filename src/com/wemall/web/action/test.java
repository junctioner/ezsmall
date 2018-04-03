//package com.wemall.web.action;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.wemall.core.mv.JModelAndView;
//import com.wemall.foundation.domain.EzsColumn;
//import com.wemall.foundation.service.ISysConfigService;
//import com.wemall.foundation.service.IUserConfigService;
//@Controller
//public class test {
//
//	@Autowired
//    private ISysConfigService configService;
//
//    @Autowired
//    private IUserConfigService userConfigService;
//	
//	@RequestMapping({ "/admin/goods_supp_list.htm" })
//	public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView("admin/blue/goods_supp_list.html", this.configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		
//		 List<Map<String, String>> list = new ArrayList<Map<String,String>>();
//	        Map<String,String> map = new HashMap<String, String>();
//	        
//	        map.put("fenlei", "ppt塑料片");
//	        map.put("shuiliaopian", "塑料片");
//	        map.put("gongyigshang", "海天酱油供应商");
//	        map.put("gongyingjia", "5000");
//	        map.put("xiaoshoujia", "6000");
//	        map.put("kucun", "100");
//	       map.put("zhuangtai", "100");
//	        map.put("riqi", "2018-3-31");
//	        map.put("paixu", "5");
//	        map.put("liulan", "1000");
//	        map.put("liuyangpin", "500");
//	        Map<String,String> map2 = new HashMap<String, String>();
//	        
//	        map2.put("fenlei", "ppt塑料片");
//	        map2.put("shuiliaopian", "塑料片");
//	        map2.put("gongyigshang", "海天酱油供应商");
//	        map2.put("gongyingjia", "5000");
//	        map2.put("xiaoshoujia", "6000");
//	        map2.put("kucun", "100");
//	        map2.put("zhuangtai", "100");
//	        map2.put("riqi", "2018-3-31");
//	        map2.put("paixu", "5");
//	        map2.put("liulan", "1000");
//	        map2.put("liuyangpin", "500");
//	        Map<String,String> map3 = new HashMap<String, String>();
//	        
//	        map3.put("fenlei", "ppt塑料片");
//	        map3.put("shuiliaopian", "塑料片");
//	        map3.put("gongyigshang", "海天酱油供应商");
//	        map3.put("gongyingjia", "5000");
//	        map3.put("xiaoshoujia", "6000");
//	        map3.put("kucun", "100");
//	        map3.put("zhuangtai", "100");
//	        map3.put("riqi", "2018-3-31");
//	        map3.put("paixu", "5");
//	        map3.put("liulan", "1000");
//	        map3.put("liuyangpin", "500");
//		
//		
//	        list.add(map);
//	        list.add(map2);
//	        list.add(map3);
//	        mv.addObject("list", list);
//	        return mv;
//	}
//	
//	
//}
