/**
 * Project Name:ezsmall
 * File Name:DemeAction.java
 * Package Name:com.wemall.manage.admin.action
 * Date:2018年3月30日下午12:48:02
 * Copyright (c) 2018, bluemobi All Rights Reserved.
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

    @RequestMapping("/admin/store_list.htm")
    public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView jView = new JModelAndView("afterSales/NewFile.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        jView.addObject("aaa", "hello CHINA");
        return jView;
    }
}
