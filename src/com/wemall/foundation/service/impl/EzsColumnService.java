package com.wemall.foundation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.EzsColumnDao;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.service.IEzsColumnService;

@Service
@Transactional
public class EzsColumnService implements IEzsColumnService {
	@Resource(name = "ezsColumnDao")
	private EzsColumnDao ezsColumnDao;

	@Override
	public boolean save(EzsColumn ezsColumn) {
		try {
			this.ezsColumnDao.save(ezsColumn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.ezsColumnDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(EzsColumn ezsColumn) {
		try {
			this.ezsColumnDao.update(ezsColumn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
