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
import com.wemall.core.tools.CommUtil;
import com.wemall.foundation.domain.Comment;
import com.wemall.foundation.domain.GoodsCart;
import com.wemall.foundation.domain.StoreCart;
import com.wemall.foundation.service.IStoreCartService;

@Service
@Transactional
public class StoreCartService implements IStoreCartService {
	@Resource(name = "storeCartDao")
	private IGenericDAO<StoreCart> storeCartDao;
	@Resource(name = "goodsCartDAO")
	private IGenericDAO<GoodsCart> goodsCartDAO;

	@Override
	public boolean save(StoreCart paramStoreCart) {
		try {
			storeCartDao.save(paramStoreCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public StoreCart getObjById(Long paramLong) {
		StoreCart storeCart = null;
		try {
			storeCart = storeCartDao.get(paramLong);
			return storeCart;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(Long paramLong) {
		try {
			storeCartDao.remove(paramLong);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean batchDelete(List<Serializable> paramList) {
		for (Serializable id : paramList) {
			delete(CommUtil.null2Long(id));
		}
		return false;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public IPageList list(IQueryObject properties) {
		if (properties == null) {
			return null;
		}
		String query = properties.getQuery();
		Map params = properties.getParameters();
		GenericPageList pList = new GenericPageList(Comment.class, query, params, this.storeCartDao);
		if (properties != null) {
			PageObject pageObj = properties.getPageObj();
			if (pageObj != null) {
				pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj.getCurrentPage().intValue(),
						pageObj.getPageSize() == null ? 0 : pageObj.getPageSize().intValue());
			}
		} else {
			pList.doList(0, -1);
		}
		return null;
	}

	@Override
	public boolean update(StoreCart paramStoreCart) {
		try {
			this.storeCartDao.update(paramStoreCart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<StoreCart> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		return storeCartDao.query(paramString, paramMap, paramInt1, paramInt2);
	}

	@Override
	public void deleteStoreCart(List<StoreCart> store_cookie_cart) {
          for(StoreCart cart:store_cookie_cart){
        	   for (GoodsCart gct : cart.getGcs()) {
				    this.goodsCartDAO.remove(gct.getId());
			}
        	 this.storeCartDao.remove(cart.getId());  
          }
	}

}
