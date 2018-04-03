package com.wemall.core.tools;

import java.util.Iterator;
import java.util.Map;

/**
 * DAO工具类
 * @author tumin
 *
 */
public class DAOToolsByTM {
	
	/**
	 * 拼接动态Hql方法
	 * @param clazz
	 * @param params
	 * @return
	 */
	public static String dynamicHql(Class clazz, final Map params){
		StringBuffer sb = new StringBuffer("from ");
		sb.append(clazz.getName());
		if ((params == null) || (params.size() <= 0)) {
			return sb.toString();
		}
		sb.append(" where ");
		for (Iterator localIterator = params.keySet().iterator(); localIterator
				.hasNext();) {
			Object key = localIterator.next();
			sb.append(key.toString()).append("=").append(params.get(key))
					.append(" and ");
		}
		return sb.substring(0, sb.lastIndexOf("and"));
		
	}

}
