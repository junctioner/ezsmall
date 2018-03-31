/**
 * Project Name:ezsmall
 * File Name:Test.java
 * Package Name:com.wemall.manage.admin.action
 * Date:2018年3月29日下午8:10:56
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
import com.wemall.foundation.domain.GoodClass;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.manage.admin.dao.impl.GoodsClassDaoImpl;

/**
 * Description: <br/>
 * Date: 2018年3月29日 下午8:10:56 <br/>
 * 
 * @author dingP
 * @version
 * @see
 */
@Controller
public class GoodsClassAction {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private GoodsClassDaoImpl gd;

    @RequestMapping("/admin/goods_class_list.htm")
    public ModelAndView admin_list(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("afterSales/goodsClass.html", configService.getSysConfig(),
                userConfigService.getUserConfig(), 0, request, response);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map1.put("aa", "123");
        map2.put("aa", "456");
        list.add(map1);
        list.add(map2);
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/admin/addGoodsClass.htm")
    public ModelAndView addGoodsClass(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("afterSales/addGoodsClass.html", configService.getSysConfig(),
                userConfigService.getUserConfig(), 0, request, response);
        List<GoodClass> list = gd.name();
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/admin/speedAddGoodsClass.htm")
    public ModelAndView speedAddGoodsClass(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("afterSales/speedAddGoodsClass.html", configService.getSysConfig(),
                userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }
}
