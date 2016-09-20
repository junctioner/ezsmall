package com.wemall.foundation.service;

import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.DeliveryLog;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IDeliveryLogService
{
  public abstract boolean save(DeliveryLog paramDeliveryLog);

  public abstract DeliveryLog getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Serializable> paramList);

  public abstract IPageList list(IQueryObject paramIQueryObject);

  public abstract boolean update(DeliveryLog paramDeliveryLog);

  public abstract List<DeliveryLog> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}



 
 