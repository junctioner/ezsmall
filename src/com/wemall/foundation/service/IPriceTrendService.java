package com.wemall.foundation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Dict;
import com.wemall.foundation.domain.PriceTrend;

public interface IPriceTrendService {
    public abstract boolean save(PriceTrend param);

    public abstract PriceTrend getObjById(Long paramLong);

    public abstract boolean delete(Long paramLong);

    public abstract boolean batchDelete(List<Serializable> paramList);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(PriceTrend param);

    public abstract List<PriceTrend> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}
