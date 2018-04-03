package com.wemall.foundation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wemall.core.base.GenericDAO;
import com.wemall.core.tools.DAOToolsByTM;
import com.wemall.foundation.domain.GoodsAuditLog;

@Repository("goodsAuditLogDAO")
public class GoodsAuditLogDAO extends GenericDAO<GoodsAuditLog>{
	
	/**
	 * 通过商品id查询审核流程中的商品日志
	 * @param id
	 * @return
	 */
	public List<GoodsAuditLog> getGoodsAuditLogById(Long id){
		return this.query("from GoodsAuditLog where goodsId = "+id+"", null, 0, 0);
	}
	
	/**
	 * 添加审核流程中的商品日志
	 * @param GoodsAuditLog
	 * @return
	 */
	public int addGoodsAuditLog(GoodsAuditLog goodsAuditLog){
		try {
			this.save(goodsAuditLog);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
