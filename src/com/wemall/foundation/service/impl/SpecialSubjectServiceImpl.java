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
import com.wemall.foundation.domain.Coupon;
import com.wemall.foundation.domain.SpecialSubject;
import com.wemall.foundation.service.ISpecialSubjectService;

@Service
@Transactional
public class SpecialSubjectServiceImpl implements ISpecialSubjectService {
    @Resource(name = "specialSubjectDao")
    private IGenericDAO<SpecialSubject> specialSubjectDao;
    
    public boolean save(SpecialSubject specialSubject){
        try {
            this.specialSubjectDao.save(specialSubject);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean update(SpecialSubject specialSubject){
        try {
            this.specialSubjectDao.update(specialSubject);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<SpecialSubject> query(String query, Map params, int begin, int max){
        return this.specialSubjectDao.query(query, params, begin, max);
    }

	@Override
	public boolean delete(Long paramLong) {
		
		try {
			this.specialSubjectDao.remove(paramLong);
			return true;
			// TODO Auto-generated method stub
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}
	
	public IPageList list(IQueryObject properties){
        if (properties == null){
            return null;
        }
        String query = properties.getQuery();
        Map params = properties.getParameters();
        GenericPageList pList = new GenericPageList(SpecialSubject.class, query,
                params, this.specialSubjectDao);
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

}
