/**
 * Project Name:ezsmall
 * File Name:GoodsManagerAction.java
 * Package Name:com.wemall.manage.admin.action
 * Date:2018年3月31日下午7:15:53
 * Copyright (c) 2018, yanL All Rights Reserved.
 *
*/

package com.wemall.manage.admin.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.foundation.domain.PriceAdjust;
import com.wemall.foundation.service.GoodsPriceManagerService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/**
 * Description: <br/>
 * Date: 2018年3月31日 下午7:15:53 <br/>
 * 
 * @author yanL
 * @version
 * @see
 */
@Controller
public class GoodsManagerAction {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private GoodsPriceManagerService goodsPriceManagerService;

    @RequestMapping("/admin/goods_approval2.htm")
    public ModelAndView adjustPriceApproval(HttpServletRequest request, HttpServletResponse response) {
        // System.out.println("----------------");
        ModelAndView mv = new JModelAndView("admin/blue/base/good_approval.html", configService.getSysConfig(),
                userConfigService.getUserConfig(), 0, request, response);

        List<PriceAdjust> list = goodsPriceManagerService.list();

        mv.addObject("list", list);
        return mv;

    }

}
