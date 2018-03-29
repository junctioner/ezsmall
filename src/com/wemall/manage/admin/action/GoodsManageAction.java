/**
 * Project Name:ezsmall
 * File Name:GoodsManageAction.java
 * Package Name:com.wemall.manage.admin.action
 * Date:2018年3月29日下午8:01:52
 * Copyright (c) 2018, yanL All Rights Reserved.
 *
*/

package com.wemall.manage.admin.action;

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
 * Date: 2018年3月29日 下午8:01:52 <br/>
 * 
 * @author yanL
 * @version
 * @see
 */
@Controller
public class GoodsManageAction {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @RequestMapping("/admin/goods_list.htm")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new JModelAndView("admin/blue/good_list.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);

        mv.addObject("msg", "hello world");

        return mv;

    }

}
