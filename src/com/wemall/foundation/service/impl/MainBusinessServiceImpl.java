package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.foundation.dao.MainBusinessDAO;
import com.wemall.foundation.domain.IntegralLog;
import com.wemall.foundation.domain.MainBusiness;
import com.wemall.foundation.service.IIntegralLogService;
import com.wemall.foundation.service.IMainBusinessService;

@Service
@Transactional
public class MainBusinessServiceImpl implements IMainBusinessService{

	@Resource(name = "mainBusinessDAO")
    private MainBusinessDAO mainBusinessDAO;
	
	public List<MainBusiness> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return this.mainBusinessDAO.query(paramString, paramMap, paramInt1, paramInt2);
	}


}
