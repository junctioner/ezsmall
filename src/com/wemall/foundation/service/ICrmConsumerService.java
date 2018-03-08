package com.wemall.foundation.service;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.CrmConsumer;
import com.wemall.foundation.domain.Document;

public interface ICrmConsumerService {
	public abstract boolean save(CrmConsumer consumer);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(CrmConsumer consumer);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract List<CrmConsumer> query(String paramString, Map paramMap, int paramInt1, int paramInt2);

    public abstract CrmConsumer getObjByProperty(String paramString, Object paramObject);

	public abstract CrmConsumer getObjById(Long id);
}
