package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.SpecialSubject;

public abstract interface ISpecialSubjectService {
	public abstract boolean save(SpecialSubject column);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(SpecialSubject column);
	
	public List<SpecialSubject> query(String query, Map params, int begin, int max);
	
	public IPageList list(IQueryObject properties);
}
