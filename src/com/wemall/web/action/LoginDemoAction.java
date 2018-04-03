package com.wemall.web.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.domain.GoodsAuditProcess;
import com.wemall.foundation.service.GoodsAuditProcessService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.ImageViewTools;


@Controller
public class LoginDemoAction {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private GoodsAuditProcessService goodsAuditProcessService;
	
	///wemall2/WebRoot/WEB-INF/templates/zh_cn/shop/default/goods_list.html
	@RequestMapping("/admin_add.htm")
	public ModelAndView loginDemo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter" + "/address.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		
		
		
		return mv;
		
	}
	@RequestMapping("/admin/test.htm")
	public ModelAndView loginDemo1(String id,String status,String style,HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/usercenter" + "/address.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("goods.status", 540);
		List<GoodsAuditProcess> listByGoodsAuditProcess = goodsAuditProcessService.listByGoodsAuditProcess(map, 0, 0);
		for (GoodsAuditProcess goodsAuditProcess : listByGoodsAuditProcess) {
			System.out.println(goodsAuditProcess);
		}
		
		return mv;
		
	}
	
	
	

}
