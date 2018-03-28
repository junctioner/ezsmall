package com.wemall.manage.admin.action;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.security.support.SecurityUserHolder;
import com.wemall.foundation.domain.Classify;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.service.IClassifyService;
import com.wemall.foundation.service.IEzsColumnService;
import com.wemall.foundation.service.IGoodsClassService;
import com.wemall.foundation.service.IRemarkService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.manage.admin.tools.ColumnTool;

@Controller
public class EzsColumnAction {

	@Autowired
	private IEzsColumnService ezsColumnService;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private IGoodsClassService goodsClassService;

	@Autowired
	private IRemarkService remarkService;

	@Autowired
	private IClassifyService classifyService;
	@Autowired
	private ColumnTool columnTool;

	@SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value = "/admin/ezsColumn_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "设置")
	@RequestMapping({ "/admin/ezsColumn_list.htm" })
	public ModelAndView admin_list(String currentPage, String orderBy, String orderType, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		List<EzsColumn> list = ezsColumnService.getAllEzsColumn();
		mv.addObject("ezsColumnList", list);
		return mv;
	}

	/**
	 * 获取上级栏目
	 */
	@RequestMapping({ "/admin/parentLevel.htm" })
	public void parentLevel(String columnLevel, HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		List<EzsColumn> ezsColumns = null;
		try {
			// 获取上级栏目
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("deleteStatus", false);
			params.put("columnLevel", Integer.parseInt(columnLevel) - 1);
			ezsColumns = this.ezsColumnService.query(
					"from EzsColumn bean where bean.deleteStatus =:deleteStatus and bean.columnLevel =:columnLevel",
					params, -1, -1);
			PrintWriter out = response.getWriter();
			out.print(Json.toJson(ezsColumns, JsonFormat.compact()));
			// out.print(JSON.toJSONString(ezsColumns));
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value =
	// "/admin/loadAddEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode =
	// "admin_manage", rgroup = "设置")
	@RequestMapping({ "/admin/loadAddEzsColumn.htm" })
	public ModelAndView loadAddEzsColumn(String currentPage, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/addColumn.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deleteStatus", false);
		List<Remark> remarks = remarkService.query("from Remark bean where bean.deleteStatus =:deleteStatus", map, -1,
				-1);
		mv.addObject("remarks", remarks);
		return mv;
	}

	/**
	 * 获取分类名称
	 */
	@RequestMapping({ "/admin/remarkName.htm" })
	public void remarkName(String remarkId, String method, HttpServletResponse response) {

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		List<Classify> classifys = null;
		try {
			PrintWriter out = response.getWriter();
			// 获取分类名称
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("deleteStatus", false);
			params.put("remarkId", Long.valueOf(remarkId));
			if (method.equals("1")) {
				classifys = this.classifyService.query(
						"from Classify bean where bean.deleteStatus =:deleteStatus and bean.re.id =:remarkId", params,
						-1, -1);
				out.print(Json.toJson(classifys, JsonFormat.compact()));
				// out.print(JSON.toJSONString(classifys));
			} else if (method.equals("2")) {
				classifys = this.classifyService.query(
						"from Classify bean where bean.deleteStatus =:deleteStatus and bean.id =:remarkId", params, -1,
						-1);
				String[] strs = classifys.get(0).getRemarkValue().split("，");
				List<String> rvalues = Arrays.asList(strs);
				out.print(Json.toJson(rvalues, JsonFormat.compact()));
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @SecurityMapping(display = false, rsequence = 0, title = "管理员列表", value =
	// "/admin/addEzsColumn.htm*", rtype = "admin", rname = "管理员管理", rcode =
	// "admin_manage", rgroup = "设置")
	@RequestMapping({ "/admin/addEzsColumn.htm" })
	public ModelAndView addEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response) {
		String prepareColumn = request.getParameter("prepareColumn");
		// String [] prepare = StringUtils.split(prepareColumn, ",");
		// List<GoodsSpecification> list=new ArrayList<GoodsSpecification>();
		// for (String string : prepare) {
		// GoodsSpecification gif=new GoodsSpecification();
		// gif.setId(Long.parseLong(string));
		// System.out.println(string);
		// list.add(gif);
		// }
		User user = SecurityUserHolder.getCurrentUser();
		column.setAddTime(new Date());
		// column.setGsps(list);
		column.setPrepareColumn(null);
		column.setUser(user);
		column.setFinalSection(prepareColumn);
		String parentLevel = request.getParameter("parentLevel");
		if (null != parentLevel && !("").equals(parentLevel)) {
			EzsColumn parentEzsColumn = new EzsColumn();
			parentEzsColumn.setId(Long.parseLong(parentLevel));
			column.setParentEzsColumn(parentEzsColumn);
		}

		boolean flag = ezsColumnService.save(column);
		ModelAndView mv = null;
		if (flag) {
			mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 0, request, response);
			List<EzsColumn> li = ezsColumnService.getAllEzsColumn();
			mv.addObject("ezsColumnList", li);
		}
		return mv;
	}

	@RequestMapping({ "/admin/loadEditEzsColumn.htm" })
	public ModelAndView loadEditEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deleteStatus", false);

		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("deleteStatus", false);
		List<Remark> remarks = remarkService.query("from Remark bean where bean.deleteStatus =:deleteStatus", map4, -1,
				-1);
		mv.addObject("remarks", remarks);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("deleteStatus", false);
		map3.put("id", column.getId());
		List<EzsColumn> list3 = ezsColumnService
				.query("from EzsColumn bean where bean.deleteStatus=:deleteStatus and bean.id=:id", map3, -1, -1);
		mv.addObject("ezsColumn", list3.get(0));
		mv.addObject("columnTool", columnTool);
		return mv;
	}

	@RequestMapping({ "/admin/editColumn.htm" })
	public ModelAndView editColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response) {
		String prepareColumn = request.getParameter("prepareColumn");
		String parentLevel = request.getParameter("parentLevel");
		if (null != parentLevel && !("").equals(parentLevel)) {
			EzsColumn parentEzsColumn = new EzsColumn();
			parentEzsColumn.setId(Long.parseLong(parentLevel));
			column.setParentEzsColumn(parentEzsColumn);
		}
		User user = SecurityUserHolder.getCurrentUser();
		column.setAddTime(new Date());
		column.setUser(user);
		column.setPrepareColumn(null);
		column.setFinalSection(prepareColumn);
		boolean flag = ezsColumnService.update(column);
		ModelAndView mv = null;
		if (flag) {
			mv = new JModelAndView("admin/blue/ezsColumnList.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 0, request, response);
			List<EzsColumn> li = ezsColumnService.getAllEzsColumn();
			mv.addObject("ezsColumnList", li);
		}
		return mv;
	}

	@RequestMapping({ "/admin/loadViewEzsColumn.htm" })
	public ModelAndView loadViewEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		return mv;
	}

	@RequestMapping({ "/admin/loadSeeEzsColumn.htm" })
	public ModelAndView loadSeeEzsColumn(EzsColumn column, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/editColumn.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 0, request, response);
		return mv;
	}

}
