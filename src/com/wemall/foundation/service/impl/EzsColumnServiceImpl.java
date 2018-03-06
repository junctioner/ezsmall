package com.wemall.foundation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.EzsColumnDao;
import com.wemall.foundation.domain.EzsColumn;
import com.wemall.foundation.domain.HomePageGoodsClass;
import com.wemall.foundation.service.IEzsColumnService;

@Service
@Transactional
public class EzsColumnServiceImpl implements IEzsColumnService {
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

	@Override
	public List<EzsColumn> getAllEzsColumn() {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deleteStatus", false);
		StringBuffer hql = new StringBuffer("from EzsColumn bean where bean.deleteStatus =:deleteStatus");
		return this.ezsColumnDao.query(hql.toString(),map, -1, -1);
	}
	
	@Override
	public List<EzsColumn> query(String query, Map params, int begin, int max){
        return this.ezsColumnDao.query(query, params, begin, max);
    }

}
