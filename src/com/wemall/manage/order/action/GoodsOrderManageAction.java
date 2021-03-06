package com.wemall.manage.order.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class GoodsOrderManageAction {

	@Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;
    
    /**
     * 商品订单列表
     * @param name
     * @param userName
     * @param publicTime
     * @param ec
     * @param userId
     * @param status
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
	 @RequestMapping({ "/admin/goods_order_list.htm" })
	    public ModelAndView admin_list(String name,String userName,String publicTime,String ec,String userId,String status,String currentPage, String orderBy, String orderType, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
	        ModelAndView mv = new JModelAndView("admin/blue/goods_order_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
	        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
	        for (int i = 0; i < 3; i++) {
	        	Map<String, Object> orderMap = new HashMap<String, Object>();
	        	orderMap.put("order_id", 12345678+i);
	        	orderMap.put("goods_unit_price", 22222+i);
	        	orderMap.put("goods_unit_weight", i);
	        	orderMap.put("order_price", 22222+i);
	        	list.add(orderMap);
			}
	        mv.addObject("objs", list);
			return mv;
	 }
	 

}
