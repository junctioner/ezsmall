package com.wemall.web.tools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.service.IGoodsClassService;

/**
 * 导航工具类
 */
@Component
public class NavViewTools {

	@Autowired
	private IGoodsClassService goodsClassService;

	public List<GoodsClass> queryParent(int start, int end) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deleteStatus", Boolean.valueOf(false));
		return this.goodsClassService.query(
				"select obj from GoodsClass obj where obj.parent.id is null and obj.deleteStatus=:deleteStatus order by obj.sequence asc",
				params, start, end);

	}
}
