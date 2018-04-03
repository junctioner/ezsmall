package com.wemall.manage.admin.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wemall.foundation.domain.Address;
import com.wemall.manage.admin.dao.AddressDao;

public class TestAddress {
	private Object bean;
	


	@Before
	public void before() {
		ApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext-configuration.xml");
//		 context.getBean(name)
		bean =  context.getBean("addressDao", AddressDao.class);
	}

	@Test
	public void test() {
		List<Address> allAddress = ((AddressDao) bean).getAllAddress((long) 1);
		for (Address address : allAddress) {
			System.out.println(address.getMobile());
		}
		
	}

}
