package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Classify;
import com.wemall.foundation.domain.Remark;
import com.wemall.foundation.service.IClassifyService;

@Service
@Transactional
public class ClassifyServiceImpl implements IClassifyService{
	
	@Resource(name="classifyDao")
	private IGenericDAO<Classify> classifyDao;

	@Override
	public boolean save(Classify classify) {
		try {
            this.classifyDao.save(classify);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean delete(Long paramLong) {
		try {
            this.classifyDao.remove(paramLong);
            return true;
        } catch (Exception e){
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
        GenericPageList pList = new GenericPageList(Classify.class, query,
                params, this.classifyDao);
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
	public boolean update(Classify classify) {
		try {
            this.classifyDao.update(classify);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
	}

	@Override
	public List<Classify> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return this.classifyDao.query(paramString, paramMap, paramInt1, paramInt2);
	}

}
