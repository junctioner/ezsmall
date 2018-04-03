package com.wemall.foundation.service;

import java.util.List;

import com.wemall.foundation.domain.GoodsAuditLog;

public interface GoodsAuditLogService {
	
	/**
	 * 通过商品id查询审核流程中的商品日志
	 * @param id
	 * @return
	 */
	List<GoodsAuditLog> getGoodsAuditLogById(Long id);
	
	/**
	 * 添加审核流程中的商品日志
	 * @param GoodsAuditLog
	 * @return
	 */
	int addGoodsAuditLog(GoodsAuditLog goodsAuditLog);

}
