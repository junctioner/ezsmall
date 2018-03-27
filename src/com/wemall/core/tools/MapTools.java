package com.wemall.core.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.geostar.gtgh.DataCenter_util.JsonHelper;
import com.wemall.core.tools.bean.GoodEc;
import com.wemall.core.tools.bean.GoodPec;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MapTools {
	public static List<Map<String, Object>> parseJSON2List(String jsonStr) {
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Iterator<JSONObject> it = jsonArr.iterator();
		while (it.hasNext()) {
			JSONObject json2 = it.next();
			list.add(parseJSON2Map(json2.toString()));
		}
		return list;
	}

	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	public static List<Map<String, Object>> getListByUrl(String url) {
		try {
			// 通过HTTP获取JSON数据
			InputStream in = new URL(url).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return parseJSON2List(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Map<String, Object> getMapByUrl(String url) {
		try {
			// 通过HTTP获取JSON数据
			InputStream in = new URL(url).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return parseJSON2Map(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<GoodEc> getGoodEcByStr(String jsonStr) {
		List<GoodEc> goodEcs = null;
		if (jsonStr != null && !"".equals(jsonStr)) {
			goodEcs = new ArrayList<GoodEc>();
			JSONArray jsonArray = JsonHelper.String2JSONArray(jsonStr);
			for (int i = 0; i < jsonArray.size(); i++) {
				GoodEc goodEc = (GoodEc) JSONObject.toBean(jsonArray.getJSONObject(i), GoodEc.class);
				goodEcs.add(goodEc);
			}
		}
		return goodEcs;
	}
    public static List<GoodPec> getGoodPecByStr(String jsonStr){
    	List<GoodPec> goodPecs = null;
    	if (jsonStr != null && !"".equals(jsonStr)) {
    		goodPecs = new ArrayList<GoodPec>();
			JSONArray jsonArray = JsonHelper.String2JSONArray(jsonStr);
			for (int i = 0; i < jsonArray.size(); i++) {
				GoodPec goodEc = (GoodPec) JSONObject.toBean(jsonArray.getJSONObject(i), GoodPec.class);
				goodPecs.add(goodEc);
			}
		}
    	return goodPecs;
    }
	public static void main(String[] args) {
		String xx = "[{\"val\":\"121\",\"name\":\"from\"},{\"val\":\"121\",\"name\":\"from\"}]";
		JSONArray jsonArray = JsonHelper.String2JSONArray(xx);
		for (int i = 0; i < jsonArray.size(); i++) {
			GoodEc goodEc = (GoodEc) JSONObject.toBean(jsonArray.getJSONObject(i), GoodEc.class);
			if (goodEc != null) {
				System.out.println(goodEc.getName());
			}
		}

	}
}
