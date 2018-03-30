package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.CrmContacts;

public interface ICrmContactsService {
	public abstract boolean save(CrmContacts contacts);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(CrmContacts contacts);
	
    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract List<CrmContacts> query(String paramString, Map paramMap, int paramInt1, int paramInt2);

    public abstract CrmContacts getObjByProperty(String paramString, Object paramObject);

	public abstract CrmContacts getObjById(Long valueOf);
}
