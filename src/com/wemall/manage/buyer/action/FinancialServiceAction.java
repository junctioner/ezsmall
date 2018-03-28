package com.wemall.manage.buyer.action;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.security.support.SecurityUserHolder;
import com.wemall.foundation.domain.FinancialServiceLoans;
import com.wemall.foundation.service.IAreaService;
import com.wemall.foundation.service.IFinancialServiceLoansService;
import com.wemall.foundation.service.IMainBusinessService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;

/***
 * 
 * @author 刘火强 金融服务
 */
@Controller
public class FinancialServiceAction {

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IAreaService areaService;

	@Autowired
	private IMainBusinessService mainBusinessService;

	@Autowired
	private IFinancialServiceLoansService iFinancialServiceLoansService;

	/**
	 * 金融服务页面
	 */
	@SecurityMapping(display = false, rsequence = 0, title = "huiyuan", value = "/admin/ezsSubstance_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
	@RequestMapping({ "/financialService.htm" })
	public ModelAndView financialService(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("financial_service.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		return mv;
	}

	/**
	 * 金融服务申请页面
	 */
	@SecurityMapping(display = false, rsequence = 0, title = "huiyuan", value = "/admin/ezsSubstance_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
	@RequestMapping({ "/financialServiceApply.htm" })
	public ModelAndView financialServiceApply(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		ModelAndView mv = new JModelAndView("financial_service_apply.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		List mainbusiness = this.mainBusinessService.query("from MainBusiness", null, -1, -1);
		mv.addObject("mainbusiness", mainbusiness);
		List areas = this.areaService.query("select obj from Area obj where obj.parent.id is null", null, -1, -1);
		mv.addObject("areas", areas);
		return mv;
	}

	/***
	 * 将申请的贷款资料存到数据库里面
	 */
	@RequestMapping({ "/financialServiceLoans.htm" })
	public void financialServiceLoans(HttpServletRequest request, HttpServletResponse response, String applyType,
			String companyName, String mainBusiness, String contacts, String telNum, String address,
			BigDecimal loanAmount) {
		try {

			FinancialServiceLoans financialServiceLoans = new FinancialServiceLoans();
			financialServiceLoans.setApplyType(applyType);
			financialServiceLoans.setCompanyName(companyName);
			financialServiceLoans.setMainBusiness(mainBusiness);
			financialServiceLoans.setContacts(contacts);
			financialServiceLoans.setTelNum(telNum);
			financialServiceLoans.setLoanAmount(loanAmount);
			financialServiceLoans.setAddress(address);
			financialServiceLoans.setUser(SecurityUserHolder.getCurrentUser());
			financialServiceLoans.setAddTime(new Date());
			iFinancialServiceLoansService.save(financialServiceLoans);
			// 重定向
			response.sendRedirect(request.getContextPath() + "/index.htm");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
