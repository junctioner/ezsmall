package com.wemall.foundation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.foundation.domain.Accessory;
import com.wemall.foundation.domain.Address;
import com.wemall.foundation.service.IAddressService;
@Service
@Transactional
public class IAddressServiceImpl implements IAddressService {
	@Resource(name = "addressDao")
	private IGenericDAO<Address> addressDao;

	@Override
	public List<Address> query(String paramString, Map paramMap, int paramInt1, int paramInt2) {
		
			
			return this.addressDao.query(paramString, paramMap, paramInt1, paramInt2);
			
		
	}

}
