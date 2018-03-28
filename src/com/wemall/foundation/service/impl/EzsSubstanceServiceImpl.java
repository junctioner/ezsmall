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
import com.wemall.foundation.domain.EzsSubstance;
import com.wemall.foundation.service.IEzsSubstanceService;

@Service
@Transactional
public class EzsSubstanceServiceImpl implements IEzsSubstanceService{
	@Resource(name="ezsSubstanceDao")
	private IGenericDAO<EzsSubstance> ezsSubstanceDao;

	@Override
	public boolean save(EzsSubstance ezsSubstance){
        try {
            this.ezsSubstanceDao.save(ezsSubstance);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
	@Override
    public boolean delete(Long id){
        try {
            this.ezsSubstanceDao.remove(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
	@Override
    public IPageList list(IQueryObject properties){
        if (properties == null){
            return null;
        }
        String query = properties.getQuery();
        Map params = properties.getParameters();
        GenericPageList pList = new GenericPageList(EzsSubstance.class, query,
                params, this.ezsSubstanceDao);
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
    public boolean update(EzsSubstance ezsSubstance){
        try {
            this.ezsSubstanceDao.update(ezsSubstance);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
	@Override
    public List<EzsSubstance> query(String query, Map params, int begin, int max){
        return this.ezsSubstanceDao.query(query, params, begin, max);
    }

}
