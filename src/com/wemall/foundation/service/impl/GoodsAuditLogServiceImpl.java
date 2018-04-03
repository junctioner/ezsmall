package com.wemall.foundation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wemall.foundation.dao.GoodsAuditLogDAO;
import com.wemall.foundation.domain.GoodsAuditLog;
import com.wemall.foundation.service.GoodsAuditLogService;

@Service
public class GoodsAuditLogServiceImpl implements GoodsAuditLogService {
	
	@Resource(name = "goodsAuditLogDAO")
	private GoodsAuditLogDAO goodsAuditLogDAO;

	@Override
	public List<GoodsAuditLog> getGoodsAuditLogById(Long id) {
		return goodsAuditLogDAO.getGoodsAuditLogById(id);
	}

	@Override
	public int addGoodsAuditLog(GoodsAuditLog goodsAuditLog) {
		return goodsAuditLogDAO.addGoodsAuditLog(goodsAuditLog);
	}

}
