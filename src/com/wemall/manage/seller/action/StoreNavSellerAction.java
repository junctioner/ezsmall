package com.wemall.manage.seller.action;

import com.wemall.core.annotation.SecurityMapping;
import com.wemall.core.domain.virtual.SysMap;
import com.wemall.core.mv.JModelAndView;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.security.support.SecurityUserHolder;
import com.wemall.core.tools.CommUtil;
import com.wemall.core.tools.WebForm;
import com.wemall.foundation.domain.Store;
import com.wemall.foundation.domain.StoreNavigation;
import com.wemall.foundation.domain.SysConfig;
import com.wemall.foundation.domain.User;
import com.wemall.foundation.domain.query.StoreNavigationQueryObject;
import com.wemall.foundation.service.IStoreNavigationService;
import com.wemall.foundation.service.IStoreService;
import com.wemall.foundation.service.ISysConfigService;
import com.wemall.foundation.service.IUserConfigService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreNavSellerAction {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IStoreNavigationService storenavigationService;

    @Autowired
    private IStoreService storeService;

    @SecurityMapping(display = false, rsequence = 0, title = "卖家导航管理", value = "/seller/store_nav.htm*", rtype = "seller", rname = "导航管理", rcode = "store_nav_seller", rgroup = "店铺设置")
    @RequestMapping( {"/seller/store_nav.htm"})
    public ModelAndView store_nav(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType) {
        ModelAndView mv = new JModelAndView(
            "user/default/usercenter/store_nav.html", this.configService
            .getSysConfig(),
            this.userConfigService.getUserConfig(), 0, request, response);
        String url = this.configService.getSysConfig().getAddress();
        if ((url == null) || (url.equals(""))) {
            url = CommUtil.getURL(request);
        }
        String params = "";
        StoreNavigationQueryObject qo = new StoreNavigationQueryObject(
            currentPage, mv, orderBy, orderType);
        Store store = this.storeService.getObjByProperty("user.id",
                      SecurityUserHolder.getCurrentUser().getId());
        qo.addQuery("obj.store.id", new SysMap("store_id", store.getId()), "=");

        IPageList pList = this.storenavigationService.list(qo);
        CommUtil.saveIPageList2ModelAndView(url + "/seller/store_nav.htm", "",
                                            params, pList, mv);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title = "卖家导航添加", value = "/seller/store_nav_add.htm*", rtype = "seller", rname = "导航管理", rcode = "store_nav", rgroup = "店铺设置")
    @RequestMapping( {"/seller/store_nav_add.htm"})
    public ModelAndView store_nav_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView(
            "user/default/usercenter/store_nav_add.html", this.configService
            .getSysConfig(),
            this.userConfigService.getUserConfig(), 0, request, response);
        mv.addObject("currentPage", currentPage);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title = "卖家导航编辑", value = "/seller/store_nav_edit.htm*", rtype = "seller", rname = "导航管理", rcode = "store_nav", rgroup = "店铺设置")
    @RequestMapping( {"/seller/store_nav_edit.htm"})
    public ModelAndView store_nav_edit(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) {
        ModelAndView mv = new JModelAndView(
            "user/default/usercenter/store_nav_add.html", this.configService
            .getSysConfig(),
            this.userConfigService.getUserConfig(), 0, request, response);
        if ((id != null) && (!id.equals(""))) {
            StoreNavigation storenavigation = this.storenavigationService
                                              .getObjById(Long.valueOf(Long.parseLong(id)));
            mv.addObject("obj", storenavigation);
            mv.addObject("currentPage", currentPage);
            mv.addObject("edit", Boolean.valueOf(true));
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title = "卖家导航保存", value = "/seller/store_nav_save.htm*", rtype = "seller", rname = "导航管理", rcode = "store_nav", rgroup = "店铺设置")
    @RequestMapping( {"/seller/store_nav_save.htm"})
    public ModelAndView store_nav_save(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String cmd) {
        WebForm wf = new WebForm();
        StoreNavigation storenavigation = null;
        if (id.equals("")) {
            storenavigation = (StoreNavigation)wf.toPo(request, StoreNavigation.class);
            storenavigation.setAddTime(new Date());
        } else {
            StoreNavigation obj = this.storenavigationService.getObjById(
                                      Long.valueOf(Long.parseLong(id)));
            storenavigation = (StoreNavigation)wf.toPo(request, obj);
        }
        Store store = this.storeService.getObjByProperty("user.id",
                      SecurityUserHolder.getCurrentUser().getId());
        storenavigation.setStore(store);
        if (id.equals(""))
            this.storenavigationService.save(storenavigation);
        else
            this.storenavigationService.update(storenavigation);
        ModelAndView mv = new JModelAndView(
            "user/default/usercenter/success.html", this.configService
            .getSysConfig(),
            this.userConfigService.getUserConfig(), 0, request, response);
        mv.addObject("url", CommUtil.getURL(request) + "/seller/store_nav.htm");
        mv.addObject("op_title", "保存导航成功");
        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title = "卖家导航删除", value = "/seller/store_nav_del.htm*", rtype = "seller", rname = "导航管理", rcode = "store_nav", rgroup = "店铺设置")
    @RequestMapping( {"/seller/store_nav_del.htm"})
    public String store_nav_del(HttpServletRequest request, HttpServletResponse response, String mulitId, String currentPage) {
        String[] ids = mulitId.split(",");
        for (String id : ids) {
            if (!id.equals("")) {
                StoreNavigation storenavigation = this.storenavigationService
                                                  .getObjById(Long.valueOf(Long.parseLong(id)));
                this.storenavigationService.delete(Long.valueOf(Long.parseLong(id)));
            }
        }
        return "redirect:store_nav.htm?currentPage=" + currentPage;
    }
}




