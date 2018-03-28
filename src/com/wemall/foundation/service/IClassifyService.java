package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Classify;

public interface IClassifyService {

	public abstract boolean save(Classify classify);

    public abstract boolean delete(Long paramLong);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(Classify classify);

    public abstract List<Classify> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
	
}
