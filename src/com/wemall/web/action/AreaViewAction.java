package com.wemall.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Area;
import com.wemall.foundation.service.IAreaService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

@Controller
public class AreaViewAction {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IAreaService areaService;

	@RequestMapping("/more_areas")
	public ModelAndView more_areas(HttpServletRequest request, HttpServletResponse response, String type) {
		ModelAndView mv = new JModelAndView("more_areas.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession().getAttribute("wemall_view_type"));// 显示类型
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("wap/more_areas.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteStatus", Boolean.valueOf(false));
		List<Area> areas = null;
		if (type != null && !"more".equals(type)) {
			areas = areaService.query(
					"select obj from Area obj where obj.deleteStatus =:deleteStatus and obj.parent.id is null", params,
					0, 24);
		} else {
			areas = areaService.query(
					"select obj from Area obj where obj.deleteStatus =:deleteStatus and obj.parent.id is null", params,
					-1, -1);
		}

		mv.addObject("areas", areas);
		return mv;
	}
}
