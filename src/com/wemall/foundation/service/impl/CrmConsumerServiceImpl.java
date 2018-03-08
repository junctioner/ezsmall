package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.dao.CrmConsumerDAO;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.CrmContacts;
import com.wemall.foundation.service.ICrmConsumerService;
@Service
@Transactional
public class CrmConsumerServiceImpl implements ICrmConsumerService{


	  
	 @Resource
	 private CrmConsumerDAO crmConsumerDao;

	@Override
	public boolean save(CrmConsumer consumer) {
		try {
			this.crmConsumerDao.save(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.crmConsumerDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CrmConsumer consumer) {
		try {
			this.crmConsumerDao.update(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public IPageList list(IQueryObject properties) {
		 if (properties == null){
	            return null;
	        }
	        String query = properties.getQuery();
	        Map params = properties.getParameters();
	        GenericPageList pList = new GenericPageList(CrmConsumer.class, query,
	                params, this.crmConsumerDao);
	        if (properties != null){
	            PageObject pageObj = properties.getPageObj();
	            if (pageObj != null)
	                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	                             .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
	                             pageObj.getPageSize().intValue());
	        }else{
	            pList.doList(0, -1);
	        }

	        return pList;
	}

	@Override
	public List<CrmConsumer> query(String query, Map params, int begin, int max) {
		// TODO Auto-generated method stub
		return  this.crmConsumerDao.query(query, params, begin, max);
	}

	@Override
	public CrmConsumer getObjByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return (CrmConsumer)this.crmConsumerDao.getBy(propertyName, value);
	}

	@Override
	public CrmConsumer getObjById(Long id) {
		// TODO Auto-generated method stub
		CrmConsumer crmConsumer = (CrmConsumer)this.crmConsumerDao.get(id);
        if (crmConsumer != null){
            return crmConsumer;
        }
		return null;
	}


}
