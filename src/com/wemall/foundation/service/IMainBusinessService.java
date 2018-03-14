package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.foundation.domain.MainBusiness;

public interface IMainBusinessService {
	public abstract List<MainBusiness> query(String paramString, Map paramMap, int paramInt1, int paramInt2);
}
