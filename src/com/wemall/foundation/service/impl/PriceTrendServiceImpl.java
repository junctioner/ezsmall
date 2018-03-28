package com.wemall.foundation.service.impl;

import java.io.Serializable;
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
import com.wemall.foundation.domain.PriceTrend;
import com.wemall.foundation.service.IPriceTrendService;

@Service
@Transactional
public class PriceTrendServiceImpl implements IPriceTrendService {
	@Resource(name = "priceTrendDao")
	private IGenericDAO<PriceTrend> priceTrendDao;



	 public boolean save(PriceTrend priceTrend){
	        try {
	            this.priceTrendDao.save(priceTrend);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public PriceTrend getObjById(Long id){
	        PriceTrend PriceTrend = (PriceTrend)this.priceTrendDao.get(id);
	        if (PriceTrend != null){
	            return PriceTrend;
	        }

	        return null;
	    }

	    public boolean delete(Long id){
	        try {
	            this.priceTrendDao.remove(id);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	    public boolean batchDelete(List<Serializable> PriceTrendIds){
	        for (Serializable id : PriceTrendIds){
	            delete((Long)id);
	        }

	        return true;
	    }

	    public IPageList list(IQueryObject properties){
	        if (properties == null){
	            return null;
	        }
	        String query = properties.getQuery();
	        Map params = properties.getParameters();
	        GenericPageList pList = new GenericPageList(PriceTrend.class, query,
	                params, this.priceTrendDao);
	        if (properties != null){
	            PageObject pageObj = properties.getPageObj();
	            if (pageObj != null){
	                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
	                        .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
	                        pageObj.getPageSize().intValue());
	            }
	        }else{
	            pList.doList(0, -1);
	        }

	        return pList;
	    }

	    public boolean update(PriceTrend PriceTrend){
	        try {
	            this.priceTrendDao.update(PriceTrend);
	            return true;
	        } catch (Exception e){
	            e.printStackTrace();
	        }

	        return false;
	    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriceTrend> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return priceTrendDao.query(paramString, paramMap, paramInt1, paramInt2);
	}

}
