package com.wemall.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.mv.JModelAndView;
import com.wemall.core.security.support.SecurityUserHolder;
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import com.wemall.web.tools.ImageViewTools;

/**
 * 前台用户登陆控制器
 * 
 * @author 刘恒福
 *
 */
@Controller
public class LoginViewAction {
	@Autowired
	private ISysConfigService configService;
	@Autowired
	private IUserConfigService userConfigService;
	@Autowired
	private ImageViewTools imageViewTools;

	/**
	 * 用户登录跳转页面
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
	@RequestMapping({ "/user/login.htm" })
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String url) {
		ModelAndView mv = new JModelAndView("login.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		String wemall_view_type = CommUtil.null2String(request.getSession(false).getAttribute("wemall_view_type"));
		if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
			mv = new JModelAndView("/wap/login.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
		}
		request.getSession(false).removeAttribute("verify_code");
		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if ((url != null) && (!url.equals(""))) {
			request.getSession(false).setAttribute("refererUrl", url);
		}
		if (domain_error) {
			mv = new JModelAndView("error.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))) {
				mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
						this.userConfigService.getUserConfig(), 1, request, response);
			}
		} else {
			mv.addObject("imageViewTools", this.imageViewTools);
		}
		mv.addObject("uc_logout_js", request.getSession(false).getAttribute("uc_logout_js"));
		return mv;
	}

    /**
     * 登录操作成功之后跳转判断
     * @param request
     * @param response
     * @return
     */
    @RequestMapping({"/user_login_success.htm"})
    public ModelAndView user_login_success(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String url = CommUtil.getURL(request) + "/index.htm";
        String wemall_view_type = CommUtil.null2String(request.getSession(false).getAttribute("wemall_view_type"));
        //跳转到微信端
        if ((wemall_view_type != null) && (!wemall_view_type.equals("")) && (wemall_view_type.equals("wap"))){
            String store_id = CommUtil.null2String(request.getSession(false).getAttribute("store_id"));
            mv = new JModelAndView("wap/success.html",
                                   this.configService.getSysConfig(),
                                   this.userConfigService.getUserConfig(), 1, request, response);
            url = CommUtil.getURL(request) + "/wap/index.htm?store_id=" + store_id;
        }
        HttpSession session = request.getSession(false);
        if ((session.getAttribute("refererUrl") != null) &&
                (!session.getAttribute("refererUrl").equals(""))){
            url = (String)session.getAttribute("refererUrl");
            session.removeAttribute("refererUrl");
        }
        if (this.configService.getSysConfig().isUc_bbs()){
            String uc_login_js = CommUtil.null2String(request.getSession(false).getAttribute("uc_login_js"));
            mv.addObject("uc_login_js", uc_login_js);
        }
        //第三方登录：QQ、新浪等
        String bind = CommUtil.null2String(request.getSession(false).getAttribute("bind"));
        if (!bind.equals("")){
            mv = new JModelAndView(bind + "_login_bind.html",this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
            User user = SecurityUserHolder.getCurrentUser();
            mv.addObject("user", user);
            request.getSession(false).removeAttribute("bind");
        }
        mv.addObject("op_title", "登录成功");
        mv.addObject("url", url);

        return mv;
    }
}
