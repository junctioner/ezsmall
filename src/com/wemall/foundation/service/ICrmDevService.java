package com.wemall.foundation.service;

import com.wemall.foundation.domain.CrmDev;

public interface ICrmDevService {
	public abstract boolean save(CrmDev dev);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(CrmDev dev);
}
