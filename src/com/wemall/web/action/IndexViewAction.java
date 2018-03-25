package com.wemall.web.action;

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
/**
 * 鍟嗗煄棣栭〉鎺у埗鍣?
 * @author 鍒樻亽绂?
 *
 */
@Controller
public class IndexViewAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@RequestMapping({ "/close.htm" })
	public ModelAndView wapclose(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("close.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/close.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}

		return mv;
	}
}
