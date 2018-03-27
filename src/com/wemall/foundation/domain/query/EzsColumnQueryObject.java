package com.wemall.foundation.domain.query;

import org.springframework.web.servlet.ModelAndView;

import com.wemall.core.query.QueryObject;

public class EzsColumnQueryObject extends QueryObject {
	public EzsColumnQueryObject(String currentPage, ModelAndView mv, String orderBy, String orderType) {
		super(currentPage, mv, orderBy, orderType);
	}

	public EzsColumnQueryObject() {
	}
}
