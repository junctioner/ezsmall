package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.EzsSubstance;

public interface IEzsSubstanceService {
	
	public abstract boolean save(EzsSubstance ezsSubstance);

    public abstract boolean delete(Long paramLong);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(EzsSubstance ezsSubstance);

    public abstract List<EzsSubstance> query(String paramString, Map paramMap, int paramInt1, int paramInt2);

}
