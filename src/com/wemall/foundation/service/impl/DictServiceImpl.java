package com.wemall.foundation.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Dict;
import com.wemall.foundation.service.IDictService;

@Service
@Transactional
public class DictServiceImpl implements IDictService {
	@Resource(name = "dictDao")
	private IGenericDAO<Dict> dictDao;

	@Override
	public boolean save(Dict paramDict) {
		boolean bool = false;
		try {
			dictDao.save(paramDict);
		} catch (Exception e) {
			e.printStackTrace();
			bool = false;
		}
		return bool;
	}

	@Override
	public Dict getObjById(Long paramLong) {
		
		return null;
	}

	@Override
	public boolean delete(Long paramLong) {
		return false;
	}

	@Override
	public boolean batchDelete(List<Serializable> paramList) {
		return false;
	}

	@Override
	public IPageList list(IQueryObject paramIQueryObject) {
		return null;
	}

	@Override
	public boolean update(Dict paramArea) {
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Dict> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return dictDao.query(paramString, paramMap, paramInt1, paramInt2);
	}

}
