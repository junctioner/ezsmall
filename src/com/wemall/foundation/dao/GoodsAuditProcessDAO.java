package com.wemall.foundation.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.core.tools.DAOToolsByTM;
import com.wemall.foundation.domain.GoodsAuditProcess;

@Repository("goodsAuditProcessDAO")
public class GoodsAuditProcessDAO extends GenericDAO<GoodsAuditProcess> {

	/**
	 * 查询所有审核流程中的商品
	 * 
	 * @param params
	 * @param begin
	 * @param max
	 * @return
	 */
	public List<GoodsAuditProcess> listByGoodsAuditProcess(Map params,
			int begin, int max) {
		String hql = DAOToolsByTM.dynamicHql(this.getEntityClass(), params);
		// System.out.println(hql);
		return this.query(hql, null, begin, max);
	}

	/**
	 * 通过id查询单条审核流程中的商品
	 * 
	 * @param id
	 * @return
	 */
	public GoodsAuditProcess getGoodsAuditProcessById(Long id) {
		return this.getBy("id", id);
	}

	/**
	 * 更新审核流程中的商品
	 * 
	 * @param goodsAuditProcess
	 * @return
	 */
	public int updateGoodsAuditProcess(GoodsAuditProcess goodsAuditProcess) {
		try {
			this.update(goodsAuditProcess);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
