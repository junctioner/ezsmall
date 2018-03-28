package com.wemall.web.tools;

import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Area;
import com.wemall.foundation.service.IAreaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.jam.mutable.MPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 行政区划工具类
 */
@Component
public class AreaViewTools {
	@Autowired
	private IAreaService areaService;

	public String generic_area_info(String area_id) {
		String area_info = "";
		Area area = this.areaService.getObjById(CommUtil.null2Long(area_id));
		if (area != null) {
			area_info = area.getAreaName() + " ";
			if (area.getParent() != null) {
				String info = generic_area_info(area.getParent().getId().toString());
				area_info = info + area_info;
			}
		}

		return area_info;
	}

	public List<Area> getAreaParentIsNull(int num) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("deleteStatus", Boolean.valueOf(false));
		return this.areaService.query(
				"select obj from Area obj where obj.parent.id is null and obj.deleteStatus=:deleteStatus", paramMap, 0,
				num);
	}

	public String getStrArea(String good_detall) {
		String str = "";
		if (good_detall != null && !"".equals(good_detall)) {
			Map map = CommUtil.getStrMap(good_detall);
			Area area = areaService.getObjById(CommUtil.null2Long(map.get("aread_id")));
			if (area != null) {
				str = area.getAreaName();
			}
		}
		return str;
	}

	public String getDepotStr(String good_detall) {
		String str = "";
		String city = "";
		String street = "";
		String province = "";
		if (good_detall != null && !"".equals(good_detall)) {
			Map map = CommUtil.getStrMap(good_detall);
			Area area = areaService.getObjById(CommUtil.null2Long(map.get("aread_id")));
			if (area != null) {
				street = area.getAreaName();
				if (area.getParent() != null) {
					city = area.getParent().getAreaName();
					if (area.getParent().getParent() != null) {
						province = area.getParent().getParent().getAreaName();
					}
				}
			}
			str = province + "-" + city + "-" + street + "-" + map.get("address");
		}
		return str;
	}
	public List<Area> getAreaBypid(long pid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pid", pid);
		return areaService.query("from Area obj where obj.parent.id =:pid ", map, -1, -1);
	}
}
