package com.wemall.manage.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.tools.CommUtil;
import com.wemall.core.tools.WebForm;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.Goods;
import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.domain.query.PriceTrendQueryObject;
import com.wemall.foundation.service.IGoodsService;
import com.wemall.foundation.service.IPriceTrendService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/**
 * @author wangxiao
 * 价格行情
 */
@Controller
public class PriceManageAction {
	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private IGoodsService goodsService;
	@Autowired
	private  IPriceTrendService  priceTrendService;


	
	@RequestMapping({ "/admin/all_data.htm" })
	public ModelAndView loadViewEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/price/all_data.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		PriceTrendQueryObject qo = new PriceTrendQueryObject(currentPage, mv, "id", "asc");
		qo.addQuery("obj.deleteStatus = 0 ", null);
		WebForm wf = new WebForm();
		wf.toQueryPo(request, qo, GoodsClass.class, mv);
		IPageList pList = this.priceTrendService.list(qo);
		String url = this.configService.getSysConfig().getAddress();
		if ((url == null) || (url.equals(""))) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/admin/all_data.htm", "", "", pList, mv);
		return mv;
	}


}
