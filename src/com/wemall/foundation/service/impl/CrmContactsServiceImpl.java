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
import com.wemall.foundation.dao.ConsumerDAO;
import com.wemall.foundation.dao.CrmContactsDAO;
import com.wemall.foundation.domain.Consumer;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.CrmContacts;
import com.wemall.foundation.domain.GoodsClass;
import com.wemall.foundation.service.IConsumerService;
import com.wemall.foundation.service.ICrmContactsService;
@Service
@Transactional
public class CrmContactsServiceImpl implements ICrmContactsService{

	@Resource
	private CrmContactsDAO crmContactsDao;

	@Override
	public boolean save(CrmContacts crmContacts) {
		try {
			this.crmContactsDao.save(crmContacts);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.crmContactsDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CrmContacts crmContacts) {
		try {
			this.crmContactsDao.update(crmContacts);
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
	                params, this.crmContactsDao);
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
	public List<CrmContacts> query(String query, Map params, int begin, int max) {
		// TODO Auto-generated method stub
		return  this.crmContactsDao.query(query, params, begin, max);
	}

	@Override
	public CrmContacts getObjByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return (CrmContacts)this.crmContactsDao.getBy(propertyName, value);
	}

	@Override
	public CrmContacts getObjById(Long id) {
		// TODO Auto-generated method stub
		CrmContacts crmContacts = (CrmContacts)this.crmContactsDao.get(id);
	        if (crmContacts != null){
	            return crmContacts;
	        }
		return null;
	}

}
