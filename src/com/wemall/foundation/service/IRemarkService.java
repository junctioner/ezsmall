package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Remark;

public interface IRemarkService {
	public abstract boolean save(Remark remark);

    public abstract boolean delete(Long paramLong);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(Remark remark);

    public abstract List<Remark> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}
