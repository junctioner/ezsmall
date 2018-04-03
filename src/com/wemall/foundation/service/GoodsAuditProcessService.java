package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.foundation.domain.GoodsAuditProcess;

public interface GoodsAuditProcessService {

	/**
	 * 查询所有审核流程中的商品
	 * 
	 * @param params
	 * @param begin
	 * @param max
	 * @return
	 */
	List<GoodsAuditProcess> listByGoodsAuditProcess(Map params, int begin,
			int max);

	/**
	 * 通过id查询单条审核流程中的商品
	 * 
	 * @param id
	 * @return
	 */
	GoodsAuditProcess getGoodsAuditProcessById(Long id);

	/**
	 * 更新审核流程中的商品
	 * 
	 * @param goodsAuditProcess
	 * @return
	 */
	int updateGoodsAuditProcess(GoodsAuditProcess goodsAuditProcess);

}
