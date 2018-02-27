package com.wemall.foundation.service;

import com.wemall.foundation.domain.EzsColumn;

public interface IEzsColumnService {
	public abstract boolean save(EzsColumn column);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(EzsColumn column);
}
