package com.wemall.foundation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.ConsumerDAO;
import com.wemall.foundation.dao.CrmDevDAO;
import com.wemall.foundation.domain.Consumer;
import com.wemall.foundation.domain.CrmDev;
import com.wemall.foundation.service.IConsumerService;
import com.wemall.foundation.service.ICrmDevService;
@Service
@Transactional
public class CrmDevServiceImpl implements ICrmDevService{

	@Resource
	private CrmDevDAO crmDevDao;

	@Override
	public boolean save(CrmDev crmDev) {
		try {
			this.crmDevDao.save(crmDev);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.crmDevDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CrmDev crmDev) {
		try {
			this.crmDevDao.update(crmDev);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
