package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemall.foundation.dao.GoodsAuditProcessDAO;
import com.wemall.foundation.domain.GoodsAuditProcess;
import com.wemall.foundation.service.GoodsAuditProcessService;

@Service
public class GoodsAuditProcessServiceImpl implements GoodsAuditProcessService {
	
	@Resource(name = "goodsAuditProcessDAO")
	private GoodsAuditProcessDAO goodsAuditProcessDAO;

	@Override
	public List<GoodsAuditProcess> listByGoodsAuditProcess(Map params,
			int begin, int max) {
		return goodsAuditProcessDAO.listByGoodsAuditProcess(params, begin, max);
	}

	@Override
	public GoodsAuditProcess getGoodsAuditProcessById(Long id) {
		return goodsAuditProcessDAO.getGoodsAuditProcessById(id);
	}

	@Override
	public int updateGoodsAuditProcess(GoodsAuditProcess goodsAuditProcess) {
		return goodsAuditProcessDAO.updateGoodsAuditProcess(goodsAuditProcess);
	}

}
