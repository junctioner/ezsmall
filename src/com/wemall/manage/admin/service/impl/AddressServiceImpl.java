package com.wemall.manage.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.domain.Address;
import com.wemall.manage.admin.dao.AddressDao;
import com.wemall.manage.admin.service.AddressService;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private  AddressDao addressDao;

	@Override
	public List<Address> getAllAddress(Long id) {
		
		return addressDao.getAllAddress(id);
		
	}

}
