package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.foundation.domain.EzsColumn;

public interface IEzsColumnService {
	public abstract boolean save(EzsColumn column);

	public abstract boolean delete(Long paramLong);

	public abstract boolean update(EzsColumn column);
	
	List<EzsColumn> getAllEzsColumn();
	
	public List<EzsColumn> query(String query, Map params, int begin, int max);
}
