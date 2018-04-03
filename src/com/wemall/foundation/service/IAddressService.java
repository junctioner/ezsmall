package com.wemall.foundation.service;

import java.util.List;
import java.util.Map;

import com.wemall.foundation.domain.Address;

public interface IAddressService {
	
	 List<Address>  query(String paramString, Map paramMap, int paramInt1, int paramInt2);

}
