package com.wemall.foundation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.Dict;

public interface IDictService {
    public abstract boolean save(Dict paramArea);

    public abstract Dict getObjById(Long paramLong);

    public abstract boolean delete(Long paramLong);

    public abstract boolean batchDelete(List<Serializable> paramList);

    public abstract IPageList list(IQueryObject paramIQueryObject);

    public abstract boolean update(Dict paramArea);

    public abstract List<Dict> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}
