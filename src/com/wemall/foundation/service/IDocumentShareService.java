package com.wemall.foundation.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.DocumentShare;

public abstract interface IDocumentShareService {
	
	 public abstract boolean save(DocumentShare documentShare);

	 public abstract DocumentShare getObjById(Long paramLong);

	 public abstract boolean delete(Long paramLong);

	 public abstract boolean batchDelete(List<Serializable> paramList);

	 public abstract IPageList list(IQueryObject paramIQueryObject);

	 public abstract boolean update(DocumentShare documentShare);

	 public abstract List<DocumentShare> query(String paramString, Map paramMap, int paramInt1, int paramInt2);

}
