/**
 * Project Name:ezsmall
 * File Name:DemeAction.java
 * Package Name:com.wemall.manage.admin.action
 * Date:2018年3月30日下午12:48:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package com.wemall.manage.admin.action;

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
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/**
 * Description: <br/>
 * Date: 2018年3月30日 下午12:48:02 <br/>
 * 
 * @author weiSiYa
 * @version
 * @see
 */
@Controller
public class DemoAction {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    // @Autowired
    // private PriceApprovalSercive priceApprovalSercive;

    @RequestMapping("/admin/store_list.htm")
    public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView jView = new JModelAndView("afterSales/NewFile.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        // List<Goods> goodsList = priceApprovalSercive.queryPriceApproval();
        jView.addObject("goodsList", "goodsList");
        return jView;
    }

    @RequestMapping("/admin/goods_approval1.htm")
    public ModelAndView approvalPrice(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView jView = new JModelAndView("admin/blue/base/approvalPrice.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        map.put("id", 1);
        listMap.add(map);
        jView.addObject("listMap", listMap);
        return jView;
    }
}
