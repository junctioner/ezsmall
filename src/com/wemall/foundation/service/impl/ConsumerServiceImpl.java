package com.wemall.foundation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wemall.foundation.dao.ConsumerDAO;
import com.wemall.foundation.domain.Consumer;
import com.wemall.foundation.service.IConsumerService;
@Service
@Transactional
public class ConsumerServiceImpl implements IConsumerService{

	@Resource
	private ConsumerDAO consumerDao;

	@Override
	public boolean save(Consumer consumer) {
		try {
			this.consumerDao.save(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			this.consumerDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Consumer consumer) {
		try {
			this.consumerDao.update(consumer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
